package com.tompy.threedog.spring.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.tompy.threedog.Constants;
import com.tompy.threedog.Util;
import com.tompy.threedog.spring.dao.TurnDAO;
import com.tompy.threedog.spring.model.Game;
import com.tompy.threedog.spring.model.GameLeader;
import com.tompy.threedog.spring.model.Leader;
import com.tompy.threedog.spring.model.LeaderType;
import com.tompy.threedog.spring.model.SideType;
import com.tompy.threedog.spring.model.Turn;
import com.tompy.threedog.spring.model.TurnAMPool;
import com.tompy.threedog.spring.model.TurnActivation;
import com.tompy.threedog.spring.model.TurnEfficiency;
import com.tompy.threedog.spring.model.TurnInitiative;

public class TurnServiceImpl implements TurnService
{
    private PlayerService playerService;
    private GameService gameService;
    private TurnDAO turnDAO;
    private LeaderService leaderService;
    private GamePlayerService gamePlayerService;
    private LookupService lookupService;

    private final int OFFSET = 3;
    protected final String[] hourDescription = { "0200 Night", "0500 Dawn", "0600", "0700", "0800", "0900", "1000", "1100", "1200", "1300", "1400", "1500", "1600", "1700", "1800",
            "1900 Dusk", "2000 Night", "2300 Night" };

    protected final Integer[][] emList = { { 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4 }, { 1, 2, 2, 3, 3, 3, 3, 3, 4, 4 } };

    @Override
    @Transactional
    public void setTurnEfficiencyBonus( int turnId, int corpsId )
    {
        Turn turn = turnDAO.getTurnById( turnId );

        for ( TurnEfficiency te : turn.getEfficiency() )
        {
            if ( te.getCorps().getId() == corpsId )
            {
                te.setEfficiencyValue( te.getEfficiencyValue() + 1 );
            }
        }

        turnDAO.saveTurn( turn );
    }

    @Override
    @Transactional
    public void setTurnActivationBonus( int turnId, int divisionId )
    {
        Turn turn = turnDAO.getTurnById( turnId );

        for ( TurnActivation ta : turn.getActivation() )
        {
            if ( ta.getDivision().getId() == divisionId )
            {
                ta.setActivationValue( ta.getActivationValue() + 1 );
            }
        }

        turnDAO.saveTurn( turn );
    }

    @Override
    @Transactional
    public List< TurnInitiative > getTurnInitiative( int turnId )
    {
        return turnDAO.getTurnInitiative( turnId );
    }

    @Override
    @Transactional
    public List< TurnEfficiency > getTurnEfficiency( int turnId )
    {
        return turnDAO.getTurnEfficiency( turnId );
    }

    @Override
    @Transactional
    public List< TurnActivation > getTurnActivation( int turnId )
    {
        return turnDAO.getTurnActivation( turnId );
    }

    @Override
    @Transactional
    public List< TurnAMPool > getTurnAMPool( int turnId )
    {
        return turnDAO.getTurnAMPool( turnId );
    }

    @Override
    @Transactional
    public Turn createNextTurn( int gameId )
    {
        Game game = gameService.getGameById( gameId );
        Turn turn = new Turn();

        turn.setGame( game );
        turn.setNumber( game.getCurrentTurn() );
        turn.setDescription( getDescription( turn.getNumber() ) );

        turnDAO.saveTurn( turn );

        return turn;
    }

    @Override
    @Transactional
    public void startCurrentTurn( int gameId, int playerId )
    {
        Game game = gameService.getGameById( gameId );
        SideType sideType = gamePlayerService.getSide( gameId, playerId );
        int side = sideType.getId();

        // Get current turn
        Turn tmpTurn = getCurrentTurn( gameId );
        Turn currentTurn = turnDAO.getTurnById( tmpTurn.getId() );
        TurnInitiative myInitiative = null;

        if ( null != currentTurn )
        {
            myInitiative = buildTurnDetails( game, currentTurn, side );

            rollInitiative( game, currentTurn, side, myInitiative );

            assignEM( currentTurn.getEfficiency(), side );

            turnDAO.saveTurn( currentTurn );

            // Set player state
            gamePlayerService.setState( gameId, playerId, lookupService.getStateType( Constants.GAME_STARTTURN ) );
        } // null != currentTurn

    }

    private TurnInitiative buildTurnDetails( Game game, Turn currentTurn, int side )
    {
        Set< TurnInitiative > turnInitiative = new HashSet< TurnInitiative >();
        Set< TurnEfficiency > turnEfficiency = new HashSet< TurnEfficiency >();
        Set< TurnActivation > turnActivation = new HashSet< TurnActivation >();
        TurnInitiative myInitiative = null;

        for ( GameLeader gl : game.getGameLeaders() )
        {
            Leader leader = gl.getLeader();
            if ( leader.getSide().getId() == side )
            {
                if ( leader.getRank().getId() == LeaderType.LEADER_TYPE_OVERALL )
                {
                    myInitiative = new TurnInitiative( leader, currentTurn );
                    turnInitiative.add( myInitiative );
                }
                else if ( leader.getRank().getId() == LeaderType.LEADER_TYPE_CORPS )
                {
                    turnEfficiency.add( new TurnEfficiency( leader, currentTurn ) );
                }
                if ( leader.getRank().getId() == LeaderType.LEADER_TYPE_DIVISION )
                {
                    turnActivation.add( new TurnActivation( leader, currentTurn ) );
                }
            } // leader == side
        } // gameLeaders

        currentTurn.setInitiative( turnInitiative );
        currentTurn.setEfficiency( turnEfficiency );
        currentTurn.setActivation( turnActivation );

        return myInitiative;

    }

    private void assignEM( Set< TurnEfficiency > efficiencies, int side )
    {
        List< Integer > emPool = new ArrayList< Integer >();
        Arrays.asList( emList[ side - 1 ] ).forEach( ( em )->emPool.add( em ) );

        for ( TurnEfficiency efficiency : efficiencies )
        {
            int em = Util.randomInt( 0, emPool.size() );
            efficiency.setEfficiencyValue( emPool.get( em ) );
            emPool.remove( em );
        }

    }

    @Override
    @Transactional
    public Turn getCurrentTurn( int gameId )
    {
        Turn returnValue = null;

        Game game = gameService.getGameById( gameId );

        for ( Turn t : game.getTurns() )
        {
            if ( t.getNumber() == game.getCurrentTurn() )
            {
                returnValue = t;
                break;
            }
        }

        return returnValue;
    }

    @Override
    @Transactional
    public void setDivisionActivation( int turnId, int divisionId, int count )
    {
        Turn turn = turnDAO.getTurnById( turnId );

        for ( TurnActivation ta : turn.getActivation() )
        {
            if ( ta.getDivision().getId() == divisionId )
            {
                ta.setActivationValue( count );
            }
        }
        
        turnDAO.saveTurn( turn );

    }

    private void rollInitiative( Game game, Turn turn, int side, TurnInitiative myInitiative )
    {
        int currentNumber = turn.getNumber();
        int mySideInit = 0;
        int otherSideInit = 0;

        // Do something different on the first turn...
        if ( currentNumber > 1 )
        {
            for ( Turn t : game.getTurns() )
            {
                // Always 2 Initiatives
                for ( TurnInitiative ti : t.getInitiative() )
                {
                    if ( ti.getOverall().getSide().getId() == side )
                    {
                        mySideInit = ti.getInitiativeValue();
                    }
                    else
                    {
                        otherSideInit = ti.getInitiativeValue();
                    }
                } // looping through initiatives.
            } // looping through turns.
        } // skip on first turn

        calculateInitiative( ( mySideInit > otherSideInit ? 1 : 0 ), currentNumber, myInitiative, game );

    }

    private void calculateInitiative( int lastTurnModifier, int currentNumber, TurnInitiative myInit, Game game )
    {
        // Roll Initiative
        Random rand = new Random( System.currentTimeMillis() );
        int finalInitValue = rand.nextInt( 9 ) + lastTurnModifier;

        if ( myInit.getOverall().getTurnOfEntry() > currentNumber &&
                gameService.getLeaderInfo( game, myInit.getOverall() ).getInCommand().equals( "Y" ) )
        {
            finalInitValue += myInit.getOverall().getInitiativeRating();
        }

        myInit.setInitiativeValue( finalInitValue );
    }

    @Override
    public String getDescription( int current )
    {
        String returnValue = "";

        int day = ( ( current + OFFSET ) / hourDescription.length ) + 1;

        System.out.println( day );

        returnValue = "July " + day + ", 1863 @ " + hourDescription[ ( ( current + OFFSET ) % hourDescription.length ) - 1 ];

        return returnValue;
    }

    public void setPlayerService( PlayerService playerService )
    {
        this.playerService = playerService;
    }

    public void setGameService( GameService gameService )
    {
        this.gameService = gameService;
    }

    public void setTurnDAO( TurnDAO turnDAO )
    {
        this.turnDAO = turnDAO;
    }

    public void setLeaderService( LeaderService leaderService )
    {
        this.leaderService = leaderService;
    }

    public void setGamePlayerService( GamePlayerService gamePlayerService )
    {
        this.gamePlayerService = gamePlayerService;
    }

    public void setLookupService( LookupService lookupService )
    {
        this.lookupService = lookupService;
    }

}

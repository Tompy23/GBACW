package com.tompy.threedog.spring.service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.tompy.threedog.spring.dao.TurnDAO;
import com.tompy.threedog.spring.model.Game;
import com.tompy.threedog.spring.model.GameLeader;
import com.tompy.threedog.spring.model.Leader;
import com.tompy.threedog.spring.model.LeaderType;
import com.tompy.threedog.spring.model.Player;
import com.tompy.threedog.spring.model.SideType;
import com.tompy.threedog.spring.model.Turn;
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

    private final int OFFSET = 3;
    private final String[] hourDescription = { "0200 Night", "0500 Dawn", "0600", "0700", "0800", "0900", "1000", "1100", "1200", "1300", "1400", "1500", "1600", "1700", "1800",
            "1900 Dusk", "2000 Night", "2300 Night" };

    @Override
    @Transactional
    public Turn createNextTurn( Game game, List< Leader > leaderList )
    {
        Turn turn = new Turn();

        turn.setGame( game );
        turn.setNumber( game.getCurrentTurn() );
        turn.setDescription( getDescription( turn.getNumber() ) );

        turnDAO.saveTurn( turn );

        return turn;
    }

    @Override
    @Transactional
    public Turn startCurrentTurn( Game game, String playerName )
    {
        Player player = playerService.getPlayerByName( playerName );
        SideType sideType = gamePlayerService.getSide( game, player );
        int side = sideType.getId();

        // Get current turn
        Turn tmpTurn = getCurrentTurn( game.getTurns(), game.getCurrentTurn() );
        Turn currentTurn = turnDAO.getTurnById( tmpTurn.getId() );
        TurnInitiative myInitiative = null;

        if ( null != currentTurn )
        {
            Set< TurnInitiative > turnInitiative = new HashSet< TurnInitiative >();
            Set< TurnEfficiency > turnEfficiency = new HashSet< TurnEfficiency >();
            Set< TurnActivation > turnActivation = new HashSet< TurnActivation >();
            Set< GameLeader > gameLeaders = game.getGameLeaders();

            for ( GameLeader gl : gameLeaders )
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
                }
            }

            // turnDAO.saveTurn( currentTurn );

            currentTurn.setInitiative( turnInitiative );
            currentTurn.setEfficiency( turnEfficiency );
            currentTurn.setActivation( turnActivation );

            rollInitiative( game, currentTurn, side, myInitiative );

            turnDAO.saveTurn( currentTurn );
        }

        return currentTurn;
        // Roll initiative
        // return executeInitiative( game, currentTurn );

    }

    private Turn getCurrentTurn( Set< Turn > turns, int currentTurnNumber )
    {
        Turn returnValue = null;

        for ( Turn t : turns )
        {
            if ( t.getNumber() == currentTurnNumber )
            {
                returnValue = t;
                break;
            }
        }

        return returnValue;
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

}

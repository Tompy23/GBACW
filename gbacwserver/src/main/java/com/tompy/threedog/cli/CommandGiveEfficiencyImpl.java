package com.tompy.threedog.cli;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tompy.threedog.Command;
import com.tompy.threedog.CommandAbstract;
import com.tompy.threedog.Constants;
import com.tompy.threedog.spring.model.GameLeader;
import com.tompy.threedog.spring.model.Leader;
import com.tompy.threedog.spring.model.SideType;
import com.tompy.threedog.spring.model.StateType;
import com.tompy.threedog.spring.model.Turn;
import com.tompy.threedog.spring.model.TurnActivation;
import com.tompy.threedog.spring.model.TurnEfficiency;

public class CommandGiveEfficiencyImpl extends CommandAbstract implements Command
{
    Logger log = LogManager.getLogger( CommandGiveEfficiencyImpl.class );

    @Override
    public String doCommand( int gameId, int playerId, String[] args )
    {
        String returnValue = "Give Efficiency Bonus failed.";

        StateType state = gamePlayerService.getState( gameId, playerId );
        if ( Constants.GAME_STARTTURN_INITIATIVE == state.getId() )
        {
            SideType side = gamePlayerService.getSide( gameId, playerId );
            Turn turn = turnService.getCurrentTurn( gameId );

            assignActivations( turn, gameId, playerId );

            for ( TurnEfficiency te : turnService.getTurnEfficiency( turn.getId() ) )
            {
                StringBuilder sb = new StringBuilder();
                Leader corps = te.getCorps();
                GameLeader glc = gameLeaderService.getGameLeader( gameId, corps.getId() );
                if ( side.getId() == corps.getSide().getId() && corps.getEfficiencyRating() > 0 && "Y".equals( glc.getInCommand() ) )
                {
                    for ( int i = 0; i < corps.getEfficiencyRating(); i++ )
                    {
                        for ( TurnActivation ta : turnService.getTurnActivation( turn.getId() ) )
                        {
                            Leader division = ta.getDivision();
                            GameLeader gld = gameLeaderService.getGameLeader( gameId, division.getId() );
                            if ( side.getId() == division.getSide().getId() && ta.getActivationValue() < 4 && "Y".equals( gld.getInCommand() ) )
                            {
                                sb.append( division.getName() + " [" + ta.getActivationValue() + "] (" + division.getId() + ")\n" );
                            }
                        } // Turn Activation
                        System.out.println( sb.toString() );
                        String corpsIdInput = this.controller.getInput( "Initiative Bonus #: " );
                        turnService.setTurnActivationBonus( turn.getId(), Integer.valueOf( corpsIdInput ) );
                    } // Corps Efficiency Rating
                } // Corps is eligible
            } // Turn Efficiency

            gamePlayerService.setState( gameId, playerId, lookupService.getStateType( Constants.GAME_ACTIVATION ) );
            returnValue = "Give Efficiency Bonus Success.";
        }
        else
        {
            returnValue = "Must have state: GAME_STARTTURN_INITIATIVE";
        }
        
        return returnValue;
    }

    private void assignActivations( Turn turn, int gameId, int playerId )
    {
        log.info( "Assigning Activations for turn [" + turn.getDescription() + "]." );

        SideType side = gamePlayerService.getSide( gameId, playerId );
        for ( TurnEfficiency te : turnService.getTurnEfficiency( turn.getId() ) )
        {
            Leader corps = te.getCorps();
            if ( corps.getSide().getId() == side.getId() )
            {
                log.debug( "Using Corps leader [" + corps.getName() + ", " + corps.getEfficiencyRating() + ", " + te.getEfficiencyValue() + "]." );
                for ( TurnActivation ta : turnService.getTurnActivation( turn.getId() ) )
                {
                    Leader division = ta.getDivision();
                    if ( division.getSide().getId() == side.getId() )
                    {
                        log.debug( "Using Division Leader [" + division.getName() + ", " + division.getActivationRating() + "]." );
                        for ( Leader sub : corps.getSubordinates() )
                        {
                            if ( sub.getId().intValue() == division.getId().intValue() )
                            {
                                log.debug( "Adding Activation [" + ( division.getActivationRating() + te.getEfficiencyValue() ) + "]." );
                                turnService.setDivisionActivation( turn.getId(), division.getId(), division.getActivationRating() + te.getEfficiencyValue() );
                                break;
                            }
                        } // sub leaders
                    } // Division is on players side
                } // turn activation
            } // Corps is on players side
        } // Turn efficiency
    }
}
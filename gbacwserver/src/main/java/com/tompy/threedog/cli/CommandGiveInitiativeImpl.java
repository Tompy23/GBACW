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
import com.tompy.threedog.spring.model.TurnEfficiency;
import com.tompy.threedog.spring.model.TurnInitiative;

public class CommandGiveInitiativeImpl extends CommandAbstract implements Command
{
    Logger log = LogManager.getLogger( CommandGiveInitiativeImpl.class );

    @Override
    public String doCommand( int gameId, int playerId, String[] args )
    {
        String returnValue = "Give Initiative Bonus failed.";
        log.info( "Giving Initiative." );
        StateType state = gamePlayerService.getState( gameId, playerId );
        if ( Constants.GAME_STARTTURN == state.getId() )
        {
            SideType side = gamePlayerService.getSide( gameId, playerId );
            Turn turn = turnService.getCurrentTurn( gameId );

            for ( TurnInitiative ti : turnService.getTurnInitiative( turn.getId() ) )
            {
                StringBuilder sb = new StringBuilder();
                Leader oc = ti.getOverall();
                GameLeader gl = gameLeaderService.getGameLeader( gameId, oc.getId() );
                if ( side.getId() == oc.getSide().getId() && oc.getInitiativeRating() > 0 && "Y".equals( gl.getInCommand() ) )
                {
                    log.debug( "Using Commander [" + oc.getName() + ", " + oc.getInitiativeRating() + "]." );
                    for ( TurnEfficiency te : turnService.getTurnEfficiency( turn.getId() ) )
                    {
                        Leader corps = te.getCorps();
                        log.debug( "Using Corps leader [" + corps.getName() + ", " + corps.getEfficiencyRating() + ", " + te.getEfficiencyValue() + "]." );
                        if ( side.getId() == corps.getSide().getId() && te.getEfficiencyValue() < 4 )
                        {
                            sb.append( corps.getName() + " [" + te.getEfficiencyValue() + "] (" + corps.getId() + ")\n" );
                        }
                    } // Turn efficiency
                    System.out.println( sb.toString() );
                    String corpsIdInput = this.controller.getInput( "Initiative Bonus #: " );
                    log.debug( "Choose: " + corpsIdInput );
                    turnService.setTurnEfficiencyBonus( turn.getId(), Integer.valueOf( corpsIdInput ) );
                } // Overall is eligible

            } // Turn initiative

            gamePlayerService.setState( gameId, playerId, lookupService.getStateType( Constants.GAME_STARTTURN_INITIATIVE ) );
            returnValue = "Give Initiative Bonus success.";
        }
        else
        {
            returnValue = "Must have status of GAME_ACTIVATION";
        }
        return returnValue;
    }

}

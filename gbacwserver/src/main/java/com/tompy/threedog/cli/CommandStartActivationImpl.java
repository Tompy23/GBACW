package com.tompy.threedog.cli;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tompy.threedog.Command;
import com.tompy.threedog.CommandAbstract;
import com.tompy.threedog.Constants;
import com.tompy.threedog.Util;
import com.tompy.threedog.spring.model.Player;
import com.tompy.threedog.spring.model.SideType;
import com.tompy.threedog.spring.model.StateType;
import com.tompy.threedog.spring.model.Turn;
import com.tompy.threedog.spring.model.TurnAMPool;
import com.tompy.threedog.spring.model.TurnInitiative;

public class CommandStartActivationImpl extends CommandAbstract implements Command
{
    Logger log = LogManager.getLogger( CommandStartActivationImpl.class );

    @Override
    public String doCommand( int gameId, int playerId, int opponentId, String[] args )
    {
        String returnValue = "Start Activation failed.";

        Player opponent = Util.findOpponent( gamePlayerService.getPlayers( gameId ), playerId );
        StateType state = gamePlayerService.getState( gameId, playerId );
        StateType oppState = gamePlayerService.getState( gameId, opponent.getId() );

        Turn turn = turnService.getCurrentTurn( gameId );

        if ( Constants.GAME_ACTIVATION == state.getId() && Constants.GAME_ACTIVATION == oppState.getId() )
        {
            // First thing is to check the AM Pool. If it is empty, build it.
            if ( 0 == turnService.getTurnAMPool( turn.getId() ).size() )
            {
                turnService.buildAMPool( turn.getId() );
            }

            // Check initiative
            List< TurnInitiative > inits = turnService.getTurnInitiative( turn.getId() );
            int playerInit = 0;
            int oppInit = 0;
            for ( TurnInitiative ti : inits )
            {
                if ( ti.getOverall().getSide().getId() == playerId )
                {
                    playerInit = ti.getInitiativeValue();
                }
                else
                {
                    oppInit = ti.getInitiativeValue();
                }
            }
            // display AM and choose 1.
            // You go active, and opponent goes inactive
            if ( playerInit > oppInit )
            {
                int amId = chooseInitialAM( turn, gamePlayerService.getSide( gameId, playerId ).getId() );
                
                turnService.setAM( turn.getId(), amId, "A" );

                gamePlayerService.setState( gameId, playerId, Constants.ACTIVATION_ACTIVE );
                gamePlayerService.setState( gameId, opponent.getId(), Constants.ACTIVATION_INACTIVE );
                returnValue = "You won initiative, you picked the AM to start, you may activate brigades.";
            }
            // do nothing.
            else if ( oppInit > playerInit )
            {
                returnValue = "You lost initiative, no change.";
            }
            // draw a random AM
            // player whose AM it is goes active, other inactive
            else
            {
                returnValue = "Initiative is tied.";

                TurnAMPool am = turnService.drawAM( turn.getId() );

                SideType playerSide = gamePlayerService.getSide( gameId, playerId );

                if ( am.getDivisionAM().getSide().getId() == playerSide.getId() )
                {
                    gamePlayerService.setState( gameId, playerId, Constants.ACTIVATION_ACTIVE );
                    gamePlayerService.setState( gameId, opponent.getId(), Constants.ACTIVATION_INACTIVE );
                    returnValue += "  Your AM was drawn.";

                }
                else
                {
                    gamePlayerService.setState( gameId, opponent.getId(), Constants.ACTIVATION_ACTIVE );
                    gamePlayerService.setState( gameId, playerId, Constants.ACTIVATION_INACTIVE );
                    returnValue += "  Your AM was not drawn.";
                }
            }
        }
        else
        {
            returnValue = "Need to be in state GAME_ACTIVATION";
        }

        return returnValue;
    }

    private int chooseInitialAM( Turn turn, int sideId )
    {
        StringBuilder sb = new StringBuilder();
        
        for ( TurnAMPool am : turnService.getUnpicked( turn.getId() ) )
        {
            if ( "N".equals( am.getPicked() ) && sideId == am.getDivisionAM().getSide().getId() )
            {
                sb.append( am.getDivisionAM().getName() + " (" + am.getId() + ")\n" );
            }
        }
        
        System.out.println(  sb.toString() );

        String amChoice = this.controller.getInput( "Choose AM#>" );
        
        return Integer.valueOf( amChoice );
    }
}

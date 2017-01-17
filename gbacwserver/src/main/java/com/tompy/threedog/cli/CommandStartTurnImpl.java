package com.tompy.threedog.cli;

import com.tompy.threedog.Command;
import com.tompy.threedog.CommandAbstract;
import com.tompy.threedog.Constants;
import com.tompy.threedog.spring.model.StateType;
import com.tompy.threedog.spring.model.Turn;
import com.tompy.threedog.spring.service.TurnService;

public class CommandStartTurnImpl extends CommandAbstract implements Command
{
    @Override
    public String doCommand( int gameId, int playerId, int opponentId, String[] args )
    {
        String returnValue = "Turn not started.";
        StateType playerState = gamePlayerService.getState( gameId, playerId );

        // Validate
        if ( args.length == 1 && playerState.getId() == Constants.GAME_TURN )
        {
            Turn turn = turnService.startCurrentTurn( gameId, playerId );
            if ( null != turn )
            {
                returnValue = "Turn [" + turn.getNumber() + ", " + turn.getDescription() + "]";
            }
        }

        return returnValue;
    }

    public void setTurnService( TurnService turnService )
    {
        this.turnService = turnService;
    }

}

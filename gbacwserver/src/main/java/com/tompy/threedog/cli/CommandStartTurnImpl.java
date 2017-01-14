package com.tompy.threedog.cli;

import com.tompy.threedog.Command;
import com.tompy.threedog.CommandAbstract;
import com.tompy.threedog.spring.model.Game;
import com.tompy.threedog.spring.model.Turn;
import com.tompy.threedog.spring.service.TurnService;

public class CommandStartTurnImpl extends CommandAbstract implements Command
{
    @Override
    public String doCommand( int gameId, int playerId, String[] args )
    {
        String returnValue = "";
        Game game = controller.getGame();

        // Validate
        //if ( args.length == 2 && ( game.getStatus() == Constants.TURN_NOT_STARTED ) || game.getStatus() == Constants.TURN_STARTED_TMP )
        {
            Turn turn = turnService.startCurrentTurn( game, args[ 1 ] );

            //gameService.setStatus( game, Constants.TURN_NOT_STARTED == game.getStatus() ? Constants.TURN_STARTED_TMP : Constants.TURN_STARTED );

        }
        //else
        {
          //  returnValue = "Start turn invalid command";
        }

        return returnValue;
    }

    public void setTurnService( TurnService turnService )
    {
        this.turnService = turnService;
    }

}

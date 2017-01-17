package com.tompy.threedog.cli;

import com.tompy.threedog.Command;
import com.tompy.threedog.CommandAbstract;
import com.tompy.threedog.Util;
import com.tompy.threedog.spring.model.Game;

public class CommandNewGameImpl extends CommandAbstract implements Command
{
    @Override
    public String doCommand( int gameId, int playerId, int opponentId, String[] args )
    {
        String returnValue = null;

        if ( args.length != 5 )
        {
            returnValue = "GAMESTART: Wrong number of parameters";
        }
        else
        {
            Game game = gameService.createGame( args[ 1 ], args[ 2 ], args[ 3 ], args[ 4 ] );
            controller.setGame( game );
            controller.setOpponent( Util.findOpponent( gamePlayerService.getPlayers( game.getId() ), playerId ) );
            returnValue = "Game [" + game.getDescription() + "] created";
        }

        return returnValue;
    }
}

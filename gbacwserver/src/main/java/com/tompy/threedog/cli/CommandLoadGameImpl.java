package com.tompy.threedog.cli;

import com.tompy.threedog.Command;
import com.tompy.threedog.CommandAbstract;
import com.tompy.threedog.spring.model.Game;

public class CommandLoadGameImpl extends CommandAbstract implements Command
{

    @Override
    public String doCommand( int gameId, int playerId, String[] args )
    {
        String returnValue = "";

        Game game = gameService.getGameById( Integer.parseInt( args[ 1 ] ) );
        if ( null != game )
        {
            this.controller.setGame( game );
            returnValue = "Game [" + game.getDescription() + "] loaded";
        }
        else
        {
            returnValue = "Game Id [" + args[ 1 ] + "] did not load.";
        }

        return returnValue;
    }
}

package com.tompy.threedog.cli;

import com.tompy.threedog.Command;
import com.tompy.threedog.CommandAbstract;
import com.tompy.threedog.spring.model.Player;

public class CommandLoginImpl extends CommandAbstract implements Command
{
    @Override
    public String doCommand( int gameId, int playerId, int opponentId, String[] args )
    {
        String returnValue = "Login failed.";
        
        Player player = playerService.getPlayerByName( args[ 1 ] );
        
        if ( null != player )
        {
            controller.setPlayer( player );
            returnValue = "User [" + player.getName() + "] logged in successfully.";
        }
        
        return returnValue;
    }

}

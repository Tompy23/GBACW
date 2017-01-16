package com.tompy.threedog.cli;

import com.tompy.threedog.Command;
import com.tompy.threedog.CommandAbstract;
import com.tompy.threedog.spring.model.Leader;

public class CommandSetCommandImpl extends CommandAbstract implements Command
{
    @Override
    public String doCommand( int gameId, int playerId, String[] args )
    {
        String returnValue = "Set InCommand failed.";
        
        int leaderId = Integer.parseInt( args[ 1 ] );

        gameLeaderService.setCommand( gameId, leaderId, Boolean.parseBoolean( args[ 2 ] ) ? "Y" : "N" );

        Leader l = leaderService.getLeader( leaderId );

        if ( null != l )
        {
            returnValue = "Leader [" + l.getName() + "] InCommand set to [" + ( Boolean.parseBoolean( args[ 2 ] ) ? "Yes" : "No" ) + "].";
        }

        return returnValue;
    }

}

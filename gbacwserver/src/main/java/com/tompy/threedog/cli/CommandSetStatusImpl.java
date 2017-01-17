package com.tompy.threedog.cli;

import com.tompy.threedog.Command;
import com.tompy.threedog.CommandAbstract;
import com.tompy.threedog.spring.model.Leader;

public class CommandSetStatusImpl extends CommandAbstract implements Command
{

    @Override
    public String doCommand( int gameId, int playerId, int opponentId, String[] args )
    {
        String returnValue = "Set Status failed.";

        int leaderId = Integer.parseInt( args[ 1 ] );

        gameLeaderService.setStatus( gameId, leaderId, Integer.valueOf( args[ 2 ] ) );

        Leader l = leaderService.getLeader( leaderId );

        if ( null != l )
        {
            returnValue = "Leader [" + l.getName() + "] Status set to ["
                    + lookupService.getStatusType( Integer.valueOf( args[ 2 ] ) ).getDescription() + "].";
        }

        return returnValue;
    }

}

package com.tompy.threedog.cli;

import com.tompy.threedog.Command;
import com.tompy.threedog.CommandAbstract;
import com.tompy.threedog.spring.model.Leader;

public class CommandSetFatigueImpl extends CommandAbstract implements Command
{

    @Override
    public String doCommand( int gameId, int playerId, int opponentId, String[] args )
    {
        String returnValue = "Set Fatigue failed.";

        int leaderId = Integer.parseInt( args[ 1 ] );

        gameLeaderService.setFatigue( gameId, leaderId, Integer.valueOf( args[ 2 ] ) );

        Leader l = leaderService.getLeader( leaderId );

        if ( null != l )
        {
            returnValue = "Leader [" + l.getName() + "] Fatigue set to ["
                    + Integer.valueOf( args[ 2 ] ) + "].";
        }

        return returnValue;
    }

}

package com.tompy.threedog.cli;

import com.tompy.threedog.Command;
import com.tompy.threedog.CommandAbstract;
import com.tompy.threedog.spring.model.Leader;

public class CommandSetOrdersImpl extends CommandAbstract implements Command
{

    @Override
    public String doCommand( int gameId, int playerId, String[] args )
    {
        String returnValue = "Set Orders failed.";

        int leaderId = Integer.parseInt( args[ 1 ] );

        gameLeaderService.setOrders( gameId, leaderId, Integer.valueOf( args[ 2 ] ) );

        Leader l = leaderService.getLeader( leaderId );

        if ( null != l )
        {
            returnValue = "Leader [" + l.getName() + "] Orders set to ["
                    + lookupService.getOrdersType( Integer.valueOf( args[ 2 ] ) ).getDescription() + "].";
        }

        return returnValue;
    }

}

package com.tompy.threedog.cli;

import com.tompy.threedog.Command;
import com.tompy.threedog.CommandAbstract;

public class CommandAddNotesImpl extends CommandAbstract implements Command
{

    @Override
    public String doCommand( int gameId, int playerId, int opponentId, String[] args )
    {
        String returnValue = "No notes added.";

        if ( args.length == 3 )
        {
            gameLeaderService.addNotes( gameId, Integer.valueOf( args[ 1 ] ), args[ 2 ] );
            String name = leaderService.getLeader( Integer.valueOf( args[ 1 ] ) ).getName();
            returnValue = "[" + name + "] added note " + args[ 2 ];
        }
        
        return returnValue;
    }

}

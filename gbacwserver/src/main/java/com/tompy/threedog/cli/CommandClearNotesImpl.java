package com.tompy.threedog.cli;

import com.tompy.threedog.Command;
import com.tompy.threedog.CommandAbstract;

public class CommandClearNotesImpl extends CommandAbstract implements Command
{

    @Override
    public String doCommand( int gameId, int playerId, int opponentId, String[] args )
    {
        String returnValue = "Notes not cleared.";

        if ( args.length == 2 )
        {
            gameLeaderService.clearNotes( gameId, Integer.valueOf( args[ 1 ] ) );
            String name = leaderService.getLeader( Integer.valueOf( args[ 1 ] ) ).getName();
            returnValue = "[" + name + "] cleared notes ";
        }
        
        return returnValue;
    }

}

package com.tompy.threedog.cli;

import com.tompy.threedog.Command;
import com.tompy.threedog.CommandAbstract;

public class CommandActivateImpl extends CommandAbstract implements Command
{

    @Override
    public String doCommand( int gameId, int playerId, int opponentId, String[] args )
    {
        String returnValue = "Activation failed.";

        if ( args.length == 4 )
        {
            turnService.activateBrigade( turnService.getCurrentTurn( gameId ).getId(), Integer.valueOf( args[ 1 ] ), Integer.valueOf( args[ 2 ] ), args[ 3 ] );

            returnValue = "[" + leaderService.getLeader( Integer.valueOf( args[ 1 ] ) ).getName() + "] activated [" + lookupService.getActivationType( Integer.valueOf( args[ 2 ])  ).getDescription() + "].";         
        }

        return returnValue;
    }

}

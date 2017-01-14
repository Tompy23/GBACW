package com.tompy.threedog.cli;

import com.tompy.threedog.Command;
import com.tompy.threedog.CommandAbstract;

public class CommandQuitImpl extends CommandAbstract implements Command
{

    @Override
    public String doCommand( int gameId, int playerId, String[] args )
    {
        controller.stop();
        return "Terminating application";
    }
}

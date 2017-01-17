package com.tompy.threedog.cli;

import com.tompy.threedog.Command;
import com.tompy.threedog.CommandAbstract;
import com.tompy.threedog.Constants;
import com.tompy.threedog.spring.model.TurnAMPool;

public class CommandNextAMImpl extends CommandAbstract implements Command
{

    @Override
    public String doCommand( int gameId, int playerId, int opponentId, String[] args )
    {
        String returnValue = "No AM drawn";

        TurnAMPool am = turnService.drawAM( turnService.getCurrentTurn( gameId ).getId() );
        if ( null == am )
        {
            returnValue = "No more AM in pool, please end the turn.";
        }
        else
        {
            returnValue = "[" + am.getDivisionAM().getName() + "] AM has been drawn.";
        }

        if ( null != am )
        {
            if ( am.getDivisionAM().getSide().getId() == playerId )
            {
                gamePlayerService.setState( gameId, playerId, Constants.ACTIVATION_ACTIVE );
                gamePlayerService.setState( gameId, opponentId, Constants.ACTIVATION_INACTIVE );
                returnValue += "  Your AM was drawn.";

            }
            else
            {
                gamePlayerService.setState( gameId, opponentId, Constants.ACTIVATION_ACTIVE );
                gamePlayerService.setState( gameId, playerId, Constants.ACTIVATION_INACTIVE );
                returnValue += "  Your AM was not drawn.";
            }
        }

        return returnValue;
    }

}

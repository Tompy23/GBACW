package com.tompy.threedog.cli;

import java.util.List;

import com.tompy.threedog.Command;
import com.tompy.threedog.CommandAbstract;
import com.tompy.threedog.Constants;
import com.tompy.threedog.spring.model.Player;
import com.tompy.threedog.spring.model.Turn;

public class CommandEndTurnImpl extends CommandAbstract implements Command
{

    @Override
    public String doCommand( int gameId, int playerId, int opponentId, String[] args )
    {
        String returnValue = "Turn was not ended.";
        

        // Create next turn
        Turn turn = turnService.createNextTurn( gameId );
        
        returnValue = "Turn [" + turn.getDescription() + "] created.";
        
        // assign to current game
        gameService.addNextTurn( gameId, turn.getId() );
        
        // set both players to GAME_TURN status
        List< Player > players = gamePlayerService.getPlayers( gameId );
        for ( Player p : players )
        {
            gamePlayerService.setState( gameId, p.getId(), Constants.GAME_TURN );
        }
        
        return returnValue;
    }

}

package com.tompy.threedog.cli;

import java.util.List;

import com.tompy.threedog.Command;
import com.tompy.threedog.CommandAbstract;
import com.tompy.threedog.Util;
import com.tompy.threedog.spring.model.Game;
import com.tompy.threedog.spring.model.GameLeader;
import com.tompy.threedog.spring.model.Leader;
import com.tompy.threedog.spring.model.Player;
import com.tompy.threedog.spring.model.SideType;

public class CommandListDetailsImpl extends CommandAbstract implements Command
{

    @Override
    public String doCommand( int gameId, int playerId, String[] args )
    {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbO = new StringBuilder();
        Game game = gameService.getGameById( gameId );

        List< GameLeader > gameLeaders = gameLeaderService.getGameLeaders( gameId );
        List< Player > players = gamePlayerService.getPlayers( game );

        Player player = playerService.getPlayerById( playerId );
        Player opponent = Util.findOpponent( players, player.getId() );

        SideType playerSide = gamePlayerService.getSide( game, player );

        // details
        sb.append( player.getName() );
        sb.append( "\n" );
        sbO.append( opponent.getName() );
        sbO.append( "\n" );

        // Get overall for both players
        for ( GameLeader gl : gameLeaders )
        {
            if ( gl.getLeader().getRank().getId() == 1 )
            {
                if ( gl.getLeader().getSide().getId() == playerSide.getId() )
                {
                   leaderDetails( sb, gl, gameLeaders );
                }
                else
                {
                    leaderDetails( sbO, gl, gameLeaders );
                }
            }
        }

        sbO.append( "\n\n" );
        sbO.append( sb );

        return sbO.toString();
    }

    private StringBuilder leaderDetails( StringBuilder text, GameLeader gameLeader, List< GameLeader > gameLeaders )
    {
        StringBuilder returnValue = text;

        Leader leader = gameLeader.getLeader();

        returnValue = printLeaderDetails( returnValue, gameLeader, leader );

        if ( leader.getSubordinates().isEmpty() )
        {
            return returnValue;
        }

        for ( Leader l : leader.getSubordinates() )
        {
            GameLeader gl = Util.getGameLeader( l.getId(), gameLeaders );
            if ( null != gl )
            {
                returnValue = leaderDetails( returnValue, gl, gameLeaders );
            }
        }

        return returnValue;
    }

    private StringBuilder printLeaderDetails( StringBuilder sb, GameLeader gl, Leader l )
    {

        sb.append( String.format( "%1$-" + l.getRank().getId() + "s", " " ) );
        sb.append( l.getName() );
        sb.append( " - " );
        sb.append( "Y".equals( gl.getInCommand() ) ? "In" : "Out of" );
        sb.append( " Command" );
        sb.append( "\n" );

        return sb;
    }

}

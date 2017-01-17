package com.tompy.threedog.cli;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.tompy.threedog.Command;
import com.tompy.threedog.CommandAbstract;
import com.tompy.threedog.spring.model.Game;
import com.tompy.threedog.spring.model.Player;
import com.tompy.threedog.spring.model.SideType;

public class CommandListGamesImpl extends CommandAbstract implements Command
{
    @Override
    public String doCommand( int gameId, int playerId, int opponentId, String[] args )
    {
        SideType union = lookupService.getSideType( "USA" );
        SideType confederate = lookupService.getSideType( "CSA" );

        StringBuilder sb = new StringBuilder();

        sb.append( "\nConfederate games:\n" );
        sb.append( createGameList( playerId, confederate ) );

        sb.append( "\nUnion games:\n" );
        sb.append( createGameList( playerId, union ) );

        return sb.toString();
    }

    private StringBuilder createGameList( int playerId, SideType side )
    {
        StringBuilder returnValue = new StringBuilder();
        String opponent = "unknown";

        List< Game > gameList = new ArrayList< Game >();
        for ( Game g : gamePlayerService.getGamesBySide( playerId, side.getId() ) )
        {
            gameList.add( g );
        }
        Collections.sort( gameList );
        for ( Game g : gameList )
        {
            for ( Player p : gamePlayerService.getPlayers( g.getId() ) )
            {
                if ( p.getId() != playerId )
                {
                    opponent = p.getName();
                    break;
                }
            }
            returnValue.append( g.getId() + " : " + g.getDescription() + " vs. " + opponent );
            returnValue.append( "\n" );
        }

        return returnValue;

    }

}

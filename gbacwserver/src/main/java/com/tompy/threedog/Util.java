package com.tompy.threedog;

import java.util.List;

import com.tompy.threedog.spring.model.GameLeader;
import com.tompy.threedog.spring.model.Player;

public class Util
{

    public static Player findOpponent( List< Player > players, int playerId)
    {
        Player returnValue = null;
        
        for ( Player p : players )
        {
            if ( p.getId() != playerId )
            {
                returnValue = p;
                break;
            }
        } // players

        return returnValue;
    }


    public static GameLeader getGameLeader( int leaderId, List< GameLeader > gameLeaders )
    {
        for ( GameLeader gl : gameLeaders )
        {
            if ( gl.getLeader().getId() == leaderId )
            {
                return gl;
            }
        }
        
        return null;
    }
}

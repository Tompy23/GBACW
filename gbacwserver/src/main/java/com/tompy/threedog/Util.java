package com.tompy.threedog;

import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tompy.threedog.spring.model.GameLeader;
import com.tompy.threedog.spring.model.Leader;
import com.tompy.threedog.spring.model.Player;
import com.tompy.threedog.spring.model.TurnAMPool;
import com.tompy.threedog.spring.model.TurnActivation;
import com.tompy.threedog.spring.model.TurnEfficiency;
import com.tompy.threedog.spring.model.TurnInitiative;

public class Util
{
    private static Random rand = new Random( System.currentTimeMillis() );
    
    private static Logger log = LogManager.getLogger( Util.class );

    public static Player findOpponent( List< Player > players, int playerId )
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

    public static int getInitiative( List< TurnInitiative > initiatives, Leader l )
    {
        for ( TurnInitiative ti : initiatives )
        {
            if ( ti.getOverall().getId().intValue() == l.getId().intValue() )
            {
                return ti.getInitiativeValue();
            }
        }

        return 0;
    }

    public static int getEfficiency( List< TurnEfficiency > efficiencies, Leader l )
    {
        for ( TurnEfficiency te : efficiencies )
        {
            if ( te.getCorps().getId().intValue() == l.getId().intValue() )
            {
                return te.getEfficiencyValue();
            }
        }

        return 0;
    }

    public static String getActivations( List< TurnActivation > activations, Leader l, List< TurnAMPool > amPool )
    {
        String returnValue = "0/0";
        int total = 0;
        int used = 0;
        String active = "";
        
        log.debug( "Getting Activations for " + l.getName() );
        for ( TurnAMPool am : amPool )
        {
            log.debug( am.getDivisionAM().getName() );
            if ( am.getDivisionAM().getId().intValue() == l.getId().intValue() )
            {
                total++;
                if ( "Y".equals( am.getPicked() ) )
                {
                    used++;
                }
                if ( "A".equals( am.getPicked() ))
                {
                    active = "*";
                }
            }
        }

        returnValue = "" + used + "/" + total + active;

        return returnValue;
    }
    
    public static String getCurrentAM( List< TurnAMPool> amPool)
    {
        for ( TurnAMPool am : amPool)
        {
            if ( "A".equals( am.getPicked() ) )
            {
                return am.getDivisionAM().getName();
            }
        }
        return "";
    }

    public static int randomInt( int bottom, int top )
    {
        return rand.nextInt( top - bottom ) + bottom;
    }
}

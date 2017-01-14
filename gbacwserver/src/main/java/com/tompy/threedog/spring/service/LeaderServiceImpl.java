package com.tompy.threedog.spring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.tompy.threedog.spring.dao.LeaderDAO;
import com.tompy.threedog.spring.model.Leader;

public class LeaderServiceImpl implements LeaderService
{
    private LeaderDAO leaderDAO;

    @Override
    @Transactional
    public List< Leader > getLeadersForTurn( int currentTurn )
    {
        List< Leader > records = leaderDAO.getLeaders();
        Map< Integer, Leader > leaderMap = new HashMap< Integer, Leader >();

        // Filter leaders based on turn of entry and their superiors
        for ( Leader leader : records )
        {
            if ( leader.getTurnOfEntry() <= currentTurn )
            {
                leaderMap.put( leader.getId(), leader );

                Leader superior = leader;
                while ( null != superior.getSuperior() )
                {
                    superior = superior.getSuperior();
                    if ( !leaderMap.containsKey( superior.getId() ) )
                    {
                        leaderMap.put( superior.getId(), superior );
                    }
                }
            }
        }

        List< Leader > returnValue = new ArrayList< Leader >();

        returnValue.addAll( leaderMap.values() );

        return returnValue;
    }

    @Override
    @Transactional
    public Leader getLeader( int leaderId )
    {
        return leaderDAO.getLeader( leaderId );
    }

    public void setLeaderDAO( LeaderDAO leaderDAO )
    {
        this.leaderDAO = leaderDAO;
    }

}

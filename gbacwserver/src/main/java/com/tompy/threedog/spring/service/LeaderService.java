package com.tompy.threedog.spring.service;

import java.util.List;

import com.tompy.threedog.spring.model.Leader;

public interface LeaderService
{
    public Leader getLeader( int leaderId );

    public List< Leader > getLeadersForTurn( int currentTurn );
}

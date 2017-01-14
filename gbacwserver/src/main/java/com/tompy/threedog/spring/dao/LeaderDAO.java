package com.tompy.threedog.spring.dao;

import java.util.List;

import com.tompy.threedog.spring.model.Leader;

public interface LeaderDAO
{
    public Leader getLeader( int leaderId );
    
    public List< Leader > getLeaders();
}

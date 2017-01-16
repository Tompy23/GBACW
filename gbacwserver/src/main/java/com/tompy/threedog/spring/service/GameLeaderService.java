package com.tompy.threedog.spring.service;

import java.util.List;

import com.tompy.threedog.spring.model.GameLeader;

public interface GameLeaderService
{
    public void setCommand( int gameId, int leaderId, String command );

    public void setFatigue( int gameId, int leaderId, int fatigue );

    public void setOrders( int gameId, int leaderId, int orders );

    public void setStatus( int gameId, int leaderId, int status );

    public List< GameLeader > getGameLeaders( int gameId );

    public GameLeader getGameLeader( int gameId, int leaderId );
}

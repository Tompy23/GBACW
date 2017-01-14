package com.tompy.threedog.spring.service;

import java.util.List;

import com.tompy.threedog.spring.model.GameLeader;

public interface GameLeaderService
{
    public void setCommand( int gameId, int leaderId, String command );

    public List< GameLeader > getGameLeaders( int gameId );
    
    public GameLeader getGameLeader( int gameId, int leaderId );
}

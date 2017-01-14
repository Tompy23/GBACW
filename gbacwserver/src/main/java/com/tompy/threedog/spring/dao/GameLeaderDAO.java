package com.tompy.threedog.spring.dao;

import java.util.List;

import com.tompy.threedog.spring.model.GameLeader;

public interface GameLeaderDAO
{
    public GameLeader getGameLeader( int gameId, int leaderId );

    public List< GameLeader > getGameLeaders( int gameId );

    public void saveGameLeader( GameLeader gl );
}

package com.tompy.threedog.spring.service;

import java.util.List;

import com.tompy.threedog.spring.model.Game;
import com.tompy.threedog.spring.model.Player;
import com.tompy.threedog.spring.model.SideType;
import com.tompy.threedog.spring.model.StateType;

public interface GamePlayerService
{
    public SideType getSide( int gameId, int playerId );

    public StateType getState( int gameId, int playerId );

    public List< Game > getGamesBySide( int playerId, int sideId );

    public List< Player > getPlayers( int gameId );

    public Player getPlayerBySide( int gameId, int sideId );

    public void setState( int gameId, int playerId, int stateId );
}

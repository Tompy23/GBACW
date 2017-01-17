package com.tompy.threedog.spring.dao;

import java.util.List;

import com.tompy.threedog.spring.model.Game;
import com.tompy.threedog.spring.model.GamePlayer;
import com.tompy.threedog.spring.model.Player;
import com.tompy.threedog.spring.model.SideType;
import com.tompy.threedog.spring.model.StateType;

public interface GamePlayerDAO
{
    public SideType getSide( int gameId, int playerId );

    public StateType getState( int gameId, int playerId );

    public List< Game > getGames( int playerId, int sideId );

    public List< Player > getPlayers( int gameId );
    
    public Player getPlayerBySide( int gameId, int sideId );

    public void setSide( int gameId, int playerId, String s );
    
    public GamePlayer getGamePlayer( int gameId, int playerId  );

    public void saveGamePlayer( GamePlayer gps );

}

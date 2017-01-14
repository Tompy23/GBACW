package com.tompy.threedog.spring.dao;

import java.util.List;

import com.tompy.threedog.spring.model.Game;
import com.tompy.threedog.spring.model.GamePlayer;
import com.tompy.threedog.spring.model.Player;
import com.tompy.threedog.spring.model.SideType;

public interface GamePlayerDAO
{
    public SideType getSide( Game g, Player p );

    public List< Game > getGames( Player p, SideType s );

    public List< Player > getPlayers( Game g );

    public void setSide( Game g, Player p, String s );

    public void saveGamePlayerSide( GamePlayer gps );

}

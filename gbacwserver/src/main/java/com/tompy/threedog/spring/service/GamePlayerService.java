package com.tompy.threedog.spring.service;

import java.util.List;

import com.tompy.threedog.spring.model.Game;
import com.tompy.threedog.spring.model.Player;
import com.tompy.threedog.spring.model.SideType;
import com.tompy.threedog.spring.model.StateType;

public interface GamePlayerService
{
    public SideType getSide( Game g, Player p );

    public List< Game > getGamesBySide( Player p, SideType s );

    public List< Player > getPlayers( Game g );
    
    public void setState( Game g, Player p, StateType s );
}

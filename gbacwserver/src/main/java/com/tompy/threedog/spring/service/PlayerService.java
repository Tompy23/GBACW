package com.tompy.threedog.spring.service;

import com.tompy.threedog.spring.model.Player;

public interface PlayerService
{
    public Player getPlayerByName( String name );

    public Player getPlayerById( int id );
}

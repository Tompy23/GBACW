package com.tompy.threedog.spring.dao;

import com.tompy.threedog.spring.model.Player;

public interface PlayerDAO
{
    public Player getPlayerByName( String name );

    public Player getPlayerById( int id );
}

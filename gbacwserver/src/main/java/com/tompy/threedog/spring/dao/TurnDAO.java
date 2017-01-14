package com.tompy.threedog.spring.dao;

import com.tompy.threedog.spring.model.Turn;

public interface TurnDAO
{
    public Turn getTurnById( int id );

    public void saveTurn( Turn turn );
}

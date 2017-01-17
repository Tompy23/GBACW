package com.tompy.threedog.spring.dao;

import com.tompy.threedog.spring.model.Game;

public interface GameDAO
{
    public void saveGame( Game game );

    public Game getGameById( int gameId );

    public Game getGameByName( String gameName );

}

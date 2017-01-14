package com.tompy.threedog.spring.dao;

import com.tompy.threedog.spring.model.Game;
import com.tompy.threedog.spring.model.Player;

public interface GameDAO
{
    public void saveGame( Game game );

    public Game getGameById( int gameId );
}

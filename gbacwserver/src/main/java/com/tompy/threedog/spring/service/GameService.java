package com.tompy.threedog.spring.service;

import com.tompy.threedog.spring.model.Game;

public interface GameService
{
    public Game createGame( String unionPlayerName, String confederatePlayerName, String description, String controlStatus );

    public void addNextTurn( int gameId, int turnId );

    public Game getGameById( int gameId );

}

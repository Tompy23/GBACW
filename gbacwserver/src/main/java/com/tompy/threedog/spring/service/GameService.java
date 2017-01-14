package com.tompy.threedog.spring.service;

import com.tompy.threedog.spring.model.Game;
import com.tompy.threedog.spring.model.GameLeader;
import com.tompy.threedog.spring.model.Leader;
import com.tompy.threedog.spring.model.Turn;

public interface GameService
{
    public Game createGame( String unionPlayerName, String confederatePlayerName, String description, String controlStatus );

    public Game addNextTurn( Turn turn );

    public Game getGameById( int gameId );

    public GameLeader getLeaderInfo( Game g, Leader l );

}

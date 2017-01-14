package com.tompy.threedog.spring.service;

import java.util.List;

import com.tompy.threedog.spring.model.Game;
import com.tompy.threedog.spring.model.Leader;
import com.tompy.threedog.spring.model.Turn;

public interface TurnService
{
    public Turn createNextTurn( Game game, List< Leader > leaderList );

    public Turn startCurrentTurn( Game game, String playerName );
}

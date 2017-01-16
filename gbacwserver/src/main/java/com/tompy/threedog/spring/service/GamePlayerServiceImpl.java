package com.tompy.threedog.spring.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.tompy.threedog.spring.dao.GamePlayerDAO;
import com.tompy.threedog.spring.model.Game;
import com.tompy.threedog.spring.model.GamePlayer;
import com.tompy.threedog.spring.model.Player;
import com.tompy.threedog.spring.model.SideType;
import com.tompy.threedog.spring.model.StateType;

public class GamePlayerServiceImpl implements GamePlayerService
{
    private GamePlayerDAO gamePlayerDAO;

    @Override
    @Transactional
    public SideType getSide( int gameId, int playerId )
    {
        return gamePlayerDAO.getSide( gameId, playerId );
    }

    @Override
    @Transactional
    public StateType getState( int gameId, int playerId )
    {
        return gamePlayerDAO.getState( gameId, playerId );
    }
    
    @Override
    @Transactional
    public List< Game > getGamesBySide( int playerId, int sideId )
    {
        return gamePlayerDAO.getGames( playerId, sideId );
    }

    @Override
    @Transactional
    public List< Player > getPlayers( int gameId )
    {
        return gamePlayerDAO.getPlayers( gameId );
    }

    @Override
    @Transactional
    public void setState( int gameId, int playerId, StateType s )
    {
        GamePlayer gp = gamePlayerDAO.getGamePlayer( gameId, playerId );

        gp.setState( s );

        gamePlayerDAO.saveGamePlayer( gp );
    }

    public void setGamePlayerDAO( GamePlayerDAO gamePlayerDAO )
    {
        this.gamePlayerDAO = gamePlayerDAO;
    }



}

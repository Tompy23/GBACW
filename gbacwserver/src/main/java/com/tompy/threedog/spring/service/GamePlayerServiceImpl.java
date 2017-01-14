package com.tompy.threedog.spring.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.tompy.threedog.spring.dao.GamePlayerDAO;
import com.tompy.threedog.spring.model.Game;
import com.tompy.threedog.spring.model.Player;
import com.tompy.threedog.spring.model.SideType;
import com.tompy.threedog.spring.model.StateType;

public class GamePlayerServiceImpl implements GamePlayerService
{
    private GamePlayerDAO gamePlayerDAO;

    @Override
    @Transactional
    public SideType getSide( Game g, Player p )
    {
        return gamePlayerDAO.getSide( g, p );
    }

    @Override
    @Transactional
    public List< Game > getGamesBySide( Player p, SideType s )
    {
        return gamePlayerDAO.getGames( p, s );
    }

    @Override
    @Transactional
    public List< Player > getPlayers( Game g )
    {
        return gamePlayerDAO.getPlayers( g );
    }

    @Override
    @Transactional
    public void setState( Game g, Player p, StateType s )
    {
        // TODO Auto-generated method stub

    }

    public void setGamePlayerDAO( GamePlayerDAO gamePlayerDAO )
    {
        this.gamePlayerDAO = gamePlayerDAO;
    }

}

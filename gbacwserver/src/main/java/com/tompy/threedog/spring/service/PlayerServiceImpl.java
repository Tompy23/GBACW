package com.tompy.threedog.spring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tompy.threedog.spring.dao.PlayerDAO;
import com.tompy.threedog.spring.model.Player;

@Service
public class PlayerServiceImpl implements PlayerService
{
    private PlayerDAO playerDAO = null;

    @Override
    @Transactional
    public Player getPlayerByName( String name )
    {
        return playerDAO.getPlayerByName( name );
    }

    @Override
    @Transactional
    public Player getPlayerById( int id )
    {
        return playerDAO.getPlayerById( id );
    }

    public void setPlayerDAO( PlayerDAO playerDAO )
    {
        this.playerDAO = playerDAO;
    }

}

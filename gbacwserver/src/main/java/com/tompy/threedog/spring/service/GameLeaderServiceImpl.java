package com.tompy.threedog.spring.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.tompy.threedog.spring.dao.GameLeaderDAO;
import com.tompy.threedog.spring.model.GameLeader;

public class GameLeaderServiceImpl implements GameLeaderService
{
    private GameLeaderDAO gameLeaderDAO;

    @Override
    @Transactional
    public void setCommand( int gameId, int leaderId, String command )
    {
        GameLeader gl = gameLeaderDAO.getGameLeader( gameId, leaderId );

        gl.setInCommand( command );

        gameLeaderDAO.saveGameLeader( gl );
    }

    @Override
    @Transactional
    public List< GameLeader > getGameLeaders( int gameId )
    {
        return gameLeaderDAO.getGameLeaders( gameId );
    }

    public void setGameLeaderDAO( GameLeaderDAO gameLeaderDAO )
    {
        this.gameLeaderDAO = gameLeaderDAO;
    }

    @Override
    public GameLeader getGameLeader( int gameId, int leaderId )
    {
        return gameLeaderDAO.getGameLeader( gameId, leaderId );
    }

}

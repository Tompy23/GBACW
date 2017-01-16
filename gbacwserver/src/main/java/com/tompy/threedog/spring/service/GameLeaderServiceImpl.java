package com.tompy.threedog.spring.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.tompy.threedog.spring.dao.GameLeaderDAO;
import com.tompy.threedog.spring.dao.OrdersTypeDAO;
import com.tompy.threedog.spring.dao.StatusTypeDAO; 
import com.tompy.threedog.spring.model.GameLeader;

public class GameLeaderServiceImpl implements GameLeaderService
{
    private GameLeaderDAO gameLeaderDAO;
    private OrdersTypeDAO ordersTypeDAO;
    private StatusTypeDAO statusTypeDAO;

    public void setOrdersTypeDAO( OrdersTypeDAO ordersTypeDAO )
    {
        this.ordersTypeDAO = ordersTypeDAO;
    }

    public void setStatusTypeDAO( StatusTypeDAO statusTypeDAO )
    {
        this.statusTypeDAO = statusTypeDAO;
    }

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
    public void setFatigue( int gameId, int leaderId, int fatigue )
    {
        GameLeader gl = gameLeaderDAO.getGameLeader( gameId, leaderId );

        gl.setFatigue( fatigue );

        gameLeaderDAO.saveGameLeader( gl );
    }

    @Override
    @Transactional
    public void setOrders( int gameId, int leaderId, int orders )
    {
        GameLeader gl = gameLeaderDAO.getGameLeader( gameId, leaderId );

        gl.setOrders( ordersTypeDAO.getOrdersType( orders ) );

        gameLeaderDAO.saveGameLeader( gl );
    }

    @Override
    @Transactional
    public void setStatus( int gameId, int leaderId, int status )
    {
        GameLeader gl = gameLeaderDAO.getGameLeader( gameId, leaderId );

        gl.setStatus( statusTypeDAO.getStatusType( status ) );

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
    @Transactional
    public GameLeader getGameLeader( int gameId, int leaderId )
    {
        return gameLeaderDAO.getGameLeader( gameId, leaderId );
    }

}

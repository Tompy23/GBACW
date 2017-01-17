package com.tompy.threedog.spring.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.tompy.threedog.spring.dao.GameLeaderDAO;
import com.tompy.threedog.spring.dao.OrdersTypeDAO;
import com.tompy.threedog.spring.dao.StatusTypeDAO;
import com.tompy.threedog.spring.model.GameLeader;
import com.tompy.threedog.spring.model.OrdersType;
import com.tompy.threedog.spring.model.StatusType;

public class GameLeaderServiceImpl implements GameLeaderService
{
    private GameLeaderDAO gameLeaderDAO;
    private OrdersTypeDAO ordersTypeDAO;
    private StatusTypeDAO statusTypeDAO;

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

    @Override
    @Transactional
    public GameLeader getGameLeader( int gameId, int leaderId )
    {
        return gameLeaderDAO.getGameLeader( gameId, leaderId );
    }

    @Override
    @Transactional
    public String getCommand( int gameId, int leaderId )
    {
        GameLeader gl = gameLeaderDAO.getGameLeader( gameId, leaderId );

        return ( null != gl ? gl.getInCommand() : "N" );
    }

    @Override
    @Transactional
    public int getFatigue( int gameId, int leaderId )
    {
        GameLeader gl = gameLeaderDAO.getGameLeader( gameId, leaderId );

        return ( null != gl ? gl.getFatigue() : 0 );
    }

    @Override
    @Transactional
    public OrdersType getOrders( int gameId, int leaderId )
    {
        GameLeader gl = gameLeaderDAO.getGameLeader( gameId, leaderId );

        return ( null != gl ? gl.getOrders() : null );
    }

    @Override
    @Transactional
    public StatusType getStatus( int gameId, int leaderId )
    {
        GameLeader gl = gameLeaderDAO.getGameLeader( gameId, leaderId );

        return ( null != gl ? gl.getStatus() : null );
    }

    @Override
    @Transactional
    public void addNotes( int gameId, int leaderId, String notes )
    {
        GameLeader gl = gameLeaderDAO.getGameLeader( gameId, leaderId );

        gl.setNotes( ( null != gl.getNotes() ? gl.getNotes() + "\n" : "" ) + notes );

        gameLeaderDAO.saveGameLeader( gl );
    }

    @Override
    @Transactional
    public void clearNotes( int gameId, int leaderId )
    {
        GameLeader gl = gameLeaderDAO.getGameLeader( gameId, leaderId );

        gl.setNotes( "" );

        gameLeaderDAO.saveGameLeader( gl );
    }

    public void setGameLeaderDAO( GameLeaderDAO gameLeaderDAO )
    {
        this.gameLeaderDAO = gameLeaderDAO;
    }

    public void setOrdersTypeDAO( OrdersTypeDAO ordersTypeDAO )
    {
        this.ordersTypeDAO = ordersTypeDAO;
    }

    public void setStatusTypeDAO( StatusTypeDAO statusTypeDAO )
    {
        this.statusTypeDAO = statusTypeDAO;
    }

}

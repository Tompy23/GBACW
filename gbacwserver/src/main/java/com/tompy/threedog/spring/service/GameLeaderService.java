package com.tompy.threedog.spring.service;

import java.util.List;

import com.tompy.threedog.spring.model.GameLeader;
import com.tompy.threedog.spring.model.OrdersType;
import com.tompy.threedog.spring.model.StatusType;

public interface GameLeaderService
{
    public void setCommand( int gameId, int leaderId, String command );

    public void setFatigue( int gameId, int leaderId, int fatigue );

    public void setOrders( int gameId, int leaderId, int orders );

    public void setStatus( int gameId, int leaderId, int status );

    public List< GameLeader > getGameLeaders( int gameId );

    public GameLeader getGameLeader( int gameId, int leaderId );
    
    public String getCommand( int gameId, int leaderId );
    
    public int getFatigue( int gameId, int leaderId );
    
    public OrdersType getOrders( int gameId, int leaderId );
    
    public StatusType getStatus( int gameId, int leaderId );
    
    public void addNotes( int gameId, int leaderId, String notes );
    
    public void clearNotes( int gameId, int leaderId );
}

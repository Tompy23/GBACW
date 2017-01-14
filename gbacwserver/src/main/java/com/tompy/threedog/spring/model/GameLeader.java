package com.tompy.threedog.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "game_leader" )
public class GameLeader implements Serializable, Comparable< GameLeader >
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public GameLeader()
    {
    }

    public GameLeader( Game g, Leader l, OrdersType o, StatusType s )
    {
        game = g;
        leader = l;
        orders = o;
        status = s;
        inCommand = "Y";
        fatigue = 0;
        notes = "";
    }

    @Override
    public int compareTo( GameLeader other )
    {
        int returnValue = 0;

        returnValue = leader.getRank().getId() - other.getLeader().getRank().getId();
        return ( returnValue == 0 ? leader.getId() - other.getLeader().getId() : returnValue );
    }

    @Id
    @ManyToOne
    @JoinColumn( name = "gameId" )
    private Game game;

    @Id
    @ManyToOne
    @JoinColumn( name = "leaderId" )
    private Leader leader;

    @Column( name = "inCommand" )
    private String inCommand;

    @Column( name = "fatigue" )
    private int fatigue;

    @ManyToOne
    @JoinColumn( name = "ordersId" )
    private OrdersType orders;

    @ManyToOne
    @JoinColumn( name = "statusId" )
    private StatusType status;

    @Column( name = "notes" )
    private String notes;

    public Game getGame()
    {
        return game;
    }

    public void setGame( Game game )
    {
        this.game = game;
    }

    public String getInCommand()
    {
        return inCommand;
    }

    public void setInCommand( String inCommand )
    {
        this.inCommand = inCommand;
    }

    public int getFatigue()
    {
        return fatigue;
    }

    public void setFatigue( int fatigue )
    {
        this.fatigue = fatigue;
    }

    public OrdersType getOrders()
    {
        return orders;
    }

    public void setOrders( OrdersType orders )
    {
        this.orders = orders;
    }

    public StatusType getStatus()
    {
        return status;
    }

    public void setStatus( StatusType status )
    {
        this.status = status;
    }

    public String getNotes()
    {
        return notes;
    }

    public void setNotes( String notes )
    {
        this.notes = notes;
    }

    public Leader getLeader()
    {
        return leader;
    }

    public void setLeaders( Leader leader )
    {
        this.leader = leader;
    }

}

package com.tompy.threedog.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "game_player" )
public class GamePlayer implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public GamePlayer()
    {

    }

    public GamePlayer( Game g, Player p, SideType s, StateType a )
    {
        game = g;
        player = p;
        side = s;
        state = a;
    }

    @Id
    @ManyToOne
    @JoinColumn( name = "gameId" )
    private Game game;

    @Id
    @ManyToOne
    @JoinColumn( name = "playerId" )
    private Player player;

    @ManyToOne
    @JoinColumn( name = "sideId" )
    private SideType side;

    @ManyToOne
    @JoinColumn( name = "stateId" )
    private StateType state;

    public Game getGame()
    {
        return game;
    }

    public void setGame( Game game )
    {
        this.game = game;
    }

    public Player getPlayer()
    {
        return player;
    }

    public void setPlayer( Player player )
    {
        this.player = player;
    }

    public SideType getSide()
    {
        return side;
    }

    public void setSide( SideType side )
    {
        this.side = side;
    }

    public StateType getState()
    {
        return state;
    }

    public void setState( StateType state )
    {
        this.state = state;
    }

}

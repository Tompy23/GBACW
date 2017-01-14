package com.tompy.threedog.spring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "game" )
public class Game implements Comparable< Game >
{
    @Id
    @Column( name = "id" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;

    @Column( name = "currentTurn" )
    private int currentTurn;

    @Column( name = "description" )
    private String description;

    @OneToMany( mappedBy = "game", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    private Set< GamePlayer > gamePlayers = new HashSet< GamePlayer >();

    @OneToMany( mappedBy = "game", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    private Set< Turn > turns = new HashSet< Turn >();

    @OneToMany( mappedBy = "game", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    private Set< GameLeader > gameLeaders = new HashSet< GameLeader >();

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }

    public int getCurrentTurn()
    {
        return currentTurn;
    }

    public void setCurrentTurn( int currentTurn )
    {
        this.currentTurn = currentTurn;
    }

    public Set< Turn > getTurns()
    {
        return turns;
    }

    public void addTurn( Turn turn )
    {
        turns.add( turn );
    }

    public void setTurns( Set< Turn > turns )
    {
        this.turns = turns;
    }

    public Set< GameLeader > getGameLeaders()
    {
        return gameLeaders;
    }

    public void setGameLeaders( Set< GameLeader > gameLeaders )
    {
        this.gameLeaders = gameLeaders;
    }

    @Override
    public int compareTo( Game arg0 )
    {
        return ( this.id - ( (Game) arg0 ).getId() );
    }

    public Set< GamePlayer > getGamePlayers()
    {
        return gamePlayers;
    }

    public void setGamePlayers( Set< GamePlayer > gamePlayers )
    {
        this.gamePlayers = gamePlayers;
    }

    public void addGamePlayer( GamePlayer gp )
    {
        gamePlayers.add( gp );
    }

}

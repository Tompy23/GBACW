package com.tompy.threedog.spring.model;

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
@Table( name = "player" )
public class Player implements Comparable< Player >
{
    @Id
    @Column( name = "id" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;

    @Column( name = "name" )
    private String name;

    @OneToMany( mappedBy = "player", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    private Set< GamePlayer > gamePlayers;

    @Override
    public int compareTo( Player o )
    {
        return this.id - o.getId();
    }

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public Set< GamePlayer > getGamePlayers()
    {
        return gamePlayers;
    }

    public void setGamePlayers( Set< GamePlayer > gamePlayers )
    {
        this.gamePlayers = gamePlayers;
    }

}

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "turn" )
public class Turn implements Comparable< Turn >
{
    @Id
    @Column( name = "id" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;

    @OneToMany( mappedBy = "turn", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    private Set< TurnAMPool > amPool = new HashSet< TurnAMPool >();

    @OneToMany( mappedBy = "aturn", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    private Set< TurnActivation > activation = new HashSet< TurnActivation >();

    @OneToMany( mappedBy = "eturn", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    private Set< TurnEfficiency > efficiency = new HashSet< TurnEfficiency >();

    @OneToMany( mappedBy = "iturn", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    private Set< TurnInitiative > initiative = new HashSet< TurnInitiative >();

    @ManyToOne
    @JoinColumn( name = "gameId" )
    private Game game;

    @Column( name = "number" )
    private int number;

    @Column( name = "description" )
    private String description;

    @Override
    public int compareTo( Turn o )
    {
        return ( this.game.getId() == o.getGame().getId() ? this.number - o.getNumber() : 1 );
    }

    public TurnAMPool addAM( TurnAMPool am )
    {
        amPool.add( am );

        return am;
    }

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public Game getGame()
    {
        return game;
    }

    public void setGame( Game game )
    {
        this.game = game;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber( int number )
    {
        this.number = number;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }

    public Set< TurnAMPool > getAmPool()
    {
        return amPool;
    }

    public void setAmPool( Set< TurnAMPool > amPool )
    {
        this.amPool = amPool;
    }

    public Set< TurnActivation > getActivation()
    {
        return activation;
    }

    public void setActivation( Set< TurnActivation > activation )
    {
        this.activation = activation;
    }

    public Set< TurnEfficiency > getEfficiency()
    {
        return efficiency;
    }

    public void setEfficiency( Set< TurnEfficiency > efficiency )
    {
        this.efficiency = efficiency;
    }

    public Set< TurnInitiative > getInitiative()
    {
        return initiative;
    }

    public void setInitiative( Set< TurnInitiative > initiative )
    {
        this.initiative = initiative;
    }

}

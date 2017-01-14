package com.tompy.threedog.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "turn_initiative" )
public class TurnInitiative implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public TurnInitiative()
    {

    }

    public TurnInitiative( Leader leader, Turn turn )
    {
        overall = leader;
        iturn = turn;
    }

    @Id
    @ManyToOne
    @JoinColumn( name = "turnId" )
    private Turn iturn;

    @Id
    @ManyToOne
    @JoinColumn( name = "overallId" )
    private Leader overall;

    @Column( name = "initiativeValue" )
    private int initiativeValue;

    public Turn getTurn()
    {
        return iturn;
    }

    public void setTurn( Turn turn )
    {
        this.iturn = turn;
    }

    public Leader getOverall()
    {
        return overall;
    }

    public void setOverall( Leader overall )
    {
        this.overall = overall;
    }

    public int getInitiativeValue()
    {
        return initiativeValue;
    }

    public void setInitiativeValue( int initiativeValue )
    {
        this.initiativeValue = initiativeValue;
    }
}

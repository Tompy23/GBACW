package com.tompy.threedog.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "turn_efficiency" )
public class TurnEfficiency implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public TurnEfficiency()
    {

    }

    public TurnEfficiency( Leader leader, Turn turn )
    {
        corps = leader;
        eturn = turn;
    }

    @Id
    @ManyToOne
    @JoinColumn( name = "turnId" )
    private Turn eturn;

    @Id
    @ManyToOne
    @JoinColumn( name = "corpsId" )
    private Leader corps;

    @Column( name = "efficiencyValue" )
    private int efficiencyValue;

    public Turn getTurn()
    {
        return eturn;
    }

    public void setTurn( Turn turn )
    {
        this.eturn = turn;
    }

    public Leader getCorps()
    {
        return corps;
    }

    public void setCorps( Leader corps )
    {
        this.corps = corps;
    }

    public int getEfficiencyValue()
    {
        return efficiencyValue;
    }

    public void setEfficiencyValue( int efficiencyValue )
    {
        this.efficiencyValue = efficiencyValue;
    }
}

package com.tompy.threedog.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "turn_activation" )
public class TurnActivation implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public TurnActivation()
    {
        
    }
    
    public TurnActivation( Leader leader, Turn turn )
    {
        division = leader;
        aturn = turn;
    }

    @Id
    @ManyToOne
    @JoinColumn( name = "turnId" )
    private Turn aturn;

    @Id
    @ManyToOne
    @JoinColumn( name = "divisionId" )
    private Leader division;

    @Column( name = "activationValue" )
    private int activationValue;

    public int getActivationValue()
    {
        return activationValue;
    }

    public void setActivationValue( int activationValue )
    {
        this.activationValue = activationValue;
    }

    public Turn getTurn()
    {
        return aturn;
    }

    public void setTurn( Turn turn )
    {
        this.aturn = turn;
    }

    public Leader getDivision()
    {
        return division;
    }

    public void setDivision( Leader division )
    {
        this.division = division;
    }
}

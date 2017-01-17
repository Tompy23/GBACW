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
@Table( name = "turn_ampool" )
public class TurnAMPool
{
    public TurnAMPool()
    {
    }

    public TurnAMPool( Turn t, Leader l )
    {
        turn = t;
        divisionAM = l;
        picked = "N";
    }

    @Id
    @Column( name = "id" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;

    @OneToMany( mappedBy = "am", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    private Set< ActivationBrigade > activations = new HashSet< ActivationBrigade >();

    @ManyToOne
    @JoinColumn( name = "turnId" )
    private Turn turn;

    @ManyToOne
    @JoinColumn( name = "divisionId" )
    private Leader divisionAM;

    // This is a single byte field
    // "N" - not picked
    // "C" - Current
    // "P" - Picked and completed
    @Column( name = "picked" )
    private String picked;

    public ActivationBrigade addActivation( ActivationBrigade ab )
    {
        activations.add( ab );

        return ab;
    }

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public Set< ActivationBrigade > getActivations()
    {
        return activations;
    }

    public void setActivations( Set< ActivationBrigade > activations )
    {
        this.activations = activations;
    }

    public Turn getTurn()
    {
        return turn;
    }

    public void setTurn( Turn turn )
    {
        this.turn = turn;
    }

    public String getPicked()
    {
        return picked;
    }

    public void setPicked( String picked )
    {
        this.picked = picked;
    }

    public Leader getDivisionAM()
    {
        return divisionAM;
    }

    public void setDivisionAM( Leader divisionAM )
    {
        this.divisionAM = divisionAM;
    }
}

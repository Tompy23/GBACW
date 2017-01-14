package com.tompy.threedog.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "activation_brigade" )
public class ActivationBrigade implements Serializable
{
/**
     * 
     */
    private static final long serialVersionUID = 1L;

    //    @Id
//    @Column( name = "id" )
//    @GeneratedValue( strategy = GenerationType.IDENTITY )
//    private int id;
//
    @Id
    @ManyToOne
    @JoinColumn( name = "amId" )
    private TurnAMPool am;

    @Id
    @ManyToOne
    @JoinColumn( name = "brigadeId" )
    private Leader brigade;

    @ManyToOne
    @JoinColumn( name = "typeId" )
    private ActivationType type;

    @Column( name = "notes" )
    private String notes;

    public TurnAMPool getAm()
    {
        return am;
    }

    public void setAm( TurnAMPool am )
    {
        this.am = am;
    }

    public Leader getBrigade()
    {
        return brigade;
    }

    public void setBrigade( Leader brigade )
    {
        this.brigade = brigade;
    }

    public ActivationType getType()
    {
        return type;
    }

    public void setType( ActivationType type )
    {
        this.type = type;
    }

    public String getNotes()
    {
        return notes;
    }

    public void setNotes( String notes )
    {
        this.notes = notes;
    }
}

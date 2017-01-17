package com.tompy.threedog.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table( name = "status_type" )
public class StatusType implements Comparable< StatusType >
{
    public static final String DEFAULT = "Ok";
    public static final int STATUS_INEFFECTIVE = 6;

    @Id
    @Column( name = "id" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;

    @Column( name = "description" )
    private String description;

    @Override
    public int compareTo( StatusType o )
    {
        return this.id - o.getId();
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription( String description )
    {
        this.description = description;
    }

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

}

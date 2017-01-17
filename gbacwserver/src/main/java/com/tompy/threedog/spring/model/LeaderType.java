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
@Table( name = "leader_type" )
public class LeaderType implements Comparable< LeaderType >
{
    public static final int LEADER_TYPE_OVERALL = 1;
    public static final int LEADER_TYPE_CORPS = 2;
    public static final int LEADER_TYPE_DIVISION = 3;
    public static final int LEADER_TYPE_BRIGADE = 4;

    // @Id
    // @GeneratedValue( strategy = GenerationType.IDENTITY )
    // @OneToMany( mappedBy = "rank" )
    // private Set< Leader > leaders;
    @Id
    @Column( name = "id" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;

    @Column( name = "description" )
    private String description;

    @Override
    public int compareTo( LeaderType o )
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

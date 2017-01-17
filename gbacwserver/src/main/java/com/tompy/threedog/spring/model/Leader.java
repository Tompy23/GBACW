package com.tompy.threedog.spring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table( name = "leader" )
public class Leader implements Comparable< Leader >
{
    @Id
    @Column( name = "id" )
    private Integer id;

    @ManyToOne
    @JoinColumn( name = "sideId" )
    private SideType side;

    @ManyToOne
    @JoinColumn( name = "typeId" )
    private LeaderType rank;

    @Column( name = "name" )
    private String name;

    @Column( name = "identifier" )
    private String identifier;

    @Column( name = "imageNameFront" )
    private String imageFront;

    @Column( name = "imageNameBack" )
    private String imageBack;

    @Column( name = "turnOfEntry" )
    private Integer turnOfEntry;

    @ManyToOne
    @JoinColumn( name = "superiorId" )
    private Leader superior;

    @OneToMany( mappedBy = "superior", fetch = FetchType.EAGER, cascade = CascadeType.ALL )
    private Set< Leader > subordinates = new HashSet< Leader >();

    @Column( name = "activationRating" )
    private Integer activationRating;

    @Column( name = "efficiencyRating" )
    private Integer efficiencyRating;

    @Column( name = "initiativeRating" )
    private Integer initiativeRating;

    @Column( name = "replacementName" )
    private String replacementName;

    @Column( name = "replacementActivationRating" )
    private Integer replacementActivationRating;

    @Column( name = "replacementEfficiencyRating" )
    private Integer repalcementEfficiencyRating;

    @Column( name = "imageNameAM" )
    private String imageAM;

    @Override
    public int compareTo( Leader o )
    {
        // TODO Auto-generated method stub
        return this.id - o.getId();
    }

    public Integer getId()
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    public SideType getSide()
    {
        return side;
    }

    public void setSide( SideType side )
    {
        this.side = side;
    }

    public LeaderType getRank()
    {
        return rank;
    }

    public void setRank( LeaderType rank )
    {
        this.rank = rank;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getIdentifier()
    {
        return identifier;
    }

    public void setIdentifier( String identifier )
    {
        this.identifier = identifier;
    }

    public String getImageFront()
    {
        return imageFront;
    }

    public void setImageFront( String imageFront )
    {
        this.imageFront = imageFront;
    }

    public String getImageBack()
    {
        return imageBack;
    }

    public void setImageBack( String imageBack )
    {
        this.imageBack = imageBack;
    }

    public Integer getTurnOfEntry()
    {
        return turnOfEntry;
    }

    public void setTurnOfEntry( Integer turnOfEntry )
    {
        this.turnOfEntry = turnOfEntry;
    }

    public Leader getSuperior()
    {
        return superior;
    }

    public void setSuperior( Leader superior )
    {
        this.superior = superior;
    }

    public Set< Leader > getSubordinates()
    {
        return subordinates;
    }

    public void setSubordinates( Set< Leader > subordinates )
    {
        this.subordinates = subordinates;
    }

    public Integer getActivationRating()
    {
        return activationRating;
    }

    public void setActivationRating( Integer activationRating )
    {
        this.activationRating = activationRating;
    }

    public Integer getEfficiencyRating()
    {
        return efficiencyRating;
    }

    public void setEfficiencyRating( Integer efficiencyRating )
    {
        this.efficiencyRating = efficiencyRating;
    }

    public Integer getInitiativeRating()
    {
        return initiativeRating;
    }

    public void setInitiativeRating( Integer initiativeRating )
    {
        this.initiativeRating = initiativeRating;
    }

    public String getReplacementName()
    {
        return replacementName;
    }

    public void setReplacementName( String replacementName )
    {
        this.replacementName = replacementName;
    }

    public Integer getReplacementActivationRating()
    {
        return replacementActivationRating;
    }

    public void setReplacementActivationRating( Integer replacementActivationRating )
    {
        this.replacementActivationRating = replacementActivationRating;
    }

    public Integer getRepalcementEfficiencyRating()
    {
        return repalcementEfficiencyRating;
    }

    public void setRepalcementEfficiencyRating( Integer repalcementEfficiencyRating )
    {
        this.repalcementEfficiencyRating = repalcementEfficiencyRating;
    }

    public String getImageAM()
    {
        return imageAM;
    }

    public void setImageAM( String imageAM )
    {
        this.imageAM = imageAM;
    }
    //
    // public Set< TurnAMPool > getDivisionAM()
    // {
    // return divisionAM;
    // }
    //
    // public void setDivisionAM( Set< TurnAMPool > divisionAM )
    // {
    // this.divisionAM = divisionAM;
    // }
    //
    // public Set< GameLeader > getGameLeaders()
    // {
    // return gameLeaders;
    // }
    //
    // public void setGameLeaders( Set< GameLeader > gameLeaders )
    // {
    // this.gameLeaders = gameLeaders;
    // }

}

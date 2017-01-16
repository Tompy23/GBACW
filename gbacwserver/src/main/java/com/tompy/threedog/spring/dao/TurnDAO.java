package com.tompy.threedog.spring.dao;

import java.util.List;

import com.tompy.threedog.spring.model.Turn;
import com.tompy.threedog.spring.model.TurnAMPool;
import com.tompy.threedog.spring.model.TurnActivation;
import com.tompy.threedog.spring.model.TurnEfficiency;
import com.tompy.threedog.spring.model.TurnInitiative;

public interface TurnDAO
{
    public Turn getTurnById( int id );

    public void saveTurn( Turn turn );

    public List< TurnInitiative > getTurnInitiative( int turnId );

    public List< TurnEfficiency > getTurnEfficiency( int turnId );

    public List< TurnActivation > getTurnActivation( int turnId );

    public List< TurnAMPool > getTurnAMPool( int turnId );

    public void setDivisionActivation( int turnId, int divisionId, int count );
}

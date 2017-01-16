package com.tompy.threedog.spring.service;

import java.util.List;

import com.tompy.threedog.spring.model.Turn;
import com.tompy.threedog.spring.model.TurnAMPool;
import com.tompy.threedog.spring.model.TurnActivation;
import com.tompy.threedog.spring.model.TurnEfficiency;
import com.tompy.threedog.spring.model.TurnInitiative;

public interface TurnService
{
    public Turn createNextTurn( int gameId );

    public void startCurrentTurn( int gameId, int playerId );

    public String getDescription( int current );

    public Turn getCurrentTurn( int gameId );

    public void setTurnEfficiencyBonus( int turnId, int corpsId );

    public void setTurnActivationBonus( int turnId, int divisionId );

    public List< TurnInitiative > getTurnInitiative( int turnId );

    public List< TurnEfficiency > getTurnEfficiency( int turnId );

    public List< TurnActivation > getTurnActivation( int turnId );

    public List< TurnAMPool > getTurnAMPool( int turnId );

    public void setDivisionActivation( int turnId, int divisionId, int count );

}

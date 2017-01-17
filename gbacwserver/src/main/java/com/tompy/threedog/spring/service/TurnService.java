package com.tompy.threedog.spring.service;

import java.util.List;

import com.tompy.threedog.spring.model.ActivationBrigade;
import com.tompy.threedog.spring.model.Turn;
import com.tompy.threedog.spring.model.TurnAMPool;
import com.tompy.threedog.spring.model.TurnActivation;
import com.tompy.threedog.spring.model.TurnEfficiency;
import com.tompy.threedog.spring.model.TurnInitiative;

public interface TurnService
{
    public Turn getTurnById( int id );

    public Turn createNextTurn( int gameId );

    public Turn startCurrentTurn( int gameId, int playerId );

    public String getDescription( int current );

    public Turn getCurrentTurn( int gameId );

    public void setTurnEfficiencyBonus( int turnId, int corpsId );

    public void setTurnActivationBonus( int turnId, int divisionId );

    public void buildAMPool( int turnId );

    public List< TurnInitiative > getTurnInitiative( int turnId );

    public List< TurnEfficiency > getTurnEfficiency( int turnId );

    public List< TurnActivation > getTurnActivation( int turnId );

    public List< TurnAMPool > getTurnAMPool( int turnId );

    public void setDivisionActivation( int turnId, int divisionId, int count );

    public List< TurnAMPool > getUnpicked( int turnId );

    public TurnAMPool drawAM( int turnId );

    public void setAM( int turnId, int amId, String value );

    public void activateBrigade( int turnId, int brigadeId, int typeId, String notes );

    public List< ActivationBrigade > getActivations( int turnId, int brigadeId );

}

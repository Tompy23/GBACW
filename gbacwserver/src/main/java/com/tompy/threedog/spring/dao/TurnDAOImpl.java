package com.tompy.threedog.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tompy.threedog.spring.model.Game;
import com.tompy.threedog.spring.model.Turn;
import com.tompy.threedog.spring.model.TurnAMPool;
import com.tompy.threedog.spring.model.TurnActivation;
import com.tompy.threedog.spring.model.TurnEfficiency;
import com.tompy.threedog.spring.model.TurnInitiative;

public class TurnDAOImpl implements TurnDAO
{
    private SessionFactory sessionFactory;

    public void setSessionFactory( SessionFactory sf )
    {
        this.sessionFactory = sf;
    }

    @Override
    public void saveTurn( Turn turn )
    {
        Session session = sessionFactory.getCurrentSession();

        session.persist( turn );
    }

    @Override
    public Turn getTurnById( int id )
    {
        Session session = this.sessionFactory.getCurrentSession();

        Turn turn = (Turn) session.get( Turn.class, id );

        return turn;
    }

    @SuppressWarnings( "unchecked" )
    @Override
    public List< TurnInitiative > getTurnInitiative( int turnId )
    {
        Session session = this.sessionFactory.getCurrentSession();

        List< TurnInitiative > returnValue = null;

        returnValue = (List< TurnInitiative >) session.createQuery( "from TurnInitiative where turnId = :turn" ).setParameter( "turn", turnId ).list();

        return returnValue;
    }

    @Override
    public List< TurnEfficiency > getTurnEfficiency( int turnId )
    {
        Session session = this.sessionFactory.getCurrentSession();

        List< TurnEfficiency > returnValue = null;

        returnValue = (List< TurnEfficiency >) session.createQuery( "from TurnEfficiency where turnId = :turn" ).setParameter( "turn", turnId ).list();

        return returnValue;
    }

    @Override
    public List< TurnActivation > getTurnActivation( int turnId )
    {
        Session session = this.sessionFactory.getCurrentSession();

        List< TurnActivation > returnValue = null;

        returnValue = (List< TurnActivation >) session.createQuery( "from TurnActivation where turnId = :turn" ).setParameter( "turn", turnId ).list();

        return returnValue;
    }

    @Override
    public List< TurnAMPool > getTurnAMPool( int turnId )
    {
        Session session = this.sessionFactory.getCurrentSession();

        List< TurnAMPool > returnValue = null;

        returnValue = (List< TurnAMPool >) session.createQuery( "from TurnAMPool where turnId = :turn" ).setParameter( "turn", turnId ).list();

        return returnValue;
    }

    @Override
    public void setDivisionActivation( int turnId, int divisionId, int count )
    {
        // TODO Auto-generated method stub
        
    }
}

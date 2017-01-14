package com.tompy.threedog.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tompy.threedog.spring.model.Game;
import com.tompy.threedog.spring.model.Turn;

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
}

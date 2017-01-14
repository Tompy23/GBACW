package com.tompy.threedog.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tompy.threedog.spring.model.Game;
import com.tompy.threedog.spring.model.Player;

public class GameDAOImpl implements GameDAO
{
    private SessionFactory sessionFactory;

    public void setSessionFactory( SessionFactory sf )
    {
        this.sessionFactory = sf;
    }

    @Override
    public void saveGame( Game game )
    {
        Session session = this.sessionFactory.getCurrentSession();

        session.persist( game );
    }

    @Override
    public Game getGameById( int gameId )
    {
        Session session = this.sessionFactory.getCurrentSession();

        Game game = (Game) session.get( Game.class, gameId );

        return game;
    }
}

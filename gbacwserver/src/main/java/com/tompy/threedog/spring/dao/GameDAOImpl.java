package com.tompy.threedog.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tompy.threedog.spring.model.Game;
import com.tompy.threedog.spring.model.Turn;

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
        Session session = sessionFactory.getCurrentSession();

        session.persist( game );
    }

    @Override
    public Game getGameById( int gameId )
    {
        Session session = this.sessionFactory.getCurrentSession();

        Game game = (Game) session.get( Game.class, gameId );

        return game;
    }

    @Override
    public Game getGameByName( String gameName )
    {
        Game returnValue = null;

        Session session = this.sessionFactory.getCurrentSession();

        @SuppressWarnings( "unchecked" )
        List< Game > games = (List< Game >) session.createQuery( "from Game where description = :name " ).setParameter( "name", gameName ).list();

        if ( !games.isEmpty() )
        {
            returnValue = games.get( 0 );
        }

        return returnValue;
    }
}

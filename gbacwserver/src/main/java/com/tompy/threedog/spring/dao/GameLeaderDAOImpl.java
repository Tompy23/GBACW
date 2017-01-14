package com.tompy.threedog.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tompy.threedog.spring.model.GameLeader;

public class GameLeaderDAOImpl implements GameLeaderDAO
{
    private SessionFactory sessionFactory;

    public void setSessionFactory( SessionFactory sf )
    {
        this.sessionFactory = sf;
    }

    @Override
    public GameLeader getGameLeader( int gameId, int leaderId )
    {
        Session session = this.sessionFactory.getCurrentSession();
        GameLeader returnValue = null;

        @SuppressWarnings( "unchecked" )
        List< GameLeader > gameLeader =
                (List< GameLeader >) session.createQuery( "from GameLeader where leader.id = :leader and game.id = :game" ).setParameter( "leader", leaderId )
                        .setParameter( "game", gameId ).list();

        if ( null != gameLeader )
        {
            returnValue = gameLeader.get( 0 );
        }

        return returnValue;
    }

    @Override
    public void saveGameLeader( GameLeader gl )
    {
        Session session = this.sessionFactory.getCurrentSession();

        session.persist( gl );
    }

    @Override
    public List< GameLeader > getGameLeaders( int gameId )
    {
        Session session = this.sessionFactory.getCurrentSession();

        @SuppressWarnings( "unchecked" )
        List< GameLeader > returnValue = (List< GameLeader >) session.createQuery( "from GameLeader where game.id = :game" ).setParameter( "game", gameId ).list();

        return returnValue;
    }

}

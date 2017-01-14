package com.tompy.threedog.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tompy.threedog.spring.model.Game;
import com.tompy.threedog.spring.model.GamePlayer;
import com.tompy.threedog.spring.model.Player;
import com.tompy.threedog.spring.model.SideType;

public class GamePlayerDAOImpl implements GamePlayerDAO
{
    private SessionFactory sessionFactory;

    public void setSessionFactory( SessionFactory sf )
    {
        this.sessionFactory = sf;
    }

    @Override
    public void saveGamePlayerSide( GamePlayer gps )
    {
        Session session = this.sessionFactory.getCurrentSession();

        session.persist( gps );
    }

    @Override
    public SideType getSide( Game g, Player p )
    {
        SideType returnValue = null;

        Session session = this.sessionFactory.getCurrentSession();

        @SuppressWarnings( "unchecked" )
        List< GamePlayer > gamePlayer =
                (List< GamePlayer >) session.createQuery( "from GamePlayer where player = :player and game = :game" ).setParameter( "player", p ).setParameter( "game", g ).list();

        if ( null != gamePlayer )
        {
            returnValue = gamePlayer.get( 0 ).getSide();
        }

        return returnValue;
    }

    @Override
    public void setSide( Game g, Player p, String s )
    {
        Session session = this.sessionFactory.getCurrentSession();

    }

    @SuppressWarnings( "unchecked" )
    @Override
    public List< Game > getGames( Player p, SideType s )
    {
        Session session = this.sessionFactory.getCurrentSession();

        List< Game > returnValue = null;

        returnValue = (List< Game >) session.createQuery( "select game from GamePlayer where playerId = :player and sideId = :side" ).setParameter( "player", p.getId() )
                .setParameter( "side", s.getId() ).list();

        // if ( null != gamePlayers )
        // {
        // returnValue = new ArrayList< Game >();
        // for ( GamePlayer gp : gamePlayers )
        // {
        // returnValue.add( gp.getGame() );
        // }
        // }

        return returnValue;
    }

    @Override
    public List< Player > getPlayers( Game g )
    {
        Session session = this.sessionFactory.getCurrentSession();

        // List< Player > returnValue = null;

        @SuppressWarnings( "unchecked" )
        List< Player > returnValue =
                (List< Player >) session.createQuery( "select player from GamePlayer where gameId = :game" ).setParameter( "game", g.getId() ).list();

        // if ( null != gamePlayers )
        // {
        // returnValue = new ArrayList< Game >();
        // for ( GamePlayer gp : gamePlayers )
        // {
        // returnValue.add( gp.getGame() );
        // }
        // }

        return returnValue;
    }

}

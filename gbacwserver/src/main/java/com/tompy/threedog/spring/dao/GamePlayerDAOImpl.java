package com.tompy.threedog.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tompy.threedog.spring.model.Game;
import com.tompy.threedog.spring.model.GamePlayer;
import com.tompy.threedog.spring.model.Player;
import com.tompy.threedog.spring.model.SideType;
import com.tompy.threedog.spring.model.StateType;

public class GamePlayerDAOImpl implements GamePlayerDAO
{
    private SessionFactory sessionFactory;

    public void setSessionFactory( SessionFactory sf )
    {
        this.sessionFactory = sf;
    }

    @Override
    public void saveGamePlayer( GamePlayer gps )
    {
        Session session = this.sessionFactory.getCurrentSession();

        session.persist( gps );
    }

    @Override
    public SideType getSide( int gameId, int playerId )
    {
        SideType returnValue = null;

        Session session = this.sessionFactory.getCurrentSession();

        @SuppressWarnings( "unchecked" )
        List< GamePlayer > gamePlayer =
                (List< GamePlayer >) session.createQuery( "from GamePlayer where playerId = :player and gameId = :game" ).setParameter( "player", playerId )
                        .setParameter( "game", gameId ).list();

        if ( null != gamePlayer )
        {
            returnValue = gamePlayer.get( 0 ).getSide();
        }

        return returnValue;
    }

    @Override
    public StateType getState( int gameId, int playerId )
    {
        StateType returnValue = null;

        Session session = this.sessionFactory.getCurrentSession();

        @SuppressWarnings( "unchecked" )
        List< GamePlayer > gamePlayer =
                (List< GamePlayer >) session.createQuery( "from GamePlayer where playerId = :player and gameid = :game" ).setParameter( "player", playerId )
                        .setParameter( "game", gameId ).list();

        if ( null != gamePlayer )
        {
            returnValue = gamePlayer.get( 0 ).getState();
        }

        return returnValue;
    }

    @Override
    public void setSide( int gameId, int playerId, String s )
    {
        Session session = this.sessionFactory.getCurrentSession();

    }

    @SuppressWarnings( "unchecked" )
    @Override
    public List< Game > getGames( int playerId, int sideId )
    {
        Session session = this.sessionFactory.getCurrentSession();

        List< Game > returnValue = null;

        returnValue = (List< Game >) session.createQuery( "select game from GamePlayer where playerId = :player and sideId = :side" ).setParameter( "player", playerId )
                .setParameter( "side", sideId ).list();

        return returnValue;
    }

    @Override
    public List< Player > getPlayers( int gameId )
    {
        Session session = this.sessionFactory.getCurrentSession();

        // List< Player > returnValue = null;

        @SuppressWarnings( "unchecked" )
        List< Player > returnValue =
                (List< Player >) session.createQuery( "select player from GamePlayer where gameId = :game" ).setParameter( "game", gameId ).list();

        return returnValue;
    }

    @Override
    public GamePlayer getGamePlayer( int gameId, int playerId )

    {
        Session session = this.sessionFactory.getCurrentSession();

        GamePlayer returnValue = null;

        @SuppressWarnings( "unchecked" )
        List< GamePlayer > gamePlayers =
                (List< GamePlayer >) session.createQuery( "from GamePlayer where gameId = :game and playerId = :player" ).setParameter( "game", gameId )
                        .setParameter( "player", playerId ).list();

        if ( null != gamePlayers )
        {
            returnValue = gamePlayers.get( 0 );
        }

        return returnValue;

    }

    @Override
    public Player getPlayerBySide( int gameId, int sideId )
    {
        Session session = this.sessionFactory.getCurrentSession();

        Player returnValue = null;

        @SuppressWarnings( "unchecked" )
        List< GamePlayer > gamePlayers =
                (List< GamePlayer >) session.createQuery( "from GamePlayer where gameId = :game and sideId = :side" ).setParameter( "game", gameId )
                        .setParameter( "side", sideId ).list();

        if ( null != gamePlayers )
        {
            returnValue = gamePlayers.get( 0 ).getPlayer();
        }

        return returnValue;
    }

}

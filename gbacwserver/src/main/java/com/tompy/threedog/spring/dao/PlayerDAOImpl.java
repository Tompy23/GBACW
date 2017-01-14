package com.tompy.threedog.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.tompy.threedog.spring.model.Player;

@Repository
public class PlayerDAOImpl implements PlayerDAO
{
    private SessionFactory sessionFactory;

    public void setSessionFactory( SessionFactory sf )
    {
        this.sessionFactory = sf;
    }

    @SuppressWarnings( "unchecked" )
    @Override
    public Player getPlayerByName( String name )
    {
        Player returnValue = null;

        Session session = this.sessionFactory.getCurrentSession();

        List< Player > players = (List< Player >) session.createQuery( "from Player where name = :name " ).setParameter( "name", name ).list();

        if ( !players.isEmpty() )
        {
            returnValue = players.get( 0 );
        }

        return returnValue;
    }

    @Override
    public Player getPlayerById( int id )
    {

        Session session = this.sessionFactory.getCurrentSession();

        Player player = (Player) session.get( Player.class, id );

        return player;
    }

}

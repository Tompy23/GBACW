package com.tompy.threedog.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tompy.threedog.spring.model.SideType;
import com.tompy.threedog.spring.model.StatusType;

public class SideTypeDAOImpl implements SideTypeDAO
{
    private SessionFactory sessionFactory;

    public void setSessionFactory( SessionFactory sf )
    {
        this.sessionFactory = sf;
    }

    @Override
    public SideType getSide( String name )
    {
        SideType returnValue = null;

        Session session = this.sessionFactory.getCurrentSession();

        @SuppressWarnings( "unchecked" )
        List< SideType > sides = (List< SideType >) session.createQuery( "from SideType where description = :name " ).setParameter( "name", name ).list();

        if ( !sides.isEmpty() )
        {
            returnValue = sides.get( 0 );
        }

        return returnValue;
    }

    @Override
    public SideType getSide( int id )
    {
        Session session = this.sessionFactory.getCurrentSession();

        SideType side = (SideType) session.get( SideType.class, id );

        return side;
    }
}

package com.tompy.threedog.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tompy.threedog.spring.model.ActivationType;

public class ActivationTypeDAOImpl implements ActivationTypeDAO
{
    private SessionFactory sessionFactory;

    public void setSessionFactory( SessionFactory sf )
    {
        this.sessionFactory = sf;
    }

    @Override
    public ActivationType getActivation( String name )
    {
        ActivationType returnValue = null;

        Session session = this.sessionFactory.getCurrentSession();

        @SuppressWarnings( "unchecked" )
        List< ActivationType > sides = (List< ActivationType >) session.createQuery( "from ActivationType where description = :name " ).setParameter( "name", name ).list();

        if ( !sides.isEmpty() )
        {
            returnValue = sides.get( 0 );
        }

        return returnValue;
    }

    @Override
    public ActivationType getActivation( int id )
    {
        Session session = this.sessionFactory.getCurrentSession();

        ActivationType side = (ActivationType) session.get( ActivationType.class, id );

        return side;
    }}

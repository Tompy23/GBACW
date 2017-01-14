package com.tompy.threedog.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tompy.threedog.spring.model.StateType;

public class StateTypeDAOImpl implements StateTypeDAO
{
    private SessionFactory sessionFactory;

    public void setSessionFactory( SessionFactory sf )
    {
        this.sessionFactory = sf;
    }

    @Override
    public StateType getStateType( String name )
    {
        StateType returnValue = null;

        Session session = this.sessionFactory.getCurrentSession();

        @SuppressWarnings( "unchecked" )
        List< StateType > states = (List< StateType >) session.createQuery( "from StateType where description = :name " ).setParameter( "name", name ).list();

        if ( !states.isEmpty() )
        {
            returnValue = states.get( 0 );
        }

        return returnValue;
    }

}

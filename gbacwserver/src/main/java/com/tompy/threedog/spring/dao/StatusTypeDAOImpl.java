package com.tompy.threedog.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tompy.threedog.spring.model.StatusType;

public class StatusTypeDAOImpl implements StatusTypeDAO
{
    private SessionFactory sessionFactory;

    @Override
    public StatusType getStatusType( int statusTypeId )
    {
        Session session = this.sessionFactory.getCurrentSession();

        StatusType status = (StatusType) session.get( StatusType.class, statusTypeId );

        return status;
    }

    @SuppressWarnings( "unchecked" )
    @Override
    public StatusType getStatusType( String name )
    {
        StatusType returnValue = null;

        Session session = this.sessionFactory.getCurrentSession();

        List< StatusType > status = (List< StatusType >) session.createQuery( "from StatusType where description = :name " ).setParameter( "name", name ).list();

        if ( !status.isEmpty() )
        {
            returnValue = status.get( 0 );
        }

        return returnValue;
    }
    
    public void setSessionFactory( SessionFactory sessionFactory )
    {
        this.sessionFactory = sessionFactory;
    }

}

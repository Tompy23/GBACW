package com.tompy.threedog.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tompy.threedog.spring.model.OrdersType;

public class OrdersTypeDAOImpl implements OrdersTypeDAO
{
    private SessionFactory sessionFactory;

    @Override
    public OrdersType getOrdersType( int ordersTypeId )
    {
        Session session = this.sessionFactory.getCurrentSession();

        OrdersType orders = (OrdersType) session.get( OrdersType.class, ordersTypeId );

        return orders;
    }

    @Override
    public OrdersType getOrdersType( String name )
    {
        OrdersType returnValue = null;

        Session session = this.sessionFactory.getCurrentSession();

        @SuppressWarnings( "unchecked" )
        List< OrdersType > orders = (List< OrdersType >) session.createQuery( "from OrdersType where description = :name " ).setParameter( "name", name ).list();

        if ( !orders.isEmpty() )
        {
            returnValue = orders.get( 0 );
        }

        return returnValue;
    }

    public void setSessionFactory( SessionFactory sessionFactory )
    {
        this.sessionFactory = sessionFactory;
    }

}

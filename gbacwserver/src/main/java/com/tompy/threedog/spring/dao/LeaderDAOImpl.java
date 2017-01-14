package com.tompy.threedog.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tompy.threedog.spring.model.Leader;

public class LeaderDAOImpl implements LeaderDAO
{
    private SessionFactory sessionFactory;

    public void setSessionFactory( SessionFactory sf )
    {
        this.sessionFactory = sf;
    }

    @Override
    public List< Leader > getLeaders()
    {
        Session session = sessionFactory.getCurrentSession();

        List< Leader > leaders = (List< Leader >) session.createQuery( "from Leader" ).list();

        return leaders;
    }

    @Override
    public Leader getLeader( int leaderId )
    {

        Session session = this.sessionFactory.getCurrentSession();

        Leader leader = (Leader) session.get( Leader.class, leaderId );

        return leader;
     }

}

package com.tompy.threedog.spring.service;

import org.springframework.transaction.annotation.Transactional;

import com.tompy.threedog.spring.dao.ActivationTypeDAO;
import com.tompy.threedog.spring.dao.OrdersTypeDAO;
import com.tompy.threedog.spring.dao.SideTypeDAO;
import com.tompy.threedog.spring.dao.StateTypeDAO;
import com.tompy.threedog.spring.dao.StatusTypeDAO;
import com.tompy.threedog.spring.model.ActivationType;
import com.tompy.threedog.spring.model.OrdersType;
import com.tompy.threedog.spring.model.SideType;
import com.tompy.threedog.spring.model.StateType;
import com.tompy.threedog.spring.model.StatusType;

public class LookupServiceImpl implements LookupService
{
    private SideTypeDAO sideTypeDAO;
    private OrdersTypeDAO ordersTypeDAO;
    private StatusTypeDAO statusTypeDAO;
    private StateTypeDAO stateTypeDAO;
    private ActivationTypeDAO activationTypeDAO;

    @Override
    @Transactional
    public SideType getSideType( String name )
    {
        return sideTypeDAO.getSide( name );
    }

    @Override
    @Transactional
    public StatusType getStatusType( String name )
    {
        return statusTypeDAO.getStatusType( name );
    }

    @Override
    @Transactional
    public OrdersType getOrdersType( String name )
    {
        return ordersTypeDAO.getOrdersType( name );
    }

    @Override
    @Transactional
    public StateType getStateType( String name )
    {
        return stateTypeDAO.getStateType( name );
    }

    @Override
    @Transactional
    public SideType getSideType( int id )
    {
        return sideTypeDAO.getSide( id );
    }

    @Override
    @Transactional
    public StatusType getStatusType( int id )
    {
        return statusTypeDAO.getStatusType( id );
    }

    @Override
    @Transactional
    public OrdersType getOrdersType( int id )
    {
        return ordersTypeDAO.getOrdersType( id );
    }

    @Override
    @Transactional
    public StateType getStateType( int id )
    {
        return stateTypeDAO.getStateType( id );
    }

    @Override
    @Transactional
    public ActivationType getActivationType( String name )
    {
       return activationTypeDAO.getActivation( name );
    }

    @Override
    @Transactional
    public ActivationType getActivationType( int id )
    {
         return activationTypeDAO.getActivation( id );
    }

    public void setSideTypeDAO( SideTypeDAO sideTypeDAO )
    {
        this.sideTypeDAO = sideTypeDAO;
    }

    public void setOrdersTypeDAO( OrdersTypeDAO ordersTypeDAO )
    {
        this.ordersTypeDAO = ordersTypeDAO;
    }

    public void setStatusTypeDAO( StatusTypeDAO statusTypeDAO )
    {
        this.statusTypeDAO = statusTypeDAO;
    }

    public void setStateTypeDAO( StateTypeDAO stateTypeDAO )
    {
        this.stateTypeDAO = stateTypeDAO;
    }

    public void setActivationTypeDAO( ActivationTypeDAO activationTypeDAO )
    {
        this.activationTypeDAO = activationTypeDAO;
    }

}

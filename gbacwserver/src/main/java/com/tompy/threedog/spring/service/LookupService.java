package com.tompy.threedog.spring.service;

import com.tompy.threedog.spring.model.OrdersType;
import com.tompy.threedog.spring.model.SideType;
import com.tompy.threedog.spring.model.StateType;
import com.tompy.threedog.spring.model.StatusType;

public interface LookupService
{
    public SideType getSideType( String name );

    public StatusType getStatusType( String name );

    public OrdersType getOrdersType( String name );

    public StateType getStateType( String name );
}

package com.tompy.threedog.spring.dao;

import com.tompy.threedog.spring.model.OrdersType;

public interface OrdersTypeDAO
{
    public OrdersType getOrdersType( int ordersTypeId );

    public OrdersType getOrdersType( String name );
}

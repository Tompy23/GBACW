package com.tompy.threedog.spring.dao;

import com.tompy.threedog.spring.model.SideType;

public interface SideTypeDAO
{
    public SideType getSide( String name );

    public SideType getSide( int id );
}

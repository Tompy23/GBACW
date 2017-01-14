package com.tompy.threedog.spring.dao;

import com.tompy.threedog.spring.model.StatusType;

public interface StatusTypeDAO
{
    public StatusType getStatusType( int statusTypeId );
    
    public StatusType getStatusType( String name );
}

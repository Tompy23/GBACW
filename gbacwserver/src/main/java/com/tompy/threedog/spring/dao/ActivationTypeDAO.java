package com.tompy.threedog.spring.dao;

import com.tompy.threedog.spring.model.ActivationType;

public interface ActivationTypeDAO
{
    public ActivationType getActivation( String name );

    public ActivationType getActivation( int id );
}

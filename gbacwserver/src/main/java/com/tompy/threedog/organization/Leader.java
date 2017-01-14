package com.tompy.threedog.organization;

import java.util.List;

public class Leader<T> 
{
	protected String name;
	protected String identifier;
	protected String imageName;
	protected int turnOfEntry;
	protected List< T > subordinates;
}

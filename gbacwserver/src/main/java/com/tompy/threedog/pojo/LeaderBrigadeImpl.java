package com.tompy.threedog.pojo;

import java.util.List;

public class LeaderBrigadeImpl extends Leader 
{
	protected String actionProfile;
	protected int ordersRating;
	protected String orders;
	protected int fatigue;
	protected LeaderDivisionImpl divisionLeader;
	protected List< Activation > activations;
}

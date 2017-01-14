package com.tompy.threedog.pojo;

import java.util.List;

public class Game 
{
	public enum GAME_STATUS { NOT_STARTED, STARTED, ORDERS, ASSIGN_ACTIVATIONS, ACTIONS };
	protected String id;
	protected String description;
	protected List< Turn > turns;
	protected String side;
	protected GAME_STATUS status;
	
	
	public Turn getActiveTurn()
	{
		return turns.get( 0 );
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Turn> getTurns() {
		return turns;
	}
	public void setTurns(List<Turn> turns) {
		this.turns = turns;
	}
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}

	public GAME_STATUS getStatus() {
		return status;
	}

	public void setStatus(GAME_STATUS status) {
		this.status = status;
	}
	
	
}

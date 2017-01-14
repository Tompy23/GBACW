package com.tompy.threedog.pojo;

public class Unit 
{
	protected String name;
	protected String id;
	protected String imageName;
	protected String hexLocation;
	protected int turnOfEntry;
	protected boolean inReserve;
	protected boolean inCommand;
	protected boolean combatEffective;
	protected String notes;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getHexLocation() {
		return hexLocation;
	}
	public void setHexLocation(String hexLocation) {
		this.hexLocation = hexLocation;
	}
	public int getTurnOfEntry() {
		return turnOfEntry;
	}
	public void setTurnOfEntry(int turnOfEntry) {
		this.turnOfEntry = turnOfEntry;
	}
	public boolean isInReserve() {
		return inReserve;
	}
	public void setInReserve(boolean inReserve) {
		this.inReserve = inReserve;
	}
	public boolean isInCommand() {
		return inCommand;
	}
	public void setInCommand(boolean inCommand) {
		this.inCommand = inCommand;
	}
	public boolean isCombatEffective() {
		return combatEffective;
	}
	public void setCombatEffective(boolean combatEffective) {
		this.combatEffective = combatEffective;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
}

package com.tompy.threedog.pojo;

import java.util.List;

public class Turn 
{
	protected int number;
	protected List< Activation > activationPool;
	protected int statusUnion;
	protected int statusConfederate;
	protected List< String > auditTrail;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public List<Activation> getActivationPool() {
		return activationPool;
	}
	public void setActivationPool(List<Activation> activationPool) {
		this.activationPool = activationPool;
	}
	public int getStatusUnion() {
		return statusUnion;
	}
	public void setStatusUnion(int statusUnion) {
		this.statusUnion = statusUnion;
	}
	public int getStatusConfederate() {
		return statusConfederate;
	}
	public void setStatusConfederate(int statusConfederate) {
		this.statusConfederate = statusConfederate;
	}
	public List<String> getAuditTrail() {
		return auditTrail;
	}
	public void setAuditTrail(List<String> auditTrail) {
		this.auditTrail = auditTrail;
	}
}

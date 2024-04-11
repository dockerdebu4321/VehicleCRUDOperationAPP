package com.ey.vehicleadv.bean;


public class RcOwnerBeans {
	
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String RC_number;
	private String owner_name;
	
	
	public RcOwnerBeans() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RcOwnerBeans(int id, String rC_number, String owner_name) {
		super();
		this.id = id;
		RC_number = rC_number;
		this.owner_name = owner_name;
	}
	public String getRC_number() {
		return RC_number;
	}
	public void setRC_number(String rC_number) {
		RC_number = rC_number;
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	@Override
	public String toString() {
		return "RcOwnerBeans [RC_number=" + RC_number + ", owner_name=" + owner_name + "]";
	}
	

}

package com.ey.vehicleadv.bean;

public class MedicineInventoryBean {
	
	private boolean available_status;
	public boolean isAvailable_status() {
		return available_status;
	}
	public void setAvailable_status(boolean available_status) {
		this.available_status = available_status;
	}
	public MedicineInventoryBean(boolean available_status) {
		super();
		this.available_status = available_status;
	}
	public MedicineInventoryBean() {
		super();
		// TODO Auto-generated constructor stub
	}
}

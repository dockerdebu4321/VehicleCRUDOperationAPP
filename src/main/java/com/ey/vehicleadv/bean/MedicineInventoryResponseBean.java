package com.ey.vehicleadv.bean;

public class MedicineInventoryResponseBean {

	private String message;
	private int AvailableBalance;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getAvailableBalance() {
		return AvailableBalance;
	}

	public void setAvailableBalance(int availableBalance) {
		AvailableBalance = availableBalance;
	}

	public MedicineInventoryResponseBean(String message, int availableBalance) {
		super();
		this.message = message;
		AvailableBalance = availableBalance;
	}

	public MedicineInventoryResponseBean() {
		super();
		// TODO Auto-generated constructor stub
	}
}

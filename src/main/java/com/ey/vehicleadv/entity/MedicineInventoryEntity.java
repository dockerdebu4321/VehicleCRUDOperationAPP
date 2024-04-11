package com.ey.vehicleadv.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="medicine_inventory")
public class MedicineInventoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;
	
	@Column(name="medicine_name")
	private String medicine_name;
	
	@Column(name="stock")
	private int available_stock;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMedicine_name() {
		return medicine_name;
	}
	public void setMedicine_name(String medicine_name) {
		this.medicine_name = medicine_name;
	}
	public int getAvailable_stock() {
		return available_stock;
	}
	public void setAvailable_stock(int available_stock) {
		this.available_stock = available_stock;
	}
	public MedicineInventoryEntity(int id, String medicine_name, int available_stock) {
		super();
		this.id = id;
		this.medicine_name = medicine_name;
		this.available_stock = available_stock;
	}
	public MedicineInventoryEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
}

package com.ey.vehicleadv.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="vehicleinformation")
public class VehicleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int vid;

	@Column(name = "brand")
	private String vBrand;

	@Column(name = "evehicle_evolved")
	private Boolean evehicle_evolved;

	@Column(name = "name")
	private String vName;

	@Column(name = "type")
	private String vType;

	@Column(name = "age")
	private int vAge;

	@Column(name = "have_regd_number")
	private boolean have_regd_number;

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public String getvBrand() {
		return vBrand;
	}

	public void setvBrand(String vBrand) {
		this.vBrand = vBrand;
	}

	public Boolean getEvehicle_evolved() {
		return evehicle_evolved;
	}

	public void setEvehicle_evolved(Boolean evehicle_evolved) {
		this.evehicle_evolved = evehicle_evolved;
	}

	public String getvName() {
		return vName;
	}

	public void setvName(String vName) {
		this.vName = vName;
	}

	public String getvType() {
		return vType;
	}

	public void setvType(String vType) {
		this.vType = vType;
	}

	public int getvAge() {
		return vAge;
	}

	public void setvAge(int vAge) {
		this.vAge = vAge;
	}

	public boolean isHave_regd_number() {
		return have_regd_number;
	}

	public void setHave_regd_number(boolean have_regd_number) {
		this.have_regd_number = have_regd_number;
	}
	
	

}

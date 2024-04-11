package com.ey.vehicleadv.bean;


public class VehicleBean {

	private int id;
	private String brand;
	private boolean evehicle_evolved;
	private String name;
	private String type;
	private int age;
	private boolean have_regd_number;
	private String RC_number;
	private String owner_name;
	

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

	public VehicleBean(int id, String brand, boolean evehicle_evolved, String name, String type, int age,
			boolean have_regd_number,String RC_number,String owner_name) {
		super();
		this.id = id;
		this.brand = brand;
		this.evehicle_evolved = evehicle_evolved;
		this.name = name;
		this.type = type;
		this.age = age;
		this.have_regd_number = have_regd_number;
		this.RC_number=RC_number;
		this.owner_name=owner_name;
	}

	public VehicleBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public boolean isEvehicle_evolved() {
		return evehicle_evolved;
	}

	public void setEvehicle_evolved(boolean evehicle_evolved) {
		this.evehicle_evolved = evehicle_evolved;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isHave_regd_number() {
		return have_regd_number;
	}

	public void setHave_regd_number(boolean have_regd_number) {
		this.have_regd_number = have_regd_number;
	}

}

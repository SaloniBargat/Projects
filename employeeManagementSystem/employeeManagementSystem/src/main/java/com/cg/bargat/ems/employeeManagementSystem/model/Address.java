package com.cg.bargat.ems.employeeManagementSystem.model;

public class Address {
	
	private int id;
	private String apartmentName;
	private String floor;
	private String city;
	private int pin;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getApartmentName() {
		return apartmentName;
	}
	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	
	public Address(int id, String apartmentName, String floor, String city, int pin) {
		super();
		this.id = id;
		this.apartmentName = apartmentName;
		this.floor = floor;
		this.city = city;
		this.pin = pin;
	}
	
	@Override
	public String toString() {
		return "Address [id=" + id + ", apartmentName=" + apartmentName + ", floor=" + floor + ", city=" + city
				+ ", pin=" + pin + "]";
	}
	
	
	
	
	
	

}

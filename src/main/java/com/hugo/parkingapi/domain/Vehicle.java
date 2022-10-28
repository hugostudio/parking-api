package com.hugo.parkingapi.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vehicle implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id 
	@Column(length = 8)
	private String plate;

	@Column(length = 15)
	private String color;

	@Column(length = 25)
	private String model;
	
	public Vehicle() {
	}
	
	public Vehicle(String plate, String color, String model) {
		super();
		this.plate = plate;
		this.color = color;
		this.model = model;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	
}

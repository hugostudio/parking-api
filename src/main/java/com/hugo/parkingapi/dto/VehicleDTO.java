package com.hugo.parkingapi.dto;

import java.io.Serializable;

import com.hugo.parkingapi.domain.Vehicle;

public class VehicleDTO implements Serializable {
	private static final long serialVersionUID = 1L;		
	private String plate;

	public VehicleDTO() {
	}

	public VehicleDTO(String plate) {
		this.plate = plate;
	}

	public VehicleDTO(Vehicle obj) {
		if(obj != null){
			this.plate = obj.getPlate();
		} 
	}

	public Vehicle fromDTOToEntity() {		
		return	new Vehicle(this.getPlate(), null, null);		
	}

	public String getPlate() {
		return this.plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

}
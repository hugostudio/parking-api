package com.hugo.parkingapi.dto;

import java.io.Serializable;
import com.hugo.parkingapi.domain.Parking;

public class ParkingDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;	
	private String time;
	private Boolean paid;
	private Boolean exit;
	
	public ParkingDTO() {
	}

	public ParkingDTO(Parking obj) {
		this.id = obj.getId();
		this.time = obj.getTime();
		this.paid = obj.getPaid();
		this.exit = obj.getExit() != null ? true : false ;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Boolean isPaid() {
		return this.paid;
	}

	public Boolean getPaid() {
		return this.paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}

	public Boolean isExit() {
		return this.exit;
	}

	public Boolean getExit() {
		return this.exit;
	}

	public void setExit(Boolean exit) {
		this.exit = exit;
	}
	
}
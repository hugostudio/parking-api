package com.hugo.parkingapi.domain;

import java.io.Serializable;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Parking implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column( insertable = false, updatable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP" )	
	private Date start;

	@Temporal(TemporalType.TIMESTAMP)
	@Column( insertable = false)
	private Date exit;

	@Column(insertable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
	private Boolean paid;

	@ManyToOne @JoinColumn(name="plate", nullable = false)
	private Vehicle vehicle ; 

	public Parking() {
	}
	
	public Parking(Vehicle vehicle) {
		super();
		this.vehicle = vehicle;		
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStart() {
		return this.start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getExit() {
		return this.exit;
	}

	public void setExit(Date exit) {
		this.exit = exit;
	}

	public Boolean getPaid() {
		return this.paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}
	
	public String getTime(){
		
		Calendar dt1 = Calendar.getInstance();
		dt1.setTime(this.start);

		Calendar dt2 = Calendar.getInstance();
		if(this.exit != null){
			dt2.setTime(this.exit);
		}
		Long diferenca = 0l;
		long elapsedms = dt2.getTimeInMillis() - dt1.getTimeInMillis();
		diferenca = TimeUnit.MINUTES.convert(elapsedms, TimeUnit.MILLISECONDS);
		return  diferenca + (diferenca > 1 ? " minutes" : " minute");
	}
}

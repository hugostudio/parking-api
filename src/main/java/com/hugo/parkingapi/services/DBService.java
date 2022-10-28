package com.hugo.parkingapi.services;


import java.text.ParseException;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hugo.parkingapi.domain.Parking;
import com.hugo.parkingapi.domain.Vehicle;
import com.hugo.parkingapi.repositories.ParkingRepository;
import com.hugo.parkingapi.repositories.VehicleRepository;

@Service
public class DBService {
	
	@Autowired private ParkingRepository parkingRepository;	
	@Autowired private VehicleRepository vehicleRepository;	
	
	public DBService() {
	}
	
	public void instantiateDatabase() throws ParseException {
		Vehicle v1 = new Vehicle("WER-4321", "Cinza", "HB20");		
		Vehicle v2 = new Vehicle("WKB-0348", "Preto", "Cobalt");
		
		Parking p1 = new Parking(v1);
		Parking p2 = new Parking(v2);
		
		vehicleRepository.saveAll(Arrays.asList(v1, v2));
		parkingRepository.saveAll(Arrays.asList(p1, p2));	
	}

}

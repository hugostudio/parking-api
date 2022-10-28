package com.hugo.parkingapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hugo.parkingapi.domain.Vehicle;
import com.hugo.parkingapi.dto.VehicleDTO;
import com.hugo.parkingapi.repositories.VehicleRepository;

@Service
public class VehicleService {

	@Autowired private VehicleRepository repository;

	public List<Vehicle> findAll() {
		return repository.findAll();
	}

	public Optional<Vehicle> findByPlate(String plate) {		
		return repository.findById(plate);
	}

	public Vehicle save(VehicleDTO dto) {
		return repository.save( dto.fromDTOToEntity() );
	}
}
package com.hugo.parkingapi.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hugo.parkingapi.domain.Vehicle;
import com.hugo.parkingapi.dto.VehicleDTO;
import com.hugo.parkingapi.services.VehicleService;

@RestController
@Validated
@RequestMapping(value="/v1/vehicle")
public class VehicleResource {

	@Autowired private VehicleService service;

	@GetMapping("/")
	public ResponseEntity<List<VehicleDTO>> findAll() {
		List<Vehicle> list = service.findAll();
		List<VehicleDTO> listDto = list.stream().map(obj -> new VehicleDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}

}
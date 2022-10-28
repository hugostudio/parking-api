package com.hugo.parkingapi.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hugo.parkingapi.domain.Parking;
import com.hugo.parkingapi.dto.ParkingDTO;
import com.hugo.parkingapi.dto.ReservationDTO;
import com.hugo.parkingapi.dto.VehicleDTO;
import com.hugo.parkingapi.services.ParkingService;

@RestController
@RequestMapping(value="/v1/parking")
public class ParkingResource {

	@Autowired private ParkingService parkingService;

	@GetMapping("/{plate}")	
	public ResponseEntity<List<ParkingDTO>> listParkingByPlate( @PathVariable String plate ) {
		List<Parking> list = parkingService.listParkingByPlate(plate);
		List<ParkingDTO> listDto = list.stream().map(obj -> new ParkingDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}

	@PutMapping("/{plate}/out")
	public ResponseEntity<ParkingDTO> vehicleCheckOut( @PathVariable String plate) {
		ParkingDTO parkingDTO = new ParkingDTO(parkingService.vehicleCheckOut(plate));		
		return ResponseEntity.ok().body(parkingDTO);
	}

	@PutMapping("/{plate}/pay")
	public ResponseEntity<ParkingDTO> payParking( @PathVariable String plate) {
		ParkingDTO parkingDTO = new ParkingDTO(parkingService.payParking(plate));		
		return ResponseEntity.ok().body(parkingDTO);
	}

	@PostMapping("/")
	public ResponseEntity<ReservationDTO> vehicleCheckIn(@Valid @RequestBody VehicleDTO vehicleDTO) {
		ReservationDTO result = parkingService.vehicleCheckIn(vehicleDTO);		
		return ResponseEntity.ok().body(result);
	}
	
}
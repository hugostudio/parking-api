package com.hugo.parkingapi.services;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hugo.parkingapi.domain.Parking;
import com.hugo.parkingapi.domain.Vehicle;
import com.hugo.parkingapi.dto.ReservationDTO;
import com.hugo.parkingapi.dto.VehicleDTO;
import com.hugo.parkingapi.repositories.ParkingRepository;
import com.hugo.parkingapi.services.exceptions.DataIntegrityException;
import com.hugo.parkingapi.services.exceptions.DataValidationException;
import com.hugo.parkingapi.services.exceptions.ObjectNotFoundException;
import com.hugo.parkingapi.utils.Constants;

@Service
public class ParkingService {

	@Autowired private ParkingRepository repository;
	@Autowired private VehicleService vehicleService;

	public List<Parking> findAll() {
		return repository.findAll();
	}
	
	public List<Parking> listParkingByPlate(String plate) {
		assetValidPlate(plate);
		return repository.findAllByVehiclePlate(plate);
	}

	public ReservationDTO vehicleCheckIn(VehicleDTO vehicleDTO) {			
		assetValidPlate(vehicleDTO.getPlate());	

		Vehicle vehicle = getVehicleIfExistOrCreate(vehicleDTO);
		
		Optional<Parking> parking = repository.findLastByVehiclePlate(vehicle.getPlate());
		if(parking.isPresent() && parking.get().getExit() == null){
			throw new DataIntegrityException("Este veiculo JÁ se encontra no estacionamento !");
		}
				
		Parking newParking = new Parking(vehicle);
		repository.save(newParking);
		String resevationCod = String.format("%06d", newParking.getId());
		return new ReservationDTO(resevationCod);
	}

	public Parking vehicleCheckOut(String plate){
		assetValidPlate(plate);

		Optional<Parking> parking = repository.findLastByVehiclePlate(plate);
		
		if(!parking.isPresent()){
			throw new ObjectNotFoundException("Veiculo não encontrado !");
		}

		if(!parking.get().getPaid()){
			throw new DataIntegrityException("O estacionamento ainda não foi pago !");
		}
		
		if(parking.isPresent() && parking.get().getExit() != null){
			throw new DataIntegrityException("Este veiculo NÂO se encontra no estacionamento !");
		}

		parking.get().setExit(Calendar.getInstance().getTime());
		repository.save(parking.get());

		return parking.get();
	}

	public Parking payParking(String plate){
		assetValidPlate(plate);

		Optional<Parking> parking = repository.findLastByVehiclePlate(plate);
		if(!parking.isPresent()){
			throw new ObjectNotFoundException("Veiculo não encontrado !");
		}

		if(parking.get().getPaid() ){
			throw new DataIntegrityException("O estacionamento já foi pago !");
		}

		parking.get().setPaid(Boolean.TRUE);
		repository.save(parking.get());

		return parking.get();
	}

	private Vehicle getVehicleIfExistOrCreate(VehicleDTO vehicleDTO){
		Optional<Vehicle> optVehicle = vehicleService.findByPlate(vehicleDTO.getPlate());		
		if(!optVehicle.isPresent()){
			return vehicleService.save(vehicleDTO);
		} else {
			return optVehicle.get();
		}
	}

	private void assetValidPlate(String plate){
		if(!plate.matches(Constants.PLATE_VALIDATE_REGEX)){
			throw new DataValidationException("A placa informada não contêm um formato válido : [AAA-9999]");
		}
	}

}
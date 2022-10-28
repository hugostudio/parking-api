package com.hugo.parkingapi.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hugo.parkingapi.domain.Parking;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Integer> {

    public List<Parking> findAllByVehiclePlate( String plate );
    public Optional<Parking> findLastByVehiclePlate( String plate );    
}

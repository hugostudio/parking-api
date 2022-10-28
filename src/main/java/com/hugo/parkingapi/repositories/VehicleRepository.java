package com.hugo.parkingapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hugo.parkingapi.domain.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {

}

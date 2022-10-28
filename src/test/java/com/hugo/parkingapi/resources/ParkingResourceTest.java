package com.hugo.parkingapi.resources;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.hugo.parkingapi.domain.Parking;
import com.hugo.parkingapi.dto.ParkingDTO;
import com.hugo.parkingapi.repositories.ParkingRepository;
import com.hugo.parkingapi.services.ParkingService;



@SpringBootTest
public class ParkingResourceTest {

    
    @InjectMocks  private ParkingService parkingService;
    @Mock private ParkingRepository repository;

    @Test
    void testListParkingByPlate() {
		List<Parking> list = parkingService.listParkingByPlate("GWR-2344");
		List<ParkingDTO> listDto = list.stream().map(obj -> new ParkingDTO(obj)).collect(Collectors.toList());  
        assertNotNull(listDto);
    }

    @Test
    void testPayParking() {

    }

    @Test
    void testListParkingByPlate2() {
        
    }

    @Test
    void testPayParking2() {
        
    }

    @Test
    void testVehicleCheckIn() {
        
    }

    @Test
    void testVehicleCheckOut() {
        
    }
}

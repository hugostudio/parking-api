package com.hugo.parkingapi.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.hugo.parkingapi.domain.Parking;
import com.hugo.parkingapi.domain.Vehicle;
import com.hugo.parkingapi.repositories.ParkingRepository;

@SpringBootTest
public class ParkingServiceTest {

    @InjectMocks private ParkingService parkingService;
    @Mock private VehicleService vehicleService;
    @Mock private ParkingRepository repository;    

    @Test
    void testFindAllSuccess() {
        when(parkingService.findAll()).thenReturn(Arrays.asList(
                new Parking(new Vehicle("WER-4321", "Cinza", "HB20")),
                new Parking(new Vehicle("'WER-4322", "Branco", "Fox")),
                new Parking(new Vehicle("'WER-4323", "Preto", "Astra"))
        ));
        List<Parking> list = parkingService.findAll();
        assertEquals(3,list.size());
    }

    @Test
    void testListParkingByPlate() {
        when(parkingService.listParkingByPlate("WER-4321")).thenReturn(Arrays.asList(
                new Parking(new Vehicle("WER-4321", "Cinza", "HB20"))
        ));
        List<Parking> list = parkingService.listParkingByPlate("WER-4321");
        assertEquals(1,list.size());
    }

}

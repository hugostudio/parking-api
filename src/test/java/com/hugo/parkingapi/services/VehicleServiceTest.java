package com.hugo.parkingapi.services;

import com.hugo.parkingapi.domain.Vehicle;
import com.hugo.parkingapi.dto.VehicleDTO;
import com.hugo.parkingapi.repositories.VehicleRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class VehicleServiceTest {

    @InjectMocks
    private VehicleService vehicleService;

    @Mock
    private VehicleRepository repository;

    @Test
    void testFindAllSuccess() {
        when(vehicleService.findAll()).thenReturn(Arrays.asList(
                new Vehicle("WER-4321", "Cinza", "HB20"),
                new Vehicle("WER-4322", "Branco", "Fox"),
                new Vehicle("WER-4323", "Preto", "Astra")
        ));
        List<Vehicle> list = vehicleService.findAll();
        assertEquals(3,list.size());
    }

    @Test
    void testFindByPlateSuccess() {
        when(vehicleService.findByPlate("WER-4321")).thenReturn(
                Optional.of(new Vehicle("WER-4321", "Cinza", "HB20"))
        );
        Optional<Vehicle> vehicle = vehicleService.findByPlate("WER-4321");
        assertEquals("WER-4321",vehicle.get().getPlate());
    }

    @Test
    void testSaveSuccess() {
        VehicleDTO newVehicle = new VehicleDTO();
        newVehicle.setPlate("ABC-1020");
        when(vehicleService.save(newVehicle)).thenReturn(newVehicle.fromDTOToEntity());
        vehicleService.save(newVehicle);
        assertEquals("ABC-1020", newVehicle.getPlate());
    }

}

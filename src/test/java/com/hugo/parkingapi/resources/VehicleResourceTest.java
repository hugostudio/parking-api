package com.hugo.parkingapi.resources;

import static org.junit.jupiter.api.Assertions.assertNotNull;


import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.hugo.parkingapi.domain.Vehicle;
import com.hugo.parkingapi.dto.VehicleDTO;
import com.hugo.parkingapi.repositories.VehicleRepository;
import com.hugo.parkingapi.services.VehicleService;

@SpringBootTest
public class VehicleResourceTest {

    @InjectMocks private VehicleService service;
    @Mock private VehicleRepository repository;

    @Test
    void testFindAll() {
      List<Vehicle> list = service.findAll();
      List<VehicleDTO> listDto = list.stream().map(obj -> new VehicleDTO(obj)).collect(Collectors.toList());  
      assertNotNull(listDto);
    }
}

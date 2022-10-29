package com.hugo.parkingapi.resources;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.hugo.parkingapi.domain.Vehicle;
import com.hugo.parkingapi.services.VehicleService;

@SpringBootTest
@AutoConfigureMockMvc
public class VehicleResourceTest {
    
    @Autowired private MockMvc mockMvc;
    @MockBean private VehicleService service;

    @Test
    void testFindAll() throws Exception {
      Vehicle vehicle = new Vehicle("WER-4321", null, null);      
      Mockito.when(this.service.findAll()).thenReturn(List.of(vehicle));
      this.mockMvc.perform(get("/v1/vehicle/"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().json("[{'plate': 'WER-4321'}]"));
    }
}

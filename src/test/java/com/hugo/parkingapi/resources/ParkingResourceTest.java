package com.hugo.parkingapi.resources;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.hugo.parkingapi.domain.Parking;
import com.hugo.parkingapi.domain.Vehicle;
import com.hugo.parkingapi.services.ParkingService;


@SpringBootTest
@AutoConfigureMockMvc
public class ParkingResourceTest {

    @Autowired private MockMvc mockMvc;
    @MockBean private ParkingService parkingService;    

    @Test
    void testListParkingByPlate() throws Exception {
        Parking parking = new Parking(new Vehicle("WER-4321", null, null));      
        parking.setId(1);
        parking.setStart(Calendar.getInstance().getTime());
        parking.setPaid(false);
        Mockito.when(this.parkingService.listParkingByPlate("WER-4321")).thenReturn(List.of(parking));
        this.mockMvc.perform(get("/v1/parking/WER-4321"))
          .andDo(print())
          .andExpect(status().isOk())
          .andExpect(content().json("[{'id': 1, 'time': '0 minute', 'paid': false,'exit': false }]"));
    }

}

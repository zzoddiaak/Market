package homework.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import homework.config.MapperConfig;
import homework.config.test.TestConfig;
import homework.dto.booking.BookingFullDto;
import homework.entity.Bookings;
import homework.repository.api.BookingsRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class, MapperConfig.class})
@WebAppConfiguration
@Transactional
public class BookingsControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private BookingsRepository bookingsRepository;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

        Bookings booking1 = new Bookings();
        booking1.setId(1L);
        booking1.setStatus("CONFIRMED");

        Bookings booking2 = new Bookings();
        booking2.setId(2L);
        booking2.setStatus("PENDING");

        bookingsRepository.save(booking1);
        bookingsRepository.save(booking2);
    }

    @Test
    public void findAll() throws Exception {
        mockMvc.perform(get("/api/v1/bookings"))
                .andExpect(status().isOk());
    }

    @Test
    public void findById() throws Exception {
        mockMvc.perform(get("/api/v1/bookings/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void save() throws Exception {
        BookingFullDto dto = new BookingFullDto();
        dto.setStatus("NEW");

        mockMvc.perform(post("/api/v1/bookings")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated());
    }

    @Test
    public void update() throws Exception {
        BookingFullDto dto = new BookingFullDto();
        dto.setStatus("UPDATED");

        mockMvc.perform(put("/api/v1/bookings/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteById() throws Exception {
        mockMvc.perform(delete("/api/v1/bookings/1"))
                .andExpect(status().isNoContent());
    }
}

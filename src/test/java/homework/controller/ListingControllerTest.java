package homework.controller;

import homework.config.MapperConfig;
import homework.config.test.TestConfig;
import homework.entity.Listing;
import homework.repository.api.ListingRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class, MapperConfig.class})
@WebAppConfiguration
@Transactional
public class ListingControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ListingRepository listingRepository;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

        Listing listing1 = new Listing(1L, "Laptop", "A powerful laptop",
                new BigDecimal("999.99"), false, "Sale", "Electronics",
                "123 Main St", new BigDecimal("0.00"), LocalDateTime.now(),
                new ArrayList<>(), new ArrayList<>());
        listingRepository.save(listing1);
    }

    @Test
    public void findAll() throws Exception {
        mockMvc.perform(get("/api/v1/listings"))
                .andExpect(status().isOk());
    }

    @Test
    public void findById() throws Exception {
        mockMvc.perform(get("/api/v1/listings/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void save() throws Exception {
        Listing listing = new Listing(null, "New Item", "Description",
                new BigDecimal("100.00"), false, "Sale", "Type",
                "Address", new BigDecimal("0.00"), LocalDateTime.now(),
                new ArrayList<>(), new ArrayList<>());

        mockMvc.perform(post("/api/v1/listings")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(listing)))
                .andExpect(status().isCreated());
    }

    @Test
    public void update() throws Exception {
        Listing listing = new Listing(1L, "Updated Item", "Updated Description",
                new BigDecimal("150.00"), true, "Rent", "Type",
                "Address", new BigDecimal("0.00"), LocalDateTime.now(),
                new ArrayList<>(), new ArrayList<>());

        mockMvc.perform(put("/api/v1/listings/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(listing)))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteById() throws Exception {
        mockMvc.perform(delete("/api/v1/listings/1"))
                .andExpect(status().isNoContent());
    }
}

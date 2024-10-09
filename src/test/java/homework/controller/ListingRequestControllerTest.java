package homework.controller;

import homework.config.basic.MapperConfig;
import homework.config.test.TestConfig;
import homework.entity.ListingRequest;
import homework.repository.api.ListingRequestRepository;
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
import java.util.HashSet;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class, MapperConfig.class})
@WebAppConfiguration
@Transactional
public class ListingRequestControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ListingRequestRepository listingRequestRepository;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

        ListingRequest listingRequest1 = new ListingRequest(1L,
                new BigDecimal("500.00"), "Pending", LocalDateTime.now(),
                new HashSet<>(), new HashSet<>());
        listingRequestRepository.save(listingRequest1);
    }

    @Test
    public void findAll() throws Exception {
        mockMvc.perform(get("/api/v1/listing_requests"))
                .andExpect(status().isOk());
    }

    @Test
    public void findById() throws Exception {
        mockMvc.perform(get("/api/v1/listing_requests/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void save() throws Exception {
        ListingRequest listingRequest = new ListingRequest(null,
                new BigDecimal("600.00"), "Pending", LocalDateTime.now(),
                new HashSet<>(), new HashSet<>());

        mockMvc.perform(post("/api/v1/listing_requests")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(listingRequest)))
                .andExpect(status().isCreated());
    }

    @Test
    public void update() throws Exception {
        ListingRequest listingRequest = new ListingRequest(1L,
                new BigDecimal("700.00"), "Accepted", LocalDateTime.now(),
                new HashSet<>(), new HashSet<>());

        mockMvc.perform(put("/api/v1/listing_requests/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(listingRequest)))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteById() throws Exception {
        mockMvc.perform(delete("/api/v1/listing_requests/1"))
                .andExpect(status().isNoContent());
    }
}

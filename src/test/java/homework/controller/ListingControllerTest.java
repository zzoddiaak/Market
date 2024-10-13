package homework.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import homework.config.basic.MapperConfig;
import homework.config.test.TestConfig;
import homework.entity.Listing;
import homework.entity.User; // Import necessary entities
import homework.entity.Category; // Import necessary entities
import homework.repository.api.ListingRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class, MapperConfig.class})
@WebAppConfiguration
@Transactional
@ActiveProfiles("test")
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

        Listing listing1 = new Listing(
                1L,
                "Sample Listing",
                "This is a sample listing description",
                BigDecimal.valueOf(100.00),
                false,
                "Sale",
                "Electronics",
                "123 Sample St",
                null,
                LocalDateTime.now(),
                Arrays.asList(new User()),
                Arrays.asList(new Category())
        );
        listingRepository.save(listing1);
    }

    @Test
    @WithMockUser(username = "user", roles = {"user"},password = "password1")
    public void findAll() throws Exception {
        mockMvc.perform(get("/api/v1/listings"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", roles = {"user"},password = "password1")
    public void findById() throws Exception {
        mockMvc.perform(get("/api/v1/listings/1"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", roles = {"admin"},password = "password1")
    public void save() throws Exception {
        Listing listing = new Listing(
                null,
                "New Listing",
                "Description of the new listing",
                BigDecimal.valueOf(200.00),
                true,
                "Rent",
                "Real Estate",
                "456 New St",
                BigDecimal.valueOf(1500.00),
                LocalDateTime.now(),
                null,
                null
        );

        mockMvc.perform(post("/api/v1/listings")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(listing)))
                .andExpect(status().isCreated());
    }

    @Test
    @WithMockUser(username = "admin", roles = {"admin"},password = "password1")
    public void update() throws Exception {
        Listing listing = new Listing(
                1L,
                "Updated Listing",
                "Updated description",
                BigDecimal.valueOf(250.00),
                true,
                "Sale",
                "Electronics",
                "789 Updated St",
                null,
                LocalDateTime.now(),
                null,
                null
        );

        mockMvc.perform(put("/api/v1/listings/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(listing)))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", roles = {"admin"},password = "password1")
    public void deleteById() throws Exception {
        mockMvc.perform(delete("/api/v1/listings/1"))
                .andExpect(status().isNoContent());
    }
}

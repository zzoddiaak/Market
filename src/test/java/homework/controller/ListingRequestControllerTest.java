package homework.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import homework.config.basic.MapperConfig;
import homework.config.test.TestConfig;
import homework.entity.ListingRequest;
import homework.entity.Listing; // Assuming this import is needed
import homework.entity.User; // Assuming this import is needed
import homework.repository.api.ListingRequestRepository;
import homework.repository.api.ListingRepository; // Ensure you have a repository for Listing
import homework.repository.api.UserRepository; // Ensure you have a repository for User
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
import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class, MapperConfig.class})
@WebAppConfiguration
@Transactional
@ActiveProfiles("test")
public class ListingRequestControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ListingRequestRepository listingRequestRepository;

    @Autowired
    private ListingRepository listingRepository;

    @Autowired
    private UserRepository userRepository;

    private Listing sampleListing;
    private User sampleUser;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

        sampleListing = new Listing();
        sampleListing.setId(1L);
        sampleListing.setTitle("Sample Listing");
        sampleListing.setDescription("Description");
        sampleListing.setPrice(BigDecimal.valueOf(100.00));
        sampleListing.setNegotiable(false);
        sampleListing.setAddress("123 Sample St");
        sampleListing.setCreatedAt(LocalDateTime.now());

        listingRepository.save(sampleListing);

        sampleUser = new User();
        sampleUser.setId(1L);
        sampleUser.setFirstName("Sample");
        sampleUser.setLastName("User");
        sampleUser.setBio("Sample user bio");
        sampleUser.setCreatedAt(LocalDateTime.now());

        userRepository.save(sampleUser);

        ListingRequest listingRequest1 = new ListingRequest();
        listingRequest1.setId(1L);
        listingRequest1.setOfferedPrice(BigDecimal.valueOf(90.00));
        listingRequest1.setStatus("Pending");
        listingRequest1.setCreatedAt(LocalDateTime.now());

        listingRequestRepository.save(listingRequest1);
    }

    @Test
    @WithMockUser(username = "user", roles = {"user"},password = "password1")
    public void findAll() throws Exception {
        mockMvc.perform(get("/api/v1/listing_requests"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", roles = {"user"},password = "password1")
    public void findById() throws Exception {
        mockMvc.perform(get("/api/v1/listing_requests/1"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", roles = {"admin"},password = "password1")
    public void save() throws Exception {
        ListingRequest listingRequest = new ListingRequest(null, BigDecimal.valueOf(150.00), "Pending", LocalDateTime.now(), new HashSet<>(Set.of(sampleListing)), new HashSet<>(Set.of(sampleUser)));

        mockMvc.perform(post("/api/v1/listing_requests")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(listingRequest)))
                .andExpect(status().isCreated());
    }

    @Test
    @WithMockUser(username = "admin", roles = {"admin"},password = "password1")
    public void update() throws Exception {
        ListingRequest listingRequest = new ListingRequest(1L, BigDecimal.valueOf(100.00), "Accepted", LocalDateTime.now(), new HashSet<>(Set.of(sampleListing)), new HashSet<>(Set.of(sampleUser)));

        mockMvc.perform(put("/api/v1/listing_requests/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(listingRequest)))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", roles = {"admin"},password = "password1")
    public void deleteById() throws Exception {
        mockMvc.perform(delete("/api/v1/listing_requests/1"))
                .andExpect(status().isNoContent());
    }
}


package homework.controller;

import homework.config.basic.MapperConfig;
import homework.config.test.TestConfig;
import homework.entity.UserRating;
import homework.repository.api.UserRatingRepository;
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

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class, MapperConfig.class})
@WebAppConfiguration
@Transactional
public class UserRatingControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRatingRepository userRatingRepository;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

        UserRating userRating1 = new UserRating(1L, 5, LocalDateTime.now(), new ArrayList<>(), new ArrayList<>());
        userRatingRepository.save(userRating1);
    }

    @Test
    public void findAll() throws Exception {
        mockMvc.perform(get("/api/v1/user_ratings"))
                .andExpect(status().isOk());
    }

    @Test
    public void findById() throws Exception {
        mockMvc.perform(get("/api/v1/user_ratings/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void save() throws Exception {
        UserRating userRating = new UserRating(null, 4, LocalDateTime.now(), new ArrayList<>(), new ArrayList<>());

        mockMvc.perform(post("/api/v1/user_ratings")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userRating)))
                .andExpect(status().isCreated());
    }

    @Test
    public void update() throws Exception {
        UserRating userRating = new UserRating(1L, 5, LocalDateTime.now(), new ArrayList<>(), new ArrayList<>());

        mockMvc.perform(put("/api/v1/user_ratings/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userRating)))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteById() throws Exception {
        mockMvc.perform(delete("/api/v1/user_ratings/1"))
                .andExpect(status().isNoContent());
    }
}

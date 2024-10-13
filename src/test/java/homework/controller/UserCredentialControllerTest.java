package homework.controller;

import homework.config.basic.MapperConfig;
import homework.config.test.TestConfig;
import homework.entity.UserCredential;
import homework.repository.api.UserCredentialRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class, MapperConfig.class})
@WebAppConfiguration
@Transactional
@ActiveProfiles("test")
public class UserCredentialControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserCredentialRepository userCredentialRepository;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        UserCredential userCredential1 = new UserCredential(1L, "user1", "password1", LocalDateTime.now(), new ArrayList<>());
        userCredentialRepository.save(userCredential1);
    }

    @Test
    @WithMockUser(username = "user", roles = {"user"},password = "password1")
    public void findAll() throws Exception {
        mockMvc.perform(get("/api/v1/user_credentials"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", roles = {"user"},password = "password1")
    public void findById() throws Exception {
        mockMvc.perform(get("/api/v1/user_credentials/1"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", roles = {"admin"},password = "password1")
    public void save() throws Exception {
        UserCredential userCredential = new UserCredential(null, "user2", "password2", LocalDateTime.now(), new ArrayList<>());
        mockMvc.perform(post("/api/v1/user_credentials")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userCredential)))
                .andExpect(status().isCreated());
    }

    @Test
    @WithMockUser(username = "admin", roles = {"admin"},password = "password1")
    public void update() throws Exception {
        UserCredential userCredential = new UserCredential(1L, "user1", "newpassword", LocalDateTime.now(), new ArrayList<>());
        mockMvc.perform(put("/api/v1/user_credentials/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userCredential)))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", roles = {"admin"},password = "password1")
    public void deleteById() throws Exception {
        mockMvc.perform(delete("/api/v1/user_credentials/1"))
                .andExpect(status().isNoContent());
    }
}

package homework.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import homework.config.basic.MapperConfig;
import homework.config.test.TestConfig;
import homework.entity.Comment;
import homework.repository.api.CommentRepository;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class, MapperConfig.class})
@WebAppConfiguration
@Transactional
@ActiveProfiles("test")
public class CommentControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CommentRepository commentRepository;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

        Comment comment1 = new Comment(1L, "Great listing!", LocalDateTime.now(), null);
        commentRepository.save(comment1);
    }

    @Test
    @WithMockUser(username = "user", roles = {"user"}, password = "password1")
    public void findAll() throws Exception {
        mockMvc.perform(get("/api/v1/comments"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", roles = {"user"},password = "password1")
    public void findById() throws Exception {
        mockMvc.perform(get("/api/v1/comments/1"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", roles = {"admin"}, password = "password1")
    public void save() throws Exception {
        Comment comment = new Comment(null, "New comment!", LocalDateTime.now(), null);

        mockMvc.perform(post("/api/v1/comments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comment)))
                .andExpect(status().isCreated());
    }

    @Test
    @WithMockUser(username = "admin", roles = {"admin"}, password = "password1")
    public void update() throws Exception {
        Comment comment = new Comment(1L, "Updated comment!", LocalDateTime.now(), null);

        mockMvc.perform(put("/api/v1/comments/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comment)))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", roles = {"admin"}, password = "password1")
    public void deleteById() throws Exception {
        mockMvc.perform(delete("/api/v1/comments/1"))
                .andExpect(status().isNoContent());
    }
}

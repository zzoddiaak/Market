package homework.controller;

import homework.config.basic.MapperConfig;
import homework.config.test.TestConfig;
import homework.entity.FavoriteItem;
import homework.repository.api.FavoriteItemRepository;
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

import java.util.HashSet;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class, MapperConfig.class})
@WebAppConfiguration
@Transactional
public class FavoriteItemControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private FavoriteItemRepository favoriteItemRepository;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

        FavoriteItem favoriteItem1 = new FavoriteItem(1L, new HashSet<>(), new HashSet<>());
        favoriteItemRepository.save(favoriteItem1);
    }

    @Test
    public void findAll() throws Exception {
        mockMvc.perform(get("/api/v1/favorite_items"))
                .andExpect(status().isOk());
    }

    @Test
    public void findById() throws Exception {
        mockMvc.perform(get("/api/v1/favorite_items/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void save() throws Exception {
        FavoriteItem favoriteItem = new FavoriteItem(null, new HashSet<>(), new HashSet<>());

        mockMvc.perform(post("/api/v1/favorite_items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(favoriteItem)))
                .andExpect(status().isCreated());
    }

    @Test
    public void update() throws Exception {
        FavoriteItem favoriteItem = new FavoriteItem(1L, new HashSet<>(), new HashSet<>());

        mockMvc.perform(put("/api/v1/favorite_items/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(favoriteItem)))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteById() throws Exception {
        mockMvc.perform(delete("/api/v1/favorite_items/1"))
                .andExpect(status().isNoContent());
    }
}

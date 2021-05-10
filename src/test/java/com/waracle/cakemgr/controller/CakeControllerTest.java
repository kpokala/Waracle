package com.waracle.cakemgr.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CakeController.class)
@EnableWebMvc
public class CakeControllerTest {
    protected MockMvc mvc;
    @Test
    public void createCake() throws Exception {
            mvc.perform(post("/cake").content("{cakeId:123}")
                    .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(status().isOk());
    }


    @Test
    void findAllApplications() throws Exception {
        this.mvc.perform(get("/cakes")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void getByClientName() throws Exception {
        this.mvc.perform(get("/cakes/Jones")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }
}

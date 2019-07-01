package com.cloudDomus.cloudDommus;

import com.cloudDomus.cloudDommus.Service.ServiceController;

import static org.hamcrest.Matchers.hasItem;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ServiceControllerTests {

  /*  MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    ServiceController serviceController;

    @Before
    public void setup() throws Exception {

        this.mockMvc = standaloneSetup(this.serviceController).build();// Standalone context

        // mockMvc = MockMvcBuilders.webAppContextSetup(wac)

        // .build();

    }

    @Test
    public void getServiceByIdTest() throws Exception {

        mockMvc.perform(get("/api/services/service"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$..type", hasItem(is("Babysitter"))));

    }*/

}


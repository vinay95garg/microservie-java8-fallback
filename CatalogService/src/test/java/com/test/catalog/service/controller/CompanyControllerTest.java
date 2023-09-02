package com.test.catalog.service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.catalog.service.entities.Company;
import com.test.catalog.service.services.CompanyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CompanyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CompanyService companyService;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testGetTopITCompanies() throws Exception {
         List<Company> mockCompanies = Arrays.asList(
                new Company(1L, "Company A", "IT"),
                new Company(2L, "Company B", "IT")
        );

       Mockito.when(companyService.getTopITCompanies()).thenReturn(mockCompanies);

        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/companies/top"));

        result.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("Company A")))
                .andExpect(jsonPath("$[1].name", is("Company B")));
    }
}

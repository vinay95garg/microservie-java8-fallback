package com.test.service.edge.service.controller;

import com.test.service.edge.service.entities.Company;
import com.test.service.edge.service.services.EdgeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.ArrayList;
import java.util.List;

@SpringJUnitConfig
@WebMvcTest(EdgeController.class)
public class EdgeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EdgeService edgeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetTopCompanies() throws Exception {
        // Create a list of mock companies
        List<Company> mockCompanies = new ArrayList<>();
        Company company1 = new Company();
        company1.setName("Company 1");
        company1.setDescription("Description 1");
        mockCompanies.add(company1);

        // Mock the behavior of the edgeService
        Mockito.when(edgeService.getTopITCompanies()).thenReturn(mockCompanies);

        // Perform the GET request to the controller
        mockMvc.perform(MockMvcRequestBuilders.get("/companies/top-companies"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Company 1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].description").value("Description 1"));
    }

}

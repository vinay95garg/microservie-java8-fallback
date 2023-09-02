package com.test.service.edge.service.service;

import com.test.service.edge.service.entities.Company;
import com.test.service.edge.service.external.services.CatalogueService;
import com.test.service.edge.service.services.EdgeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class EdgeServiceTest {

    @Mock
    private CatalogueService catalogueService;

    @Mock
    private RestTemplate restTemplate;

    private EdgeService edgeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        edgeService = new EdgeService(restTemplate, catalogueService);
    }

    @Test
    public void testGetTopITCompanies() {
        // Mock the behavior of the CatalogueService
        Company mockCompany = new Company();
        mockCompany.setName("Company A");
        mockCompany.setDescription("Description A");
        when(catalogueService.getcompanies()).thenReturn(Collections.singletonList(mockCompany));

        // Call the method under test
        List<Company> result = edgeService.getTopITCompanies();

        // Verify the result
        assertEquals(1, result.size());
        assertEquals("Company A", result.get(0).getName());
        assertEquals("Description A", result.get(0).getDescription());
    }
}

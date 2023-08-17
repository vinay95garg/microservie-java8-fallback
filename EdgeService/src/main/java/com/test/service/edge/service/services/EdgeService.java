package com.test.service.edge.service.services;

import com.test.service.edge.service.entities.Company;
import com.test.service.edge.service.external.services.CatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class EdgeService {



    private final RestTemplate restTemplate;

    private final CatalogueService catalogueService;
    @Autowired
    public EdgeService(RestTemplate restTemplate,CatalogueService catalogueService) {
        this.restTemplate = restTemplate;
        this.catalogueService = catalogueService;
    }

    public List<Company> getTopITCompanies(){
        List<Company> companyList = catalogueService.getcompanies();
        return companyList;
      //  Company[] companies =restTemplate.getForObject("http://CATALOGUE-SERVICE/companies/top", Company[].class);
      //  return Arrays.asList(companies);
    }
}

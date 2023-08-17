package com.test.service.edge.service.controller;

import com.test.service.edge.service.entities.Company;
import com.test.service.edge.service.services.EdgeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class EdgeController {

    private final EdgeService edgeService;

    private Logger logger = LoggerFactory.getLogger(EdgeController.class);

    @Autowired
    public EdgeController(EdgeService edgeService) {
        this.edgeService = edgeService;
    }




  /*  @GetMapping("/top-companies")
    public String getTopCompanies() {
        return circuitBreakerFactory.create("company-catalog-service")
                .run(() -> restTemplate.getForObject("http://company-catalog-service/companies", String.class),
                        throwable -> "Fallback: Unable to retrieve top companies at the moment");
    }*/

    @GetMapping("/top-companies")
    @CircuitBreaker(name="companyCatalogueBreaker",fallbackMethod = "catalogueFallBack")
    public List<Company> getTopCompanies() {
      return edgeService.getTopITCompanies();
    }

    private int callsCounter = 0;

    public List<Company> catalogueFallBack(Exception ex) throws Exception {
        Company defaultCompany = new Company();
        defaultCompany.setName("None");
        defaultCompany.setDescription("Service is down currently, unable to fetch");

        List<Company> defaultCompanyList = new ArrayList<>();
        defaultCompanyList.add(defaultCompany);

        return defaultCompanyList;
    }


      }

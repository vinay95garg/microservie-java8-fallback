package com.test.catalog.service.controller;

import com.test.catalog.service.entities.Company;
import com.test.catalog.service.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/top")
    public List<Company> getTopITCompanies() {
        return companyService.getTopITCompanies();
    }
}

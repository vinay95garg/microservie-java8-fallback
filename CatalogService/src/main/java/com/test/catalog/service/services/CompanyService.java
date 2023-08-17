package com.test.catalog.service.services;
import com.test.catalog.service.entities.Company;
import com.test.catalog.service.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getTopITCompanies() {
         return companyRepository.findAll();
    }
}

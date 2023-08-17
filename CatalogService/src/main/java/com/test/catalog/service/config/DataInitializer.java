package com.test.catalog.service.config;

import com.test.catalog.service.entities.Company;
import com.test.catalog.service.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CompanyRepository companyRepository;

    @Autowired
    public DataInitializer(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        insertSampleData();
    }

    private void insertSampleData() {
        Company company1 = new Company(1l,"Company A", "Description for Company A");
        Company company2 = new Company(2l,"Company B", "Description for Company B");
        Company company3 = new Company(3l,"Company C", "Description for Company C");

        companyRepository.saveAll(Arrays.asList(company1, company2, company3));
    }
}

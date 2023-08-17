package com.test.catalog.service.repositories;


import com.test.catalog.service.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}

package com.test.service.edge.service.external.services;

import com.test.service.edge.service.entities.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="CATALOGUE-SERVICE")
public interface CatalogueService {

    @GetMapping("companies/top")
    List<Company> getcompanies();
}

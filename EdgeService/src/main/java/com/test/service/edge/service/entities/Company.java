package com.test.service.edge.service.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    private Long id;
    private String name;
    private String description;

}

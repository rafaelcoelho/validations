package com.persoal.validation.model;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class Products {
    private final String name;
    private final String description;
    @Max(100)
    @Min(1)
    private final int price;
}

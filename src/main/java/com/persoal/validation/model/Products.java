package com.persoal.validation.model;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class Products {
    private final String name;
    @NotEmpty
    private final String description;
    @Max(100)
    @Min(5)
    private final int price;
}

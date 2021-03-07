package com.persoal.validation.model;

import lombok.Data;
import lombok.NonNull;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class Order {
    @NonNull
    private final String client;
    @NonNull
    private final String number;
    @Valid
    @NotEmpty
    private List<Products> products;
}

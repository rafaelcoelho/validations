package com.persoal.validation.services;

import com.persoal.validation.model.Order;
import com.persoal.validation.model.Products;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Service
@Validated
public class OrderProcess {

    public int doProcess(@Valid Order order, @Valid @Min(400) int price2) {
        return order.getProducts().stream()
                .map(Products::getPrice)
                .filter(price -> price < 500)
                .reduce(0, Integer::sum);
    }

}

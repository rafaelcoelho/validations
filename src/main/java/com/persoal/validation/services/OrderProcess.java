package com.persoal.validation.services;

import com.persoal.validation.model.Order;
import com.persoal.validation.model.Products;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class OrderProcess {

    public int doProcess(@Valid Order order) {
        return order.getProducts().stream()
                .map(Products::getPrice)
                .filter(price -> price < 50)
                .reduce(0, Integer::sum);
    }

}

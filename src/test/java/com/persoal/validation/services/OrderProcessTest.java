package com.persoal.validation.services;

import com.persoal.validation.model.Order;
import com.persoal.validation.model.Products;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class OrderProcessTest {

    private OrderProcess service;

    @BeforeEach
    void setUp() {
        service = new OrderProcess();
    }

    @Test
    void doProcess() {
        Order order = new Order("Rafael", "2021");

        List<Products> products = List.of(
                new Products("Keyboard", "Keychron k1 red switch", 40),
                new Products("Mouse", "logitech", 25)
        );

        order.setProducts(products);

        int result = service.doProcess(order);

        Assertions.assertThat(result)
                .isEqualTo(65);
    }
}
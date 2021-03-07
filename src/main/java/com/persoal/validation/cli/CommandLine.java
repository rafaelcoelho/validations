package com.persoal.validation.cli;

import com.persoal.validation.model.Order;
import com.persoal.validation.model.Products;
import com.persoal.validation.services.OrderProcess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class CommandLine {

    @Autowired
    private OrderProcess orderService;

    public int placeOrder(final String productName, int price) {
        Order order = new Order("John", "2021");
        Products product = new Products(productName, "Some description", price);

        order.setProducts(List.of(product));

        return orderService.doProcess(order);
    }

    public int placeOrder(final String productName, int price, final List<Products> products) {
        Order order = new Order("John", "2021");
        order.setProducts(products);

        return orderService.doProcess(order);
    }
}

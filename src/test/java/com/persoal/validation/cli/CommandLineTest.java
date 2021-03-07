package com.persoal.validation.cli;

import com.persoal.validation.model.Products;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolationException;
import java.util.Collections;
import java.util.List;

@SpringBootTest
class CommandLineTest {

    @Autowired
    private CommandLine cli;

    @Test
    @DisplayName("Place order with invalid price should throw exception")
    void placeOrder_withInvalidPrice() {
        int price = 200;

        Assertions.assertThatThrownBy(() -> cli.placeOrder("Keyboard", cli.placeOrder("Keyboard", price)))
                .isInstanceOf(ConstraintViolationException.class)
                .hasMessageContaining("price: must be less than or equal to");
    }

    @Test
    @DisplayName("Place order with valid price should return total")
    void placeOrder_withValidPrice() {
        int price = 50;
        int result = cli.placeOrder("Keyboard", price);

        Assertions.assertThat(result)
                .isEqualTo(price);
    }

    @Test
    @DisplayName("Place order with empty products list should throw exception")
    void placeOrder_withEmptyProducts() {
        int price = 50;

        Assertions.assertThatThrownBy(() -> cli.placeOrder("Keyboard", price, Collections.emptyList()))
                .isInstanceOf(ConstraintViolationException.class)
                .hasMessageContaining("products: must not be empty");
    }

    @Test
    @DisplayName("Place order with one invalid product price should throw exception")
    void placeOrder_withOneInvalidProduct() {
        int price = 50;

        List<Products> products = List.of(
                new Products("Keyboard", "mechanical keyboard", price),
                new Products("Display", "ultra wide 4k", price / 11));

        Assertions.assertThatThrownBy(() -> cli.placeOrder("Keyboard", price, products))
                .isInstanceOf(ConstraintViolationException.class)
                .hasMessageContaining("price: must be greater than or equal to");
    }
}
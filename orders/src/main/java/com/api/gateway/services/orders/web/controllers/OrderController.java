package com.api.gateway.services.orders.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.gateway.services.orders.core.usecases.create_order.CreateOrderUseCase;
import com.api.gateway.services.orders.core.usecases.create_order.CreateOrderUseCaseInput;
import com.api.gateway.services.orders.core.usecases.find_all_orders.FindAllOrdersUseCase;
import com.api.gateway.services.orders.core.usecases.find_all_orders.FindAllOrdersUseCaseOutput;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    private CreateOrderUseCase createOrderUseCase;
    private FindAllOrdersUseCase findAllOrdersUseCase;

    public OrderController(CreateOrderUseCase createOrderUseCase, FindAllOrdersUseCase findAllOrdersUseCase) {
        this.createOrderUseCase = createOrderUseCase;
        this.findAllOrdersUseCase = findAllOrdersUseCase;
    }

    @PostMapping("/create-order")
    public ResponseEntity<?> createOrder(@RequestBody CreateOrderUseCaseInput requestBody) {
        this.createOrderUseCase.execute(requestBody);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<FindAllOrdersUseCaseOutput> findAllOrders() {
        var orders = this.findAllOrdersUseCase.execute();
        return ResponseEntity.ok(orders);
    }
}

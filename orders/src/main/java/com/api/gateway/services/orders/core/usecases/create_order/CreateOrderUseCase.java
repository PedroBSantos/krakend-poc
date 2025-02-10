package com.api.gateway.services.orders.core.usecases.create_order;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.api.gateway.services.orders.core.domain.Order;
import com.api.gateway.services.orders.core.domain.OrderRepository;

@Service
public class CreateOrderUseCase {

    private OrderRepository orders;

    public CreateOrderUseCase(OrderRepository orders) {
        this.orders = orders;
    }

    public void execute(CreateOrderUseCaseInput input) {
        var order = new Order(UUID.randomUUID());
        for (var item : input.items())
            order.addItem(item.itemId(), item.amount(), item.itemName(), item.itemPrice());
        this.orders.add(order);
    }
}

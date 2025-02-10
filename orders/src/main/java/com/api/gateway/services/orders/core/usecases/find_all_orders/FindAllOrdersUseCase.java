package com.api.gateway.services.orders.core.usecases.find_all_orders;

import java.util.LinkedList;

import org.springframework.stereotype.Service;

import com.api.gateway.services.orders.core.domain.OrderItem;
import com.api.gateway.services.orders.core.domain.OrderRepository;

@Service
public class FindAllOrdersUseCase {
    
    private OrderRepository orders;

    public FindAllOrdersUseCase(OrderRepository orders) {
        this.orders = orders;
    }

    public FindAllOrdersUseCaseOutput execute() {
        var orders = this.orders.findAllOrders();
        var ordersDTO = new LinkedList<OrderDTO>();
        for (var order : orders) {
            var orderProducts = order.getItems()
                .stream()
                .map(OrderItem::getItemName)
                .toList();
            ordersDTO.add(new OrderDTO(order.getId(), order.total(), orderProducts));
        }
        return new FindAllOrdersUseCaseOutput(ordersDTO);
    }
}

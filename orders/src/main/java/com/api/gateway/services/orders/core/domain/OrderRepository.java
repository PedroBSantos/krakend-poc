package com.api.gateway.services.orders.core.domain;

import java.util.List;

public interface OrderRepository {
    
    void add(Order order);

    List<Order> findAllOrders();
}

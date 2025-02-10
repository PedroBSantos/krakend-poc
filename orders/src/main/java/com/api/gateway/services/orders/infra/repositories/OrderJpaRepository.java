package com.api.gateway.services.orders.infra.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.gateway.services.orders.core.domain.Order;
import com.api.gateway.services.orders.core.domain.OrderRepository;

@Repository
public interface OrderJpaRepository extends OrderRepository, JpaRepository<Order, UUID> {

    @Override
    default void add(Order order) {
        this.save(order);
    }

    @Override
    default List<Order> findAllOrders() {
        return this.findAll();
    }
}

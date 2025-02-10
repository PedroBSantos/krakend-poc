package com.api.gateway.services.orders.core.domain;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    private UUID id;
    @OneToMany(mappedBy = "order", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<OrderItem> items;

    protected Order() {
        this.items = new LinkedList<>();
    }

    public Order(UUID id) {
        this();
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public List<OrderItem> getItems() {
        return items.stream().toList();
    }

    public int amountOfItems() {
        return this.items.size();
    }

    public void addItem(UUID itemId, int amount, String itemName, BigDecimal itemPrice) {
        this.items.add(new OrderItem(itemId, amount, itemName, itemPrice, this));
    }

    public BigDecimal total() {
        return this.items
                .stream()
                .map(i -> i.subtotal())
                .reduce(BigDecimal.valueOf(0.0), BigDecimal::add);
    }
}

package com.api.gateway.services.orders.core.domain;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private UUID itemId;
    private int amount;
    private String itemName;
    private BigDecimal itemPrice;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    protected OrderItem() {
    }

    public OrderItem(UUID itemId, int amount, String itemName, BigDecimal itemPrice, Order order) {
        this.itemId = itemId;
        this.amount = amount;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public UUID getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }

    public String getItemName() {
        return itemName;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public Order getOrder() {
        return order;
    }

    public BigDecimal subtotal() {
        return itemPrice.multiply(BigDecimal.valueOf(this.amount));
    }
}

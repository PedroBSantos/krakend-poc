package com.api.gateway.services.stock.core.usecases.dtos;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductDTO {
    
    private UUID id;
    private String name;
    private int amountOnStock;
    private BigDecimal price;
    private String category;

    public ProductDTO(UUID id, String name, int amountOnStock, BigDecimal price, String category) {
        this.id = id;
        this.name = name;
        this.amountOnStock = amountOnStock;
        this.price = price;
        this.category = category;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAmountOnStock() {
        return amountOnStock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}

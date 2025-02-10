package com.api.gateway.services.stock.core.usecases.find_all_products;

import java.util.List;

import com.api.gateway.services.stock.core.usecases.dtos.ProductDTO;

public class FindAllProductsUseCaseOutput {
    
    private List<ProductDTO> products;

    public FindAllProductsUseCaseOutput(List<ProductDTO> products) {
        this.products = products;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }
}

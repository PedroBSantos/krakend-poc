package com.api.gateway.services.stock.core.usecases.find_all_products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.gateway.services.stock.core.domain.ProductRepository;
import com.api.gateway.services.stock.core.usecases.dtos.ProductDTO;

@Service
public class FindAllProductsUseCase {
    
    private ProductRepository products;

    public FindAllProductsUseCase(@Autowired ProductRepository products) {
        this.products = products;
    }

    public FindAllProductsUseCaseOutput execute() {
        var products = this.products
            .findAllProducts()
            .stream().map(p -> new ProductDTO(p.getId(), p.getName(), p.getAmountOnStock(), p.getPrice(), p.getCategory().getName()))
            .toList();
        return new FindAllProductsUseCaseOutput(products);
    }
}

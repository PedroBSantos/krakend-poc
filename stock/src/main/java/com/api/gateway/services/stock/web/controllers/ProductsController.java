package com.api.gateway.services.stock.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.gateway.services.stock.core.usecases.find_all_products.FindAllProductsUseCase;
import com.api.gateway.services.stock.core.usecases.find_all_products.FindAllProductsUseCaseOutput;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(value = "/stock/products")
public class ProductsController {
    
    private FindAllProductsUseCase findAllProductsUseCase;

    public ProductsController(@Autowired FindAllProductsUseCase findAllProductsUseCase) {
        this.findAllProductsUseCase = findAllProductsUseCase;
    }

    @GetMapping()
    public ResponseEntity<FindAllProductsUseCaseOutput> findAllProducts() {
        var products = this.findAllProductsUseCase.execute();
        return ResponseEntity.ok(products);
    }
}

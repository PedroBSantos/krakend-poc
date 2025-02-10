package com.api.gateway.services.stock.infra.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.gateway.services.stock.core.domain.Product;
import com.api.gateway.services.stock.core.domain.ProductRepository;

@Repository
public interface ProductJpaRepository extends ProductRepository, JpaRepository<Product, UUID> {

    @Override
    default void add(Product product) {
        this.save(product);
    }

    @Override
    default List<Product> findAllProducts() {
        return this.findAll();
    }    
}

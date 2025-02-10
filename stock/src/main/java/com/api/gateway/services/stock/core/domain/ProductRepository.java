package com.api.gateway.services.stock.core.domain;

import java.util.List;

public interface ProductRepository {
    
    void add(Product product);

    List<Product> findAllProducts();
}

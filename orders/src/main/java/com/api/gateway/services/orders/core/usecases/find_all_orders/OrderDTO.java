package com.api.gateway.services.orders.core.usecases.find_all_orders;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record OrderDTO(UUID id, BigDecimal total, List<String> products) {
    
}

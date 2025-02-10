package com.api.gateway.services.orders.core.usecases.create_order;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderItemDTO(UUID itemId, int amount, String itemName, BigDecimal itemPrice) {
}

package com.api.gateway.services.orders.core.usecases.create_order;

import java.util.List;

public record CreateOrderUseCaseInput(List<OrderItemDTO> items) {
}

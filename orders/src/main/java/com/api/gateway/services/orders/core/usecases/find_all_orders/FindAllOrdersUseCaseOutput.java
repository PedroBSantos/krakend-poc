package com.api.gateway.services.orders.core.usecases.find_all_orders;

import java.util.List;

public record FindAllOrdersUseCaseOutput(List<OrderDTO> orders) {
    
}

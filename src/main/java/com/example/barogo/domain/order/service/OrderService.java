package com.example.barogo.domain.order.service;

import com.example.barogo.common.ApiResponse;
import com.example.barogo.domain.order.dto.OrderInputRequest;

public interface OrderService {

  ApiResponse<?> inputOrder(OrderInputRequest orderInputRequest);
}

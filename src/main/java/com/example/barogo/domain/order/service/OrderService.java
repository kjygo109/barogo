package com.example.barogo.domain.order.service;

import com.example.barogo.common.ApiResponse;
import com.example.barogo.domain.order.dto.OrderInputRequest;
import com.example.barogo.domain.order.dto.AddressOrderRequest;
import com.example.barogo.domain.order.dto.RetrieveOrderRequest;

public interface OrderService {

  ApiResponse<?> inputOrder(OrderInputRequest orderInputRequest);

  ApiResponse<?> retrieveOrder(RetrieveOrderRequest retrieveOrderRequest);

  ApiResponse<?> addressModifyOrder(AddressOrderRequest addressOrderRequest);
}

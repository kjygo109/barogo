package com.example.barogo.domain.orderItem.service;

import com.example.barogo.domain.orderItem.dto.OrderItemDto;
import com.example.barogo.domain.orderItem.dto.OrderItemRequestDto;

public interface OrderItemService {

  OrderItemDto search(OrderItemRequestDto orderItemRequestDto);
}

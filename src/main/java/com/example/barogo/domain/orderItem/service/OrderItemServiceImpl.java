package com.example.barogo.domain.orderItem.service;

import com.example.barogo.domain.orderItem.dao.OrderItemDao;
import com.example.barogo.domain.orderItem.dto.OrderItemDto;
import com.example.barogo.domain.orderItem.dto.OrderItemRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

  private final OrderItemDao orderItemDao;

  /**
   * 주문-상품 매핑 테이블 조회
   */
  @Override
  public OrderItemDto search(OrderItemRequestDto orderItemRequestDto) {
    return new OrderItemDto(orderItemDao.searchOrderItem(orderItemRequestDto));
  }
}

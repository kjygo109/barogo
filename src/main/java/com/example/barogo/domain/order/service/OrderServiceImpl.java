package com.example.barogo.domain.order.service;

import com.example.barogo.common.ApiException;
import com.example.barogo.common.ApiResponse;
import com.example.barogo.domain.item.dto.ItemRequestDto;
import com.example.barogo.domain.item.service.ItemService;
import com.example.barogo.domain.model.Order;
import com.example.barogo.domain.order.dao.OrderDao;
import com.example.barogo.domain.order.dto.OrderInputRequest;
import com.example.barogo.domain.orderItem.dao.OrderItemDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.barogo.common.ApiResponseCode.*;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

  private final ItemService itemServiceImpl;

  private final OrderDao orderDao;

  private final OrderItemDao orderItemDao;

  /**
   * 배달정보 입력
   */
  @Override
  @Transactional
  public ApiResponse<?> inputOrder(OrderInputRequest orderInputRequest) {

    // 데이터 검증 및 Order 객체 생성
    Order order = orderInputRequest.validate()
            .toOrder(itemServiceImpl.searchItem(ItemRequestDto.builder().pks(orderInputRequest.getItems()
                    .stream().map(OrderInputRequest.Item::getPk).toList()).build()));

    try {

      // order 테이블 insert
      orderDao.insertOrder(order);

      // order_item 테이블 insert
      orderItemDao.insertOrderItem(orderInputRequest.toOrderItem(order.getPk()));
    } catch (Exception e) {
      throw new ApiException(ORDER_FAILED);
    }

    return new ApiResponse<>(true, "성공적으로 처리되었습니다.");
  }
}

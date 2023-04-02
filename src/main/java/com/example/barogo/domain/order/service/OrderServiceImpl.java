package com.example.barogo.domain.order.service;

import com.example.barogo.common.ApiException;
import com.example.barogo.common.ApiResponse;
import com.example.barogo.domain.agency.dto.AgencyDto;
import com.example.barogo.domain.agency.dto.AgencyRequestDto;
import com.example.barogo.domain.agency.service.AgencyService;
import com.example.barogo.domain.commonCode.dto.CommonCodeDto;
import com.example.barogo.domain.commonCode.dto.CommonCodeRequestDto;
import com.example.barogo.domain.commonCode.service.CommonCodeService;
import com.example.barogo.domain.item.dto.ItemDto;
import com.example.barogo.domain.item.dto.ItemRequestDto;
import com.example.barogo.domain.item.service.ItemService;
import com.example.barogo.domain.model.Order;
import com.example.barogo.domain.order.dao.OrderDao;
import com.example.barogo.domain.order.dto.*;
import com.example.barogo.domain.orderItem.dao.OrderItemDao;
import com.example.barogo.domain.orderItem.dto.OrderItemDto;
import com.example.barogo.domain.orderItem.dto.OrderItemRequestDto;
import com.example.barogo.domain.orderItem.service.OrderItemService;
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

  private final OrderItemService orderItemServiceImpl;

  private final AgencyService agencyServiceImpl;

  private final CommonCodeService commonCodeServiceImpl;

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

  /**
   * 배달정보 조회
   */
  @Override
  public ApiResponse<?> retrieveOrder(RetrieveOrderRequest retrieveOrderRequest) {

    // 데이터 검증
    retrieveOrderRequest.validate();

    // OrderDto 객체 생성
    OrderDto orderDto = searchOrderByMemberPk(OrderRequestDto
            .builder()
            .memberPk(retrieveOrderRequest.getMemberPk())
            .startAt(retrieveOrderRequest.formatter(retrieveOrderRequest.getStartAt()))
            .endAt(retrieveOrderRequest.formatter(retrieveOrderRequest.getEndAt()))
            .build());

    // OrderItemDto 객체 생성
    OrderItemDto orderItemDto = orderItemServiceImpl.search(OrderItemRequestDto
            .builder()
            .pks(orderDto.getOrderPks())
            .build());

    // Item 객체 생성
    ItemDto itemDto = itemServiceImpl.searchItem(ItemRequestDto
            .builder()
            .pks(orderItemDto.getItemPks())
            .build());

    // AgencyDto 객체 생성
    AgencyDto agencyDto = agencyServiceImpl.searchAgency(AgencyRequestDto
            .builder()
            .pks(itemDto.getAgencyPks())
            .build());

    // CommonCodeDto 객체 생성
    CommonCodeDto commonCodeDto = commonCodeServiceImpl.searchCommonCode(CommonCodeRequestDto
            .builder()
            .codeDiv("DELIVERY_STATUS")
            .build());

    return new ApiResponse<>(true, new RetrieveOrderResponse(orderDto, orderItemDto, itemDto, agencyDto, commonCodeDto));
  }

  @Override
  @Transactional
  public ApiResponse<?> addressModifyOrder(AddressOrderRequest addressOrderRequest) {

    // 데이터 검증
    addressOrderRequest.validate();

    // Order 객체 생성
    Order order = searchOrderByPk(OrderRequestDto
            .builder()
            .orderPk(addressOrderRequest.getOrderPk())
            .build());

    // 주문 주소 변경
    updateOrderAddress(order.statusCheck().setDeliveryAddress(addressOrderRequest.getDeliveryAddress()));

    return new ApiResponse<>(true, "배달 주소가 " + order.getDeliveryAddress() + " 로 변경 됐습니다.");
  }

  /**
   * 주문 조회 by memberPk
   */
  private OrderDto searchOrderByMemberPk(OrderRequestDto orderRequestDto) {
    return new OrderDto(orderDao.searchOrderByMemberPk(orderRequestDto));
  }

  /**
   * 주문 조회 by OrderPk
   */
  private Order searchOrderByPk(OrderRequestDto orderRequestDto) {
    return orderDao.searchOrderByPk(orderRequestDto);
  }

  /**
   * 주문 주소 변경
   */
  private void updateOrderAddress(Order order) {

    try {

      orderDao.updateOrder(order);
    } catch (Exception e) {

      throw new ApiException(UPDATE_ORDER_ADDRESS_EX);
    }
  }
}

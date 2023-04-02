package com.example.barogo.domain.order.dto;

import com.example.barogo.common.ApiEnum;
import com.example.barogo.common.ApiException;
import com.example.barogo.domain.item.dto.ItemDto;
import com.example.barogo.domain.model.Order;
import com.example.barogo.domain.model.OrderItem;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.barogo.common.ApiResponseCode.*;

@Getter
public class OrderInputRequest {

  private int memberPk;
  private String deliveryAddress;
  private List<Item> items;

  @Getter
  public static class Item {

    private int pk;
    private int quantity;
  }

  /**
   * OrderInputRequest 검증
   */
  public OrderInputRequest validate() {

    if (this.memberPk <= 0) throw new ApiException(MEMBER_PK_EMPTY);
    if (!StringUtils.hasText(this.deliveryAddress)) throw new ApiException(DELIVERY_ADDRESS_EMPTY);
    if (items.isEmpty()) throw new ApiException(ITEMS_EMPTY);
    return this;
  }

  /**
   * Order 객체 생성
   */
  public Order toOrder(ItemDto itemDto) {

    // 총 금액 계산
    int totalPrice = this.items
            .stream().map(item -> item.getQuantity() *
                    Optional.ofNullable(itemDto.getItems().get(item.getPk())).orElseThrow(() -> new ApiException(ITEMS_SEARCH_EX))
                            .getPrice())
            .reduce(0, Integer::sum);

    return Order.builder()
            .memberPk(this.memberPk)
            .orderAt(LocalDateTime.now())
            .deliveryAddress(this.getDeliveryAddress())
            .deliveryStatus(ApiEnum.DELIVERY_STATUS.READY.getCode())
            .totalPrice(totalPrice)
            .build();
  }

  /**
   * OrderItem 객체 List 생성
   */
  public List<OrderItem> toOrderItem(int orderPk) {

    return this.items.stream().map(item -> OrderItem
                    .builder()
                    .itemPk(item.getPk())
                    .orderPk(orderPk)
                    .quantity(item.getQuantity())
                    .build())
            .collect(Collectors.toList());
  }
}

package com.example.barogo.domain.orderItem.dto;

import com.example.barogo.domain.model.OrderItem;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
public class OrderItemDto {

  private final Map<Integer, Map<Integer, InnerOrderItem>> orderItemMap = new HashMap<>();
  private final List<Integer> itemPks = new ArrayList<>();

  public OrderItemDto(List<OrderItem> orderItems) {

    this.orderItemMap.putAll(orderItems
            .stream()
            .map(InnerOrderItem::new)
            .collect(Collectors.groupingBy(InnerOrderItem::getOrderPk, Collectors.toMap(InnerOrderItem::getItemPk, Function.identity()))));

    this.orderItemMap.keySet()
            .forEach(integer -> itemPks.addAll(this.getOrderItemMap().get(integer).keySet()));
  }

  @Getter
  public static class InnerOrderItem {

    private final int pk;
    private final int orderPk;
    private final int itemPk;
    private final int quantity;

    public InnerOrderItem(OrderItem orderItem) {

      this.pk = orderItem.getPk();
      this.orderPk = orderItem.getOrderPk();
      this.itemPk = orderItem.getItemPk();
      this.quantity = orderItem.getQuantity();
    }
  }
}

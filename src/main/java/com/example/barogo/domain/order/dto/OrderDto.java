package com.example.barogo.domain.order.dto;

import com.example.barogo.domain.model.Order;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class OrderDto {

  private final List<InnerOrder> orders = new ArrayList<>();
  private final List<Integer> orderPks = new ArrayList<>();

  public OrderDto(List<Order> orders) {

    orders.forEach(order -> {
      this.orders.add(new InnerOrder(order));
      this.orderPks.add(order.getPk());
    });
  }

  @Getter
  public static class InnerOrder {

    private final int pk;
    private final int memberPk;
    private final LocalDateTime orderAt;
    private final LocalDateTime deliveryAt;
    private final String deliveryAddress;
    private final String deliveryStatus;
    private final int totalPrice;

    public InnerOrder(Order order) {

      this.pk = order.getPk();
      this.memberPk = order.getMemberPk();
      this.orderAt = order.getOrderAt();
      this.deliveryAt = order.getDeliveryAt();
      this.deliveryAddress = order.getDeliveryAddress();
      this.deliveryStatus = order.getDeliveryStatus();
      this.totalPrice = order.getTotalPrice();
    }
  }
}

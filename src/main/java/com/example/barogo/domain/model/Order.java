package com.example.barogo.domain.model;

import com.example.barogo.common.ApiEnum;
import com.example.barogo.common.ApiException;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

import static com.example.barogo.common.ApiResponseCode.DELIVERY_STATUS_EX;

@Getter
@Builder
public class Order {

  private int pk;
  private int memberPk;
  private LocalDateTime orderAt;
  private LocalDateTime deliveryAt;
  private String deliveryAddress;
  private String deliveryStatus;
  private int totalPrice;

  public Order statusCheck() {

    if (!ApiEnum.DELIVERY_STATUS.READY.getCode().equals(deliveryStatus)) throw new ApiException(DELIVERY_STATUS_EX);

    return this;
  }

  public Order setDeliveryAddress(String address) {
    this.deliveryAddress = address;

    return this;
  }
}

package com.example.barogo.domain.order.dto;

import com.example.barogo.common.ApiException;
import lombok.Getter;

import static com.example.barogo.common.ApiResponseCode.*;

@Getter
public class RequestOrderAddress {

  private int orderPk;
  private String deliveryAddress;

  public RequestOrderAddress validate() {

    if (this.orderPk <= 0) throw new ApiException(ORDER_PK_EMPTY);
    if (this.deliveryAddress.isEmpty()) throw new ApiException(DELIVERY_ADDRESS_EMPTY);

    return this;
  }
}

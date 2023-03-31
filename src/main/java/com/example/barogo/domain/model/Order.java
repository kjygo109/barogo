package com.example.barogo.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

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
}

package com.example.barogo.domain.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Order {

  private int pk;
  private int memberPk;
  private LocalDateTime orderAt;
  private LocalDateTime deliveryAt;
  private String deliveryAddress;
  private String deliveryStatus;
  private int totalPrice;
}

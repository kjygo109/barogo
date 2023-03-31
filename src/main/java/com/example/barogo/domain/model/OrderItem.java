package com.example.barogo.domain.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderItem {

  private int pk;
  private int itemPk;
  private int orderPk;
  private int quantity;
}

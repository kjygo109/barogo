package com.example.barogo.domain.model;

import lombok.Getter;

@Getter
public class OrderItem {

  private int pk;
  private int itemPk;
  private int orderPk;
  private int quantity;
}

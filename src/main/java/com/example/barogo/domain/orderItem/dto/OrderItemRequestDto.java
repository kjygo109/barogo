package com.example.barogo.domain.orderItem.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class OrderItemRequestDto {

  private List<Integer> pks;
}

package com.example.barogo.domain.order.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class OrderRequestDto {

  private int memberPk;
  private LocalDateTime startAt;
  private LocalDateTime endAt;

  private int orderPk;
}

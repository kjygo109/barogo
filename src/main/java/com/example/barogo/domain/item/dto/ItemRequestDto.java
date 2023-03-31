package com.example.barogo.domain.item.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ItemRequestDto {

  private List<Integer> pks;
}

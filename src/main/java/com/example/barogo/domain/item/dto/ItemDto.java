package com.example.barogo.domain.item.dto;

import com.example.barogo.domain.model.Item;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
public class ItemDto {

  private final Map<Integer, InnerItem> items = new HashMap<>();

  public ItemDto(List<Item> items) {

    this.items.putAll(items.stream().map(InnerItem::new)
            .collect(Collectors.toMap(InnerItem::getPk, Function.identity())));
  }

  @Getter
  public static class InnerItem {

    private final int pk;
    private final int agencyPk;
    private final String name;
    private final int price;

    public InnerItem(Item item) {

      this.pk = item.getPk();
      this.agencyPk = item.getAgencyPk();
      this.name = item.getName();
      this.price = item.getPrice();
    }
  }
}

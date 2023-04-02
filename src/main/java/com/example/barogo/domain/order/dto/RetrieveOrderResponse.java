package com.example.barogo.domain.order.dto;

import com.example.barogo.domain.agency.dto.AgencyDto;
import com.example.barogo.domain.commonCode.dto.CommonCodeDto;
import com.example.barogo.domain.item.dto.ItemDto;
import com.example.barogo.domain.orderItem.dto.OrderItemDto;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public class RetrieveOrderResponse {

  private final List<ResponseOrder> response = new ArrayList<>();

  public RetrieveOrderResponse(OrderDto orderDto, OrderItemDto orderItemDto,
                               ItemDto itemDto, AgencyDto agencyDto, CommonCodeDto commonCodeDto) {

    this.response.addAll(orderDto.getOrders().stream().map(innerOrder ->
            new ResponseOrder(innerOrder,
                    commonCodeDto.getCommonCodeMap(),
                    orderItemDto.getOrderItemMap().get(innerOrder.getPk()),
                    itemDto.getItems(),
                    agencyDto.getAgencyMap())).collect(Collectors.toList()));
  }

  @Getter
  private static class ResponseOrder {

    private final LocalDateTime orderAt;
    private final LocalDateTime deliveryAt;
    private final String deliveryAddress;
    private final String deliveryStatus;
    private final int totalPrice;

    private final List<ResponseItem> items = new ArrayList<>();

    public ResponseOrder(OrderDto.InnerOrder order,
                         Map<String, CommonCodeDto.InnerCommonCode> commonCodeMap,
                         Map<Integer, OrderItemDto.InnerOrderItem> integerInnerOrderItemMap,
                         Map<Integer, ItemDto.InnerItem> itemMap,
                         Map<Integer, AgencyDto.InnerAgency> agencyMap) {

      this.orderAt = order.getOrderAt();
      this.deliveryAt = order.getDeliveryAt();
      this.deliveryAddress = order.getDeliveryAddress();
      this.deliveryStatus = commonCodeMap.get(order.getDeliveryStatus()).getCodeVal();
      this.totalPrice = order.getTotalPrice();

      integerInnerOrderItemMap.keySet().forEach(integer -> this.items.add(new ResponseItem(integerInnerOrderItemMap.get(integer), itemMap, agencyMap)));
    }

    @Getter
    private static class ResponseItem {

      private final String agencyName;
      private final String agencyAddress;
      private final String name;
      private final int price;
      private final int quantity;

      public ResponseItem(OrderItemDto.InnerOrderItem orderItem, Map<Integer, ItemDto.InnerItem> itemMap,
                          Map<Integer, AgencyDto.InnerAgency> agencyMap) {

        int agencyPk = itemMap.get(orderItem.getItemPk()).getAgencyPk();

        this.agencyName = agencyMap.get(agencyPk).getName();
        this.agencyAddress = agencyMap.get(agencyPk).getAddress();
        this.name = itemMap.get(orderItem.getItemPk()).getName();
        this.price = itemMap.get(orderItem.getItemPk()).getPrice();
        this.quantity = orderItem.getQuantity();
      }
    }
  }
}

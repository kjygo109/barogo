package com.example.barogo.domain.order.controller;

import com.example.barogo.common.ApiResponse;
import com.example.barogo.domain.order.dto.OrderInputRequest;
import com.example.barogo.domain.order.dto.AddressOrderRequest;
import com.example.barogo.domain.order.dto.RetrieveOrderRequest;
import com.example.barogo.domain.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

  private final OrderService orderServiceImpl;

  @PostMapping("/input")
  public ApiResponse<?> inputOrder(@RequestBody OrderInputRequest orderInputRequest) {
    return orderServiceImpl.inputOrder(orderInputRequest);
  }

  @GetMapping("/retrieve")
  public ApiResponse<?> retrieveOrder(@RequestBody RetrieveOrderRequest retrieveOrderRequest) {
    return orderServiceImpl.retrieveOrder(retrieveOrderRequest);
  }

  @PutMapping("/address")
  public ApiResponse<?> addressModifyOrder(@RequestBody AddressOrderRequest addressOrderRequest) {
    return orderServiceImpl.addressModifyOrder(addressOrderRequest);
  }

  @PutMapping("/status")
  public ApiResponse<?> statusModifyOrder() {
    /* todo : 4. 배달정보 갱신(배달중,완료,취소) -> statusModify */
    return new ApiResponse<>(true);
  }
}

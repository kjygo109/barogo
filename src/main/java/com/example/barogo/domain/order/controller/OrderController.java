package com.example.barogo.domain.order.controller;

import com.example.barogo.common.ApiResponse;
import com.example.barogo.domain.order.dto.OrderInputRequest;
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
  public ApiResponse<?> retrieveOrder() {
    /* todo : 2. 배달정보 조회 -> retrieve
        1. 배달 조회 시 필요한 정보는 기간 입니다. (기간은 최대 3일),
        2. 기간 내에 사용자가 주문한 배달의 리스트를 제공 */
    return new ApiResponse<>(true);
  }

  @PutMapping("/address")
  public ApiResponse<?> addressModifyOrder() {
    /* todo : 3. 배달주소 수정 -> addressModify
        1. 도착지 주소를 요청 받아 처리
        2. 사용자가 변경 가능한 배달인 경우에만 수정이 가능 */
    return new ApiResponse<>(true);
  }

  @PutMapping("/status")
  public ApiResponse<?> statusModifyOrder() {
    /* todo : 4. 배달정보 갱신(배달중,완료,취소) -> statusModify */
    return new ApiResponse<>(true);
  }
}

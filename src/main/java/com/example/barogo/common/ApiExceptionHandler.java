package com.example.barogo.common;

import lombok.extern.log4j.Log4j2;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Log4j2
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

  private ResponseEntity<Object> buildResponseEntity(ApiResponse<Void> response) {
    return ResponseEntity.ok(response);
  }

  @ExceptionHandler(ApiException.class)
  protected ResponseEntity<Object> handleIntApiException(ApiException ex) {
    ApiResponse<Void> response = new ApiResponse<>(false);
    response.setCode(ex.getCode());
    response.setMessage(ex.getMessage());
    return buildResponseEntity(response);
  }
}

package com.example.barogo.domain.order.dto;

import com.example.barogo.common.ApiException;
import lombok.Getter;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static com.example.barogo.common.ApiResponseCode.*;

@Getter
public class RetrieveOrderRequest {

  private int memberPk;
  private String startAt;
  private String endAt;

  /**
   * RetrieveOrderRequest 검증
   */
  public RetrieveOrderRequest validate() {

    if (this.memberPk <= 0) throw new ApiException(MEMBER_PK_EMPTY);
    if (this.startAt.isEmpty()) throw new ApiException(START_AT_EMPTY);
    if (this.endAt.isEmpty()) throw new ApiException(END_AT_EMPTY);

    try {

      LocalDateTime startAt = formatter(this.startAt);
      LocalDateTime endAt = formatter(this.endAt);

      if (startAt.isAfter(endAt)) throw new ApiException(START_AT_END_AT_EX);
      if (ChronoUnit.DAYS.between(startAt, endAt) > 3) throw new ApiException(DATE_OVER_EX);

    } catch (DateTimeException e) {
      throw new ApiException(DATE_FORMAT_EX);
    }

    return this;
  }

  /**
   * 날짜 포맷변경
   */
  public LocalDateTime formatter(String date) {
    return LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
  }
}

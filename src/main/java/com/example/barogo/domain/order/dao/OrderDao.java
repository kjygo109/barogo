package com.example.barogo.domain.order.dao;

import com.example.barogo.domain.model.Order;
import com.example.barogo.domain.order.dto.OrderRequestDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderDao {

  void insertOrder(Order order);

  List<Order> searchOrderByMemberPk(OrderRequestDto orderRequestDto);

  Order searchOrderByPk(OrderRequestDto orderRequestDto);

  void updateOrder(Order order);
}

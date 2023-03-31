package com.example.barogo.domain.orderItem.dao;

import com.example.barogo.domain.model.OrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderItemDao {

  void insertOrderItem(List<OrderItem> orderItem);
}

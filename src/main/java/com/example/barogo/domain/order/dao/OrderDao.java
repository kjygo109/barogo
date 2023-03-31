package com.example.barogo.domain.order.dao;

import com.example.barogo.domain.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OrderDao {

  void insertOrder(Order order);
}

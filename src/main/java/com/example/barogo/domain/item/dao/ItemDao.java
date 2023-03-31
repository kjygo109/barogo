package com.example.barogo.domain.item.dao;

import com.example.barogo.domain.item.dto.ItemRequestDto;
import com.example.barogo.domain.model.Item;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ItemDao {

  List<Item> searchItem(ItemRequestDto itemRequestDto);
}

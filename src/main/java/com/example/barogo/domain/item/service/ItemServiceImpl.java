package com.example.barogo.domain.item.service;

import com.example.barogo.domain.item.dao.ItemDao;
import com.example.barogo.domain.item.dto.ItemDto;
import com.example.barogo.domain.item.dto.ItemRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

  private final ItemDao itemDao;

  /**
   * 상품 조회
   */
  @Override
  public ItemDto searchItem(ItemRequestDto itemRequestDto) {
    return new ItemDto(itemDao.searchItem(itemRequestDto));
  }
}

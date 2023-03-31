package com.example.barogo.domain.item.service;

import com.example.barogo.domain.item.dto.ItemDto;
import com.example.barogo.domain.item.dto.ItemRequestDto;

public interface ItemService {

  ItemDto searchItem(ItemRequestDto itemRequestDto);
}

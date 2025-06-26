package com.barcode.uniplo.dao;

import com.barcode.uniplo.domain.ItemDto;

import java.util.List;

public interface ItemDao {
    void insertItem(ItemDto item);
    List<ItemDto> selectAllItems();
    ItemDto selectItemById(int id);
}

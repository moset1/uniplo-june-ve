package com.barcode.uniplo.dao;

import com.barcode.uniplo.domain.ItemDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void insertTest() {

        for(int i=0; i<20; i++) {
            ItemDto itemDto = new ItemDto(1, "Tshirt"+i, 1234, "poly, cotton", LocalDateTime.now(), "Top", "T-shirts", "man", 2, "item_102.jpeg");
            itemRepository.insertItem(itemDto);
        }

    }



    @Test
    public void getGenderTest() {

        List<ItemDto> list = itemRepository.findByGenderCode("man");
        System.out.println(list.size());
        System.out.println(list);
    }
}
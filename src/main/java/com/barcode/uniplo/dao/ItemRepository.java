package com.barcode.uniplo.dao;

import com.barcode.uniplo.domain.ItemDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class ItemRepository implements ItemDao {
    @Autowired
    private SqlSession sqlSession;

    private final String namespace = "com.barcode.uniplo.dao.ItemDao"; // itemMapper.xml의 namespace

    public void insertItem(ItemDto item) {
        sqlSession.insert(namespace + ".insertItem", item);
    }

    public List<ItemDto> selectAllItems() {
        return sqlSession.selectList(namespace + ".selectAllItems");
    }

    public ItemDto selectItemById(Integer item_id) {
        return sqlSession.selectOne(namespace + ".selectItemById", item_id);
    }


    public int getPriceByItemId(int id) {
        return sqlSession.selectOne(namespace + ".getPriceByItemId", id);
    }

    public List<ItemDto> findByGenderCode(String gender_code) {
        return sqlSession.selectList(namespace + ".selectByGender", gender_code);
    }
}


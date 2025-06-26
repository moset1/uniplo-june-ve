package com.barcode.uniplo.dao;

import com.barcode.uniplo.domain.GenderDto;
import com.barcode.uniplo.domain.ItemCateDetailDto;
import com.barcode.uniplo.domain.ItemCateDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepository implements CategoryDao {
    @Autowired
    private SqlSession session;
    private static String namespace = "com.barcode.uniplo.dao.CategoryMapper.";

    @Override
    public List<GenderDto> getAllGenders() {
        return session.selectList(namespace + "getAllGenders");
    }

    @Override
    public List<ItemCateDto> getItemCatesByGender(Integer gender_id) {
        return session.selectList(namespace + "getItemCatesByGender", gender_id);
    }

    @Override
    public List<ItemCateDetailDto> getItemCateDetailsByCate(Integer item_cate_id) {
        return session.selectList(namespace + "getItemCateDetailsByCate", item_cate_id);
    }

}

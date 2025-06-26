package com.barcode.uniplo.service;

import com.barcode.uniplo.dao.CategoryDao;
import com.barcode.uniplo.domain.GenderDto;
import com.barcode.uniplo.domain.ItemCateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDao categoryDao;

    @Override
    public List<GenderDto> getAllGenders() {
        return categoryDao.getAllGenders();
    }

    @Override
    public List<ItemCateDto> getItemCatesByGender(Integer gender_id) {
        return categoryDao.getItemCatesByGender(gender_id);
    }
}

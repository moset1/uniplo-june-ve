package com.barcode.uniplo.service;

import com.barcode.uniplo.dao.CategoryDao;
import com.barcode.uniplo.domain.GenderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl {
    @Autowired
    CategoryDao categoryDao;

    public List<GenderDto> getAllGenders() {
        return categoryDao.getAllGenders();
    }
}

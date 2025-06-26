package com.barcode.uniplo.service;

import com.barcode.uniplo.domain.GenderDto;
import com.barcode.uniplo.domain.ItemCateDto;

import java.util.List;

public interface CategoryService {
    List<GenderDto> getAllGenders();

    List<ItemCateDto> getItemCatesByGender(Integer gender_id);
}

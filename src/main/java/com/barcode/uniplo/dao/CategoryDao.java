package com.barcode.uniplo.dao;

import com.barcode.uniplo.domain.GenderDto;
import com.barcode.uniplo.domain.ItemCateDetailDto;
import com.barcode.uniplo.domain.ItemCateDto;

import java.util.List;

public interface CategoryDao {
    List<GenderDto> getAllGenders();

    List<ItemCateDto> getItemCatesByGender(Integer gender_id);

    List<ItemCateDetailDto> getItemCateDetailsByCate(Integer item_cate_id);
}

package com.barcode.uniplo.controller;

import com.barcode.uniplo.domain.ItemCateDto;
import com.barcode.uniplo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{gender_id}")
    public String showItemCate(@PathVariable("gender_id") Integer gender_id, Model m) {
        List<ItemCateDto> itemCates = categoryService.getItemCatesByGender(gender_id);
        m.addAttribute("itemCates", itemCates);
        m.addAttribute("gender_id", gender_id);
        return "item/category";
    }
}

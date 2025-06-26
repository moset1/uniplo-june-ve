package com.barcode.uniplo.controller;

import com.barcode.uniplo.domain.ItemDto;
import com.barcode.uniplo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    // 전체 상품 조회(목록보기)
    @GetMapping("/list")
    public String getAllItem(Model model) {
        List<ItemDto> itemList = itemService.getAllItems();
        model.addAttribute("items", itemList);
        return "item/list"; // -> /WEB-INF/views/item/list.jsp  제품 목록 JSP 파일 이름 다르게 만들면 바꾸기
    }

    @GetMapping("/{id}")
    public String getItemById(@PathVariable("id") int id, Model model) {
        ItemDto item = itemService.getItemById(id);
        if (item == null) {
            return "error/404"; // 추후 404 페이지 만들면 연결
        }
        model.addAttribute("item", item);
        return "item/item"; // → /WEB-INF/views/item/item.jsp
    }

    @GetMapping("/cate_women")
    public String showWomenCatePage() {
        return "item/cate_women";
    }

    @GetMapping("/cate_men")
    public String showMenCategoryPage() {
        return "item/cate_men";
    }

    @GetMapping("/cate_kids")
    public String showKidsCategoryPage() {
        return "item/cate_kids";
    }

    @GetMapping("/cate_baby")
    public String showBabyCategoryPage() {
        return "item/cate_baby";
    }



    // by Mose
    @GetMapping("")
    public String getGender(@RequestParam("gender") String gender, Model m) {

        List<ItemDto> items = itemService.findByGender(gender);
        m.addAttribute("items", items);

        return "item/list";

    }
}

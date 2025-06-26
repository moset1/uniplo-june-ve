package com.barcode.uniplo.controller;

import com.barcode.uniplo.dao.ItemRepository;
import com.barcode.uniplo.domain.CartDto;
import com.barcode.uniplo.domain.ItemDto;
import com.barcode.uniplo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.stream.Stream;

@Controller
public class HomeController {


    @RequestMapping(value="/", method= RequestMethod.GET)
    public String home() {
        return "main/index";
    }

}

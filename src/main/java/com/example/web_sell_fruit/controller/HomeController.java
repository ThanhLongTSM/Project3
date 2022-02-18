package com.example.web_sell_fruit.controller;


import com.example.web_sell_fruit.models.CategoryDTO;
import com.example.web_sell_fruit.models.ProductDTO;
import com.example.web_sell_fruit.dao.impl.service.CategoryService;
import com.example.web_sell_fruit.dao.impl.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/")
    public String index() {
        return "redirect:/home";
    }

    @GetMapping(value = "/home")
    public String home(HttpServletRequest request) {
        List<CategoryDTO> categoryDTOs = categoryService.getList();
        request.setAttribute("listCategory", categoryDTOs);

        int page = 0;
        request.setAttribute("page", page);
        List<ProductDTO> productDTOs = productService.getList(page,12);
        request.setAttribute("listProduct", productDTOs);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(!authentication.getName().equalsIgnoreCase("anonymousUser")) {
            request.setAttribute("authentication", authentication.getName());
        }
        return "home";
    }

    @GetMapping(value = "/home/pages")
    public String homePage(HttpServletRequest request, @RequestParam("page")int page) {
        List<CategoryDTO> categoryDTOs = categoryService.getList();
        request.setAttribute("listCategory", categoryDTOs);

        List<ProductDTO> productDTOs = productService.getList(page,12);
        request.setAttribute("listProduct", productDTOs);


        request.setAttribute("page", page);
        return "home";
    }

    @GetMapping(value = "/home/{category}")
    public String home(HttpServletRequest request, @PathVariable("category") String nameCategory) {
        List<CategoryDTO> categoryDTOs = categoryService.getList();
        request.setAttribute("listCategory", categoryDTOs);

        List<ProductDTO> productDTOs = categoryService.getByName(nameCategory).getProductDTOs();
        request.setAttribute("listProduct", productDTOs);
        return "home";
    }

    @GetMapping(value = "/403")
    public String err403() {
        return "403";
    }

    @GetMapping(value = "/admin")
    public String home() {
        return "admin";
    }
}

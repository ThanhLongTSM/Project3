package com.example.web_sell_fruit.controller;

import com.example.web_sell_fruit.models.CategoryDTO;
import com.example.web_sell_fruit.models.ProductDTO;
import com.example.web_sell_fruit.dao.impl.service.CategoryService;
import com.example.web_sell_fruit.dao.impl.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class ViewProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/detailproduct/{id}")
    public String viewDetailProduct(HttpServletRequest request, @PathVariable("id") int id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        request.setAttribute("authentication",authentication.getName());
        List<CategoryDTO> categoryDTOs = categoryService.getList();
        request.setAttribute("listCategory", categoryDTOs);
        ProductDTO productDTO = productService.getById(id);

        request.setAttribute("product", productDTO);

        return "user/viewDetailProduct";
    }
}

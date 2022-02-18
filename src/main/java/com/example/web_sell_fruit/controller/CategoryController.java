package com.example.web_sell_fruit.controller;


import com.example.web_sell_fruit.models.CategoryDTO;
import com.example.web_sell_fruit.dao.impl.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/admin/QuanLyDanhMuc")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/DanhSach")
    public String list(HttpServletRequest request) {
        List<CategoryDTO> listCategoryDTOs = categoryService.getList();
        request.setAttribute("list", listCategoryDTOs);
        return "admin/category/list";
    }

    @GetMapping(value = "/ChiTiet/{id}")
    public String detail(HttpServletRequest request, @PathVariable("id") int id) {
        CategoryDTO categoryDTO = categoryService.getById(id);
        request.setAttribute("category", categoryDTO);
        return "admin/category/detail";
    }

    @GetMapping(value = "/Them")
    public String add(Model model) {
        CategoryDTO categoryDTO = new CategoryDTO();
        model.addAttribute("category", categoryDTO);
        return "admin/category/formAdd";
    }

    @PostMapping(value = "/Them")
    public String add(Model model, @ModelAttribute("category") CategoryDTO categoryDTO) {
        categoryService.addOrUpDate(categoryDTO);
        return "redirect:/admin/QuanLyDanhMuc/DanhSach";
    }

    @GetMapping(value = "/Sua/{id}")
    public String update(Model model, @PathVariable("id")int id) {
        CategoryDTO categoryDTO = categoryService.getById(id);
        model.addAttribute("category", categoryDTO);
        return "admin/category/formUpdate";
    }

    @PostMapping(value = "/Sua")
    public String update(Model model, @ModelAttribute("category") CategoryDTO categoryDTO) {
        categoryService.addOrUpDate(categoryDTO);
        return "redirect:/admin/QuanLyDanhMuc/DanhSach";
    }

    @GetMapping(value = "/Xoa/{id}")
    public String delete(@PathVariable("id") int id) {
        categoryService.delete(id);
        return "redirect:/admin/QuanLyDanhMuc/DanhSach";
    }
}

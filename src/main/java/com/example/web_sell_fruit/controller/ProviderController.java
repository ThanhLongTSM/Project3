package com.example.web_sell_fruit.controller;


import com.example.web_sell_fruit.models.ProviderDTO;
import com.example.web_sell_fruit.dao.impl.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/admin/QuanLyNhaCungCap")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @GetMapping(value = "/DanhSach")
    public String list(HttpServletRequest request) {
        List<ProviderDTO> listProviderDTOs = providerService.getList();
        request.setAttribute("list", listProviderDTOs);
        return "admin/provider/list";
    }

    @GetMapping(value = "/ChiTiet/{id}")
    public String detail(HttpServletRequest request, @PathVariable("id") int id) {
        ProviderDTO providerDTO = providerService.getById(id);
        request.setAttribute("provider", providerDTO);
        return "admin/provider/detail";
    }

    @GetMapping(value = "/Them")
    public String add(Model model) {
        ProviderDTO providerDTO = new ProviderDTO();
        model.addAttribute("provider", providerDTO);
        return "admin/provider/formAdd";
    }

    @PostMapping(value = "/Them")
    public String add(Model model, @ModelAttribute("provider") ProviderDTO providerDTO) {
        providerService.addOrUpDate(providerDTO);
        return "redirect:/admin/QuanLyNhaCungCap/DanhSach";
    }

    @GetMapping(value = "/Sua/{id}")
    public String update(Model model, @PathVariable("id")int id) {
        ProviderDTO providerDTO = providerService.getById(id);
        model.addAttribute("provider", providerDTO);
        return "admin/provider/formUpdate";
    }

    @PostMapping(value = "/Sua")
    public String update(Model model, @ModelAttribute("provider") ProviderDTO providerDTO) {
        providerService.addOrUpDate(providerDTO);
        return "redirect:/admin/QuanLyNhaCungCap/DanhSach";
    }

    @GetMapping(value = "/Xoa/{id}")
    public String delete(@PathVariable("id") int id) {
        providerService.delete(id);
        return "redirect:/admin/QuanLyNhaCungCap/DanhSach";
    }
}

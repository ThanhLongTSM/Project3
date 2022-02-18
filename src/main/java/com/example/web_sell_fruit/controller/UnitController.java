package com.example.web_sell_fruit.controller;


import com.example.web_sell_fruit.models.UnitDTO;
import com.example.web_sell_fruit.dao.impl.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/admin/QuanLyDonViTinh")
public class UnitController {

    @Autowired
    private UnitService unitService;

    @GetMapping(value = "/DanhSach")
    public String list(HttpServletRequest request) {
        List<UnitDTO> listUnitDTOs = unitService.getList();
        request.setAttribute("list", listUnitDTOs);
        return "admin/unit/list";
    }

    @GetMapping(value = "/ChiTiet/{id}")
    public String detail(HttpServletRequest request, @PathVariable("id") int id) {
        UnitDTO unitDTO = unitService.getById(id);
        request.setAttribute("unit", unitDTO);
        return "admin/unit/detail";
    }

    @GetMapping(value = "/Them")
    public String add(Model model) {
        UnitDTO unitDTO = new UnitDTO();
        model.addAttribute("unit", unitDTO);
        return "admin/unit/formAdd";
    }

    @PostMapping(value = "/Them")
    public String add(Model model, @ModelAttribute("unit") UnitDTO unitDTO) {
        unitService.addOrUpDate(unitDTO);
        return "redirect:/admin/QuanLyDonViTinh/DanhSach";
    }

    @GetMapping(value = "/Sua/{id}")
    public String update(Model model, @PathVariable("id")int id) {
        UnitDTO unitDTO = unitService.getById(id);
        model.addAttribute("unit", unitDTO);
        return "admin/unit/formUpdate";
    }

    @PostMapping(value = "/Sua")
    public String update(Model model, @ModelAttribute("unit") UnitDTO unitDTO) {
        unitService.addOrUpDate(unitDTO);
        return "redirect:/admin/QuanLyDonViTinh/DanhSach";
    }

    @GetMapping(value = "/Xoa/{id}")
    public String delete(@PathVariable("id") int id) {
        unitService.delete(id);
        return "redirect:/admin/QuanLyDonViTinh/DanhSach";
    }
}

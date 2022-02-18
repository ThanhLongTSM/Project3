package com.example.web_sell_fruit.controller;


import com.example.web_sell_fruit.models.ProductDTO;
import com.example.web_sell_fruit.other.ProcessUrlImage;
import com.example.web_sell_fruit.other.UpLoadFile;
import com.example.web_sell_fruit.dao.impl.service.CategoryService;
import com.example.web_sell_fruit.dao.impl.service.ProductService;
import com.example.web_sell_fruit.dao.impl.service.ProviderService;
import com.example.web_sell_fruit.dao.impl.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/admin/QuanLySanPham/")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProviderService providerService;

    @Autowired
    private UnitService unitService;

    @GetMapping(value = "/DanhSach")
    public String listProduct(HttpServletRequest request) {
        List<ProductDTO> listProductDTOs = productService.getList();
        request.setAttribute("list", listProductDTOs);
        return "admin/product/list";
    }

    @GetMapping(value = "/ChiTiet/{id}")
    public String detailProduct(HttpServletRequest request, @PathVariable("id") int id) {
        ProductDTO productDTO = productService.getById(id);
        request.setAttribute("product", productDTO);
        return "admin/product/detail";
    }

    @GetMapping(value = "/Them")
    public String addProduct(Model model) {
        ProductDTO productDTO = new ProductDTO();
        model.addAttribute("product", productDTO);
        model.addAttribute("listCategory", categoryService.getList());
        model.addAttribute("listProvider", providerService.getList());
        model.addAttribute("listUnit", unitService.getList());
        return "admin/product/formAdd";
    }

    @PostMapping(value = "/Them")
    public String addProduct(@ModelAttribute("product") ProductDTO productDTO, @RequestParam("file") MultipartFile file) {
        String urlImage = ProcessUrlImage.processUrlImae(file.getOriginalFilename(), productDTO.getName());
        UpLoadFile.saveFile(file, urlImage);
        productDTO.setUrl_image(urlImage);
        productService.addOrUpDate(productDTO);
        System.out.print(productDTO);
        return "redirect:/admin/QuanLySanPham/DanhSach";
    }

    @GetMapping(value = "/Sua/{id}")
    public String updateProduct(Model model, @PathVariable("id") int id) {
        ProductDTO productDTO = productService.getById(id);
        model.addAttribute("product", productDTO);
        model.addAttribute("listCategory", categoryService.getList());
        model.addAttribute("listProvider", providerService.getList());
        model.addAttribute("listUnit", unitService.getList());
        return "admin/product/formUpdate";
    }

    @PostMapping(value = "/Sua")
    public String updateProduct(@ModelAttribute("product") ProductDTO productDTO, @RequestParam("file") MultipartFile file) {
        UpLoadFile.deleteFile(productService.getById(productDTO.getId()).getUrl_image());
        String urlImage = ProcessUrlImage.processUrlImae(file.getOriginalFilename(), productDTO.getName());
        UpLoadFile.saveFile(file, urlImage);
        productDTO.setUrl_image(urlImage);
        productService.addOrUpDate(productDTO);
        return "redirect:/admin/QuanLySanPham/DanhSach";
    }

    @GetMapping(value = "/Xoa/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        ProductDTO productDTO = productService.getById(id);
        UpLoadFile.deleteFile(productDTO.getUrl_image());
        productService.delete(id);
        return "redirect:/admin/QuanLySanPham/DanhSach";
    }

}

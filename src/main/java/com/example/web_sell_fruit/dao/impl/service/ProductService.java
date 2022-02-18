package com.example.web_sell_fruit.dao.impl.service;

import com.example.web_sell_fruit.models.ProductDTO;

import java.util.List;

public interface ProductService {
    public List<ProductDTO> getList();

    public List<ProductDTO> getList(int page, int size);


    public List<ProductDTO> getListByNameLike(String name);

    public List<ProductDTO> getListOrderByPrice(int id);

    public ProductDTO getById(int id);

    public void addOrUpDate(ProductDTO productDTO);

    public void delete(int id);
}

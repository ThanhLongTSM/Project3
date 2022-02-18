package com.example.web_sell_fruit.dao.impl.service;

import com.example.web_sell_fruit.models.CategoryDTO;

import java.util.List;

public interface CategoryService {


    public List<CategoryDTO> getList();

    public CategoryDTO getById(int id);

    public CategoryDTO getByName(String name);

    public void addOrUpDate(CategoryDTO categoryDTO);

    public void delete(int id);
}

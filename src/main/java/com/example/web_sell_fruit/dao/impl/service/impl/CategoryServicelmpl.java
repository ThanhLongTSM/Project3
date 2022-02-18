package com.example.web_sell_fruit.dao.impl.service.impl;


import com.example.web_sell_fruit.converter.CategoryConverter;
import com.example.web_sell_fruit.dao.CategoryDao;
import com.example.web_sell_fruit.entity.Category;
import com.example.web_sell_fruit.models.CategoryDTO;
import com.example.web_sell_fruit.dao.impl.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServicelmpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private CategoryConverter categoryConverter;

    @Override
    public List<CategoryDTO> getList() {
        List<CategoryDTO> listCategoryDTOs = new ArrayList<>();
        List<Category> listCategories = categoryDao.getList();

        for (Category category : listCategories) {
            CategoryDTO categoryDTO = categoryConverter.toDTO(category);
            listCategoryDTOs.add(categoryDTO);
        }

        return listCategoryDTOs;
    }

    @Override
    public CategoryDTO getById(int id) {
        Category category = categoryDao.getById(id);
        CategoryDTO categoryDTO = categoryConverter.toDTO(category);
        return categoryDTO;
    }

    @Override
    public CategoryDTO getByName(String name) {
        Category category = categoryDao.getByName(name);
        CategoryDTO categoryDTO = categoryConverter.toDTO(category);
        return categoryDTO;
    }


    @Override
    public void addOrUpDate(CategoryDTO categoryDTO) {
        Category category = categoryConverter.toEntity(categoryDTO);
        categoryDao.addOrUpDate(category);

    }

    @Override
    public void delete(int id) {
        categoryDao.delete(id);

    }
}

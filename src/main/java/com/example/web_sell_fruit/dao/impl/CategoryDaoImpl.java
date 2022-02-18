package com.example.web_sell_fruit.dao.impl;

import com.example.web_sell_fruit.dao.CategoryDao;
import com.example.web_sell_fruit.entity.Category;
import com.example.web_sell_fruit.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getList() {

        return categoryRepository.findAll();
    }

    @Override
    public Category getById(int id) {

        return categoryRepository.findById(id).get();
    }

    @Override
    public Category getByName(String name) {

        return categoryRepository.findByName(name);
    }

    @Override
    public void addOrUpDate(Category category) {
        categoryRepository.save(category);

    }

    @Override
    public void delete(int id) {
        categoryRepository.delete(getById(id));
    }
}

package com.example.web_sell_fruit.dao;

import com.example.web_sell_fruit.entity.Category;

import java.util.List;

public interface CategoryDao {

    public List<Category> getList();

    public Category getById(int id);

    public Category getByName(String name);

    public void addOrUpDate(Category category);

    public void delete(int id);
}

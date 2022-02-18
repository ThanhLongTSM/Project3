package com.example.web_sell_fruit.repository;

import com.example.web_sell_fruit.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category findByName(String name);
}

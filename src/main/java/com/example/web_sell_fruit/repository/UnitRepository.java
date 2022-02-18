package com.example.web_sell_fruit.repository;


import com.example.web_sell_fruit.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepository extends JpaRepository<Unit, Integer> {
    Unit findByName(String name);
}

package com.example.web_sell_fruit.dao;

import com.example.web_sell_fruit.entity.Unit;

import java.util.List;

public interface UnitDao {
    public List<Unit> getList();

    public Unit getById(int id);

    public Unit getByName(String name);

    public void addOrUpDate(Unit unit);

    public void delete(int id);
}

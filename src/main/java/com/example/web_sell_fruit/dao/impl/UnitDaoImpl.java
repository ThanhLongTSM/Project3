package com.example.web_sell_fruit.dao.impl;


import com.example.web_sell_fruit.dao.UnitDao;
import com.example.web_sell_fruit.entity.Unit;
import com.example.web_sell_fruit.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UnitDaoImpl implements UnitDao {
    @Autowired
    private UnitRepository unitRepository;

    @Override
    public List<Unit> getList() {

        return unitRepository.findAll();
    }

    @Override
    public Unit getById(int id) {

        return unitRepository.findById(id).get();
    }

    @Override
    public Unit getByName(String name) {

        return unitRepository.findByName(name);
    }

    @Override
    public void addOrUpDate(Unit unit) {
        unitRepository.save(unit);

    }

    @Override
    public void delete(int id) {
        unitRepository.delete(getById(id));
    }
}

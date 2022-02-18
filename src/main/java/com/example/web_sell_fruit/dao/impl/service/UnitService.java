package com.example.web_sell_fruit.dao.impl.service;

import com.example.web_sell_fruit.models.CategoryDTO;
import com.example.web_sell_fruit.models.UnitDTO;

import java.util.List;

public interface UnitService {

    public List<UnitDTO> getList();

    public UnitDTO getById(int id);

    public UnitDTO getByName(String name);

    public void addOrUpDate(UnitDTO unitDTO);

    public void delete(int id);
}

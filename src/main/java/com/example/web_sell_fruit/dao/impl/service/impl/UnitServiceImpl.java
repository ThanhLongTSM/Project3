package com.example.web_sell_fruit.dao.impl.service.impl;


import com.example.web_sell_fruit.converter.UnitConverter;
import com.example.web_sell_fruit.dao.UnitDao;
import com.example.web_sell_fruit.dao.impl.service.UnitService;
import com.example.web_sell_fruit.entity.Unit;
import com.example.web_sell_fruit.models.UnitDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitDao unitDao;

    @Autowired
    private UnitConverter unitConverter;

    @Override
    public List<UnitDTO> getList() {
        List<UnitDTO> listUnitDTOs = new ArrayList<>();
        List<Unit> listUnits = unitDao.getList();

        for (Unit unit : listUnits) {
            UnitDTO unitDTO = unitConverter.toDTO(unit);
            listUnitDTOs.add(unitDTO);
        }

        return listUnitDTOs;
    }

    @Override
    public UnitDTO getById(int id) {
        Unit unit = unitDao.getById(id);
        UnitDTO unitDTO = unitConverter.toDTO(unit);
        return unitDTO;
    }

    @Override
    public UnitDTO getByName(String name) {
        Unit unit = unitDao.getByName(name);
        UnitDTO unitDTO = unitConverter.toDTO(unit);
        return unitDTO;
    }


    @Override
    public void addOrUpDate(UnitDTO unitDTO) {
        Unit unit = unitConverter.toEntity(unitDTO);
        unitDao.addOrUpDate(unit);

    }

    @Override
    public void delete(int id) {
        unitDao.delete(id);

    }
}

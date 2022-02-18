package com.example.web_sell_fruit.dao.impl.service.impl;


import com.example.web_sell_fruit.converter.RoleConverter;
import com.example.web_sell_fruit.dao.RoleDao;
import com.example.web_sell_fruit.dao.impl.service.RoleService;
import com.example.web_sell_fruit.entity.Role;
import com.example.web_sell_fruit.models.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RoleConverter roleConverter;

    @Override
    public List<RoleDTO> getList() {
        List<Role> roles = roleDao.getList();
        List<RoleDTO> roleDTOs = new ArrayList<>();

        for (Role role : roles) {
            RoleDTO roleDTO = roleConverter.toDTO(role);
            roleDTOs.add(roleDTO);
        }
        return roleDTOs;
    }

    @Override
    public RoleDTO getById(int id) {
        Role role = roleDao.getById(id);
        RoleDTO roleDTO = roleConverter.toDTO(role);
        return roleDTO;
    }

    @Override
    public void addOrUpdate(RoleDTO roleDTO) {
        Role role = roleConverter.toEntity(roleDTO);
        roleDao.addOrUpDate(role);

    }

    @Override
    public void delete(int id) {
        roleDao.delete(id);

    }

    @Override
    public RoleDTO getByName(String name) {
        RoleDTO roleDTO = roleConverter.toDTO(roleDao.getByName(name));
        return roleDTO;
    }

}

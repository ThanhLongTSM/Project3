package com.example.web_sell_fruit.dao;

import com.example.web_sell_fruit.entity.Role;

import java.util.List;

public interface RoleDao {

    public List<Role> getList();

    public Role getById(int id);

    public Role getByName(String name);

    public void addOrUpDate(Role role);

    public void delete(int id);
}

package com.example.web_sell_fruit.dao;

import com.example.web_sell_fruit.entity.TableOrder;

import java.util.List;

public interface TableOrderDao {
    public TableOrder getById(int id);

    public List<TableOrder> getListByActive(boolean active);

    public void addOrUpdate(TableOrder tableOrder);

    public TableOrder getByAccountUsernameAndActive(String username, boolean active);

    public void delete(int id);
}

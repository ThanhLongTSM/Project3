package com.example.web_sell_fruit.dao;

import com.example.web_sell_fruit.entity.Provider;

import java.util.List;

public interface ProviderDao {

    public List<Provider> getList();

    public Provider getById(int id);

    public Provider getByName(String name);

    public void addOrUpDate(Provider provider);

    public void delete(int id);
}

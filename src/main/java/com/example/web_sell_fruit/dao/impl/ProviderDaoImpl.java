package com.example.web_sell_fruit.dao.impl;

import com.example.web_sell_fruit.dao.ProviderDao;
import com.example.web_sell_fruit.entity.Category;
import com.example.web_sell_fruit.entity.Provider;
import com.example.web_sell_fruit.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProviderDaoImpl implements ProviderDao {

    @Autowired
    private ProviderRepository providerRepository;

    @Override
    public List<Provider> getList() {

        return providerRepository.findAll();
    }

    @Override
    public Provider getById(int id) {

        return providerRepository.findById(id).get();
    }

    @Override
    public Provider getByName(String name) {

        return providerRepository.findByName(name);
    }

    @Override
    public void addOrUpDate(Provider provider) {
        providerRepository.save(provider);

    }

    @Override
    public void delete(int id) {
        providerRepository.delete(getById(id));
    }
}

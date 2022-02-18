package com.example.web_sell_fruit.dao.impl.service;


import com.example.web_sell_fruit.models.ProviderDTO;

import java.util.List;

public interface ProviderService {

    public List<ProviderDTO> getList();

    public ProviderDTO getById(int id);

    public ProviderDTO getByName(String name);

    public void addOrUpDate(ProviderDTO providerDTO);

    public void delete(int id);
}

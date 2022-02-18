package com.example.web_sell_fruit.dao.impl.service.impl;


import com.example.web_sell_fruit.converter.ProviderConverter;
import com.example.web_sell_fruit.dao.ProviderDao;
import com.example.web_sell_fruit.entity.Provider;
import com.example.web_sell_fruit.models.ProviderDTO;
import com.example.web_sell_fruit.dao.impl.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {
    @Autowired
    private ProviderDao providerDao;

    @Autowired
    private ProviderConverter providerConverter;

    @Override
    public List<ProviderDTO> getList() {
        List<ProviderDTO> listProviderDTOs = new ArrayList<>();
        List<Provider> listProvideries = providerDao.getList();

        for (Provider provider : listProvideries) {
            ProviderDTO providerDTO = providerConverter.toDTO(provider);
            listProviderDTOs.add(providerDTO);
        }

        return listProviderDTOs;
    }

    @Override
    public ProviderDTO getById(int id) {
        Provider provider = providerDao.getById(id);
        ProviderDTO providerDTO = providerConverter.toDTO(provider);
        return providerDTO;
    }

    @Override
    public ProviderDTO getByName(String name) {
        Provider provider = providerDao.getByName(name);
        ProviderDTO providerDTO = providerConverter.toDTO(provider);
        return providerDTO;
    }


    @Override
    public void addOrUpDate(ProviderDTO providerDTO) {
        Provider provider = providerConverter.toEntity(providerDTO);
        providerDao.addOrUpDate(provider);

    }

    @Override
    public void delete(int id) {
        providerDao.delete(id);

    }

}

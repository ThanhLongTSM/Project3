package com.example.web_sell_fruit.converter;


import com.example.web_sell_fruit.entity.Category;
import com.example.web_sell_fruit.entity.Product;
import com.example.web_sell_fruit.entity.Provider;
import com.example.web_sell_fruit.models.CategoryDTO;
import com.example.web_sell_fruit.models.ProductDTO;
import com.example.web_sell_fruit.models.ProviderDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProviderConverter {
    private ModelMapper modelMapper;

    @Autowired
    private ProductConverter productConverter;

    public ProviderConverter() {
        modelMapper = new ModelMapper();
    }

    public ProviderDTO toDTO(Provider provider) {
        ProviderDTO providerDTO = modelMapper.map(provider, ProviderDTO.class);

        List<Product> products = provider.getProducts();
        List<ProductDTO> productDTOs = new ArrayList<>();

        for (Product product : products) {
            ProductDTO productDTO = productConverter.toDTO(product);
            productDTOs.add(productDTO);
        }

        providerDTO.setProductDTOs(productDTOs);

        return providerDTO;
    }

    public Provider toEntity(ProviderDTO providerDTO) {
        Provider provider = modelMapper.map(providerDTO, Provider.class);

        return provider;
    }
}

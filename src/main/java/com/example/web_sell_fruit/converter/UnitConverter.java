package com.example.web_sell_fruit.converter;


import com.example.web_sell_fruit.entity.Product;
import com.example.web_sell_fruit.entity.Unit;
import com.example.web_sell_fruit.models.ProductDTO;
import com.example.web_sell_fruit.models.UnitDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UnitConverter {
    private ModelMapper modelMapper;

    @Autowired
    private ProductConverter productConverter;

    public UnitConverter() {
        modelMapper = new ModelMapper();
    }

    public UnitDTO toDTO(Unit unit) {
        UnitDTO unitDTO = modelMapper.map(unit, UnitDTO.class);

        List<Product> products = unit.getProduct();
        List<ProductDTO> productDTOs = new ArrayList<>();

        for (Product product : products) {
            ProductDTO productDTO = productConverter.toDTO(product);
            productDTOs.add(productDTO);
        }

        unitDTO.setProductDTOs(productDTOs);

        return unitDTO;
    }

    public Unit toEntity(UnitDTO unitDTO) {
        Unit unit = modelMapper.map(unitDTO, Unit.class);

        return unit;
    }
}

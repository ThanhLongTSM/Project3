package com.example.web_sell_fruit.converter;


import com.example.web_sell_fruit.entity.Category;
import com.example.web_sell_fruit.entity.Product;
import com.example.web_sell_fruit.entity.Provider;
import com.example.web_sell_fruit.entity.Unit;
import com.example.web_sell_fruit.models.ProductDTO;
import com.example.web_sell_fruit.repository.CategoryRepository;
import com.example.web_sell_fruit.repository.ProviderRepository;
import com.example.web_sell_fruit.repository.UnitRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    private ModelMapper modelMapper;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProviderRepository providerRepository;
    @Autowired
    private UnitRepository unitRepository;

    public ProductConverter() {
        modelMapper = new ModelMapper();
    }

    public ProductDTO toDTO(Product product) {
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);

        productDTO.setCategory(product.getCategory().getName());
        productDTO.setProvider(product.getProvider().getName());
        productDTO.setUnit(product.getUnit().getName());

        return productDTO;
    }

    public Product toEntity(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);

        Category category = categoryRepository.findByName(productDTO.getCategory());
        Provider provider = providerRepository.findByName(productDTO.getProvider());
        Unit unit = unitRepository.findByName(productDTO.getUnit());

        product.setCategory(category);
        product.setProvider(provider);
        product.setUnit(unit);

        return product;

    }
}

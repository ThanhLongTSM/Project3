package com.example.web_sell_fruit.converter;


import com.example.web_sell_fruit.dao.AccountDao;
import com.example.web_sell_fruit.entity.Account;
import com.example.web_sell_fruit.entity.ProductOrder;
import com.example.web_sell_fruit.entity.TableOrder;
import com.example.web_sell_fruit.models.AccountDTO;
import com.example.web_sell_fruit.models.ProductOrderDTO;
import com.example.web_sell_fruit.models.TableOrderDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TableOrderConverter {

    private ModelMapper modelMapper;
    @Autowired
    private ProductOrderConverter productOrderConverter;

    @Autowired
    private AccountConverter accountConverter;

    @Autowired
    private AccountDao accountDao;

    public TableOrderConverter() {
        modelMapper = new ModelMapper();
    }

    public TableOrder toEntity(TableOrderDTO tableOrderDTO) {
        TableOrder tableOrder = modelMapper.map(tableOrderDTO, TableOrder.class);

        Account account = accountDao.getById(tableOrderDTO.getAccountDTO().getId());
        tableOrder.setAccount(account);

        List<ProductOrderDTO> listProductOrderDTOs = tableOrderDTO.getProductOrderDTOs();
        List<ProductOrder> listProductOrders = new ArrayList<>();
        for (ProductOrderDTO productOrderDTO : listProductOrderDTOs) {
            ProductOrder productOrder = productOrderConverter.toEntity(productOrderDTO, tableOrder);
            listProductOrders.add(productOrder);
        }

        tableOrder.setProductOrders(listProductOrders);

        return tableOrder;
    }

    public TableOrderDTO toDTO(TableOrder tableOrder) {
        TableOrderDTO tableOrderDTO = modelMapper.map(tableOrder, TableOrderDTO.class);

        Account account = tableOrder.getAccount();
        AccountDTO accountDTO = accountConverter.toDTO(account);
        tableOrderDTO.setAccountDTO(accountDTO);

        List<ProductOrderDTO> productOrderDTOs = new ArrayList<ProductOrderDTO>();
        List<ProductOrder> productOrders = tableOrder.getProductOrders();
        for (ProductOrder productOrder : productOrders) {
            ProductOrderDTO productOrderDTO = productOrderConverter.toDTO(productOrder);
            productOrderDTOs.add(productOrderDTO);
        }
        tableOrderDTO.setProductOrderDTOs(productOrderDTOs);

        return tableOrderDTO;
    }
}

package com.example.web_sell_fruit.converter;


import com.example.web_sell_fruit.dao.RoleDao;
import com.example.web_sell_fruit.entity.Account;
import com.example.web_sell_fruit.entity.Role;
import com.example.web_sell_fruit.models.AccountDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountConverter {

    private ModelMapper modelMapper;

    public AccountConverter() {
        modelMapper = new ModelMapper();
    }

    @Autowired
    private RoleDao roleDao;

    public AccountDTO toDTO(Account account) {
        if (account == null)
            return null;

        AccountDTO accountDTO = modelMapper.map(account, AccountDTO.class);

        List<String> roles = new ArrayList<>();


        for (Role role : account.getRoles()) {
            String roleString = role.getName();
            roles.add(roleString);
        }

        accountDTO.setRoles(roles);

        return accountDTO;
    }

    public Account toEntity(AccountDTO accountDTO) {
        if (accountDTO == null)
            return null;

        Account account = modelMapper.map(accountDTO, Account.class);

        List<Role> roles = new ArrayList<>();

        for (String roleString : accountDTO.getRoles()) {
            Role role = roleDao.getByName(roleString);
            roles.add(role);
        }

        account.setRoles(roles);

        return account;
    }
}

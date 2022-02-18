package com.example.web_sell_fruit.dao;

import com.example.web_sell_fruit.entity.Account;

import java.util.List;

public interface AccountDao {

    public List<Account> getList();

    public Account getById(int id);

    public Account getByUsername(String username);

    public Account getByEmail(String email);

    public Account getByUsernameOrEmail(String username, String email);

    public Account getByUsernameAndActive(String username, boolean active);

    public void addOrUpdate(Account account);

    public void delete(int id);
}

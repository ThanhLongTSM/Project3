package com.example.web_sell_fruit.repository;


import com.example.web_sell_fruit.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AccountRepository extends JpaRepository<Account, Integer> {


    Account findByUsername(String username);

    Account findByEmail(String email);

    Account findByUsernameOrEmail(String username, String email);

    Account findByUsernameAndActive(String username, boolean active);
}

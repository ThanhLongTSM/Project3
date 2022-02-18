package com.example.web_sell_fruit.repository;

import com.example.web_sell_fruit.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {

    Role findByName(String name);
}

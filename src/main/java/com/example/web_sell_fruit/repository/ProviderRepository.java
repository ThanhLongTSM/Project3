package com.example.web_sell_fruit.repository;

import com.example.web_sell_fruit.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Integer> {

    Provider findByName(String name);
}

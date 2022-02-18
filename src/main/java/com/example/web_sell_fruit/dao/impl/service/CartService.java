package com.example.web_sell_fruit.dao.impl.service;

public interface CartService {
    public void addCart(int idProduct, int number);

    public void deletedCart(int idProductOrder);

    public void reduceCart(int idProductOrder);
}

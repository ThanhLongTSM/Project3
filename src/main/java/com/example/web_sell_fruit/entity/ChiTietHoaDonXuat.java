package com.example.web_sell_fruit.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "chitiethoadonxuat")
public class ChiTietHoaDonXuat extends BaseEntity{

    @Column
    private int so_luong;
    @Column
    private  int gia_ban;

    @ManyToOne
    @MapsId("id_product")
    @JoinColumn(name = "id_product")
    private Product product;


    @ManyToOne
    @MapsId("id_hoadonxuat")
    @JoinColumn(name = "id_hoadonxuat")
    private HoaDonXuat hoadonxuat;

}

package com.example.web_sell_fruit.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "chitiethoadonnhap")
public class ChiTietHoaDonNhap extends BaseEntity{


    @Column
    private int so_luong;
    @Column
    private int gia_nhap;
    @Column
    private  int gia_ban;

    @ManyToOne
    @MapsId("id_product")
    @JoinColumn(name = "id_product")
    private Product product;


    @ManyToOne
    @MapsId("id_hoadonnhap")
    @JoinColumn(name = "id_hoadonnhap")
    private HoaDonNhap hoadonnhap;


}

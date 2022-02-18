package com.example.web_sell_fruit.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "hoadonxuat")
public class HoaDonXuat extends  BaseEntity{


    @Column(name="tong_tien")
    private int tong_tien;

    @ManyToOne
    @JoinColumn(name = "ic_hinhthucthanhtoan")
    private HinhThucThanhToan hinhthucthanhtoan;

}

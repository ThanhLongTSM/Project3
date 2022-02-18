package com.example.web_sell_fruit.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@Table(name = "hoadonnhap")
public class HoaDonNhap extends BaseEntity{

    @Column(name = "tong_tien")
    private int tong_tien;

    @OneToMany(mappedBy = "hoadonnhap")
    private List<ChiTietHoaDonNhap> hoadonnhap;

}

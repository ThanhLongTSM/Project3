package com.example.web_sell_fruit.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "hinhthucthanhtoan")
public class HinhThucThanhToan extends BaseEntity{

    @Column(name = "hinh_thuc")
    private String hinh_thuc;


}

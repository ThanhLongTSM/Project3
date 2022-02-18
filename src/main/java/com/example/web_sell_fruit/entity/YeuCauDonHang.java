package com.example.web_sell_fruit.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "yeucaudonhang")
public class YeuCauDonHang extends BaseEntity{


    @Column(name = "activity")
    private Boolean activity;


    @ManyToOne()
    @JoinColumn(name = "id_product")
    private Product product;


}

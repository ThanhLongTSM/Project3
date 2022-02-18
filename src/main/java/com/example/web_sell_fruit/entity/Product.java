package com.example.web_sell_fruit.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product extends  BaseEntity{
    private static final long serialVersionUID = 1L;

    @Column(name = "name")
    private String name;

    @Column(name = "so_luong")
    private int so_luong;

    @Column(name = "price")
    private int price;

    @Column(name = "active")
    private boolean active;

    @Column(name = "url_image")
    private String url_image;

    @ManyToOne
    @JoinColumn(name = "id_dvt")
    private Unit unit;

    @ManyToOne
    @JoinColumn(name = "id_provider")
    private Provider provider;

    @OneToMany(mappedBy = "product")
    private List<ChiTietHoaDonNhap> hoadonnhap;

    @OneToMany(mappedBy = "product")
    private List<ChiTietHoaDonXuat> hoadonxuat;

    @OneToMany(mappedBy="product")
    private List<YeuCauDonHang> yeucaudonhang;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public List<ChiTietHoaDonNhap> getHoadonnhap() {
        return hoadonnhap;
    }

    public void setHoadonnhap(List<ChiTietHoaDonNhap> hoadonnhap) {
        this.hoadonnhap = hoadonnhap;
    }

    public List<ChiTietHoaDonXuat> getHoadonxuat() {
        return hoadonxuat;
    }

    public void setHoadonxuat(List<ChiTietHoaDonXuat> hoadonxuat) {
        this.hoadonxuat = hoadonxuat;
    }

    public List<YeuCauDonHang> getYeucaudonhang() {
        return yeucaudonhang;
    }

    public void setYeucaudonhang(List<YeuCauDonHang> yeucaudonhang) {
        this.yeucaudonhang = yeucaudonhang;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

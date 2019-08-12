package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String TenTp;
    private int DienTich;
    private int DanSo;
    private int GDP;
    private String MoTa;

    @ManyToOne
    @JoinColumn(name = "Nation_id")
    private Nation nation;

    public City() {
    }

    public City(String tenTp, int dienTich, int danSo, int GDP, String moTa, Nation nation) {
        TenTp = tenTp;
        DienTich = dienTich;
        DanSo = danSo;
        this.GDP = GDP;
        MoTa = moTa;
        this.nation = nation;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTenTp() {
        return TenTp;
    }

    public void setTenTp(String tenTp) {
        TenTp = tenTp;
    }

    public int getDienTich() {
        return DienTich;
    }

    public void setDienTich(int dienTich) {
        DienTich = dienTich;
    }

    public int getDanSo() {
        return DanSo;
    }

    public void setDanSo(int danSo) {
        DanSo = danSo;
    }

    public int getGDP() {
        return GDP;
    }

    public void setGDP(int GDP) {
        this.GDP = GDP;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }
}

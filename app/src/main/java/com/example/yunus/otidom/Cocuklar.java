package com.example.yunus.otidom;

/**
 * Created by yunus on 17.05.2018.
 */

public class Cocuklar {

    private String ad;
    private String soyad;
    private String dogumTarihi;
    private String cinsiyet;
    private String rahatsızlık;


    public Cocuklar(String ad, String soyad, String dogumTarihi, String cinsiyet, String rahatsızlık) {
        this.ad = ad;
        this.soyad = soyad;
        this.dogumTarihi = dogumTarihi;
        this.cinsiyet = cinsiyet;
        this.rahatsızlık = rahatsızlık;
    }


    public Cocuklar() {


    }


    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getRahatsızlık() {
        return rahatsızlık;
    }

    public void setRahatsızlık(String rahatsızlık) {
        this.rahatsızlık = rahatsızlık;
    }
}

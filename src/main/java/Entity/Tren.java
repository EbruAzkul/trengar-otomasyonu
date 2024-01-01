/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.time.LocalDateTime;

/**
 *
 * @author Lenovo
 */
public class Tren {
    private Long trenID;
    private String trenNumarasi;
    private Istasyon kalkisIstasyonu;
    private Istasyon varisIstasyonu;
    private LocalDateTime kalkisZamani;
    private LocalDateTime varisZamani;

    public Tren() {
    }

    public Tren(Long trenID, String trenNumarasi, Istasyon kalkisIstasyonu, Istasyon varisIstasyonu, LocalDateTime kalkisZamani, LocalDateTime varisZamani) {
        this.trenID = trenID;
        this.trenNumarasi = trenNumarasi;
        this.kalkisIstasyonu = kalkisIstasyonu;
        this.varisIstasyonu = varisIstasyonu;
        this.kalkisZamani = kalkisZamani;
        this.varisZamani = varisZamani;
    }

    public Long getTrenID() {
        return trenID;
    }

    public void setTrenID(Long trenID) {
        this.trenID = trenID;
    }

    public String getTrenNumarasi() {
        return trenNumarasi;
    }

    public void setTrenNumarasi(String trenNumarasi) {
        this.trenNumarasi = trenNumarasi;
    }

    public Istasyon getKalkisIstasyonu() {
        return kalkisIstasyonu;
    }

    public void setKalkisIstasyonu(Istasyon kalkisIstasyonu) {
        this.kalkisIstasyonu = kalkisIstasyonu;
    }

    public Istasyon getVarisIstasyonu() {
        return varisIstasyonu;
    }

    public void setVarisIstasyonu(Istasyon varisIstasyonu) {
        this.varisIstasyonu = varisIstasyonu;
    }

    public LocalDateTime getKalkisZamani() {
        return kalkisZamani;
    }

    public void setKalkisZamani(LocalDateTime kalkisZamani) {
        this.kalkisZamani = kalkisZamani;
    }

    public LocalDateTime getVarisZamani() {
        return varisZamani;
    }

    public void setVarisZamani(LocalDateTime varisZamani) {
        this.varisZamani = varisZamani;
    }
   
    
}

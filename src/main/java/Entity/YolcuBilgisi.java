/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Lenovo
 */
public class YolcuBilgisi {
    private Long yolcuBilgisiID;
    private String adiSoyadi;
    private String tcNo;
    private Bilet bilet;

    public YolcuBilgisi() {
    }

    public YolcuBilgisi(Long yolcuBilgisiID, String adiSoyadi, String tcNo, Bilet bilet) {
        this.yolcuBilgisiID = yolcuBilgisiID;
        this.adiSoyadi = adiSoyadi;
        this.tcNo = tcNo;
        this.bilet = bilet;
    }

    public Long getYolcuBilgisiID() {
        return yolcuBilgisiID;
    }

    public void setYolcuBilgisiID(Long yolcuBilgisiID) {
        this.yolcuBilgisiID = yolcuBilgisiID;
    }

    public String getAdiSoyadi() {
        return adiSoyadi;
    }

    public void setAdiSoyadi(String adiSoyadi) {
        this.adiSoyadi = adiSoyadi;
    }

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    public Bilet getBilet() {
        return bilet;
    }

    public void setBilet(Bilet bilet) {
        this.bilet = bilet;
    }
  
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.List;

/**
 *
 * @author Lenovo
 */
public class Yolcu_Listesi {
     private Long yolcuListesiID;
    private List<YolcuBilgisi> yolcuBilgisiListesi;
    private Tren tren;
    private Gar_Sistemi garSistemi;

    public Yolcu_Listesi() {
    }

    public Yolcu_Listesi(Long yolcuListesiID, List<YolcuBilgisi> yolcuBilgisiListesi, Tren tren, Gar_Sistemi garSistemi) {
        this.yolcuListesiID = yolcuListesiID;
        this.yolcuBilgisiListesi = yolcuBilgisiListesi;
        this.tren = tren;
        this.garSistemi = garSistemi;
    }

    public Long getYolcuListesiID() {
        return yolcuListesiID;
    }

    public void setYolcuListesiID(Long yolcuListesiID) {
        this.yolcuListesiID = yolcuListesiID;
    }

    public List<YolcuBilgisi> getYolcuBilgisiListesi() {
        return yolcuBilgisiListesi;
    }

    public void setYolcuBilgisiListesi(List<YolcuBilgisi> yolcuBilgisiListesi) {
        this.yolcuBilgisiListesi = yolcuBilgisiListesi;
    }

    public Tren getTren() {
        return tren;
    }

    public void setTren(Tren tren) {
        this.tren = tren;
    }

    public Gar_Sistemi getGarSistemi() {
        return garSistemi;
    }

    public void setGarSistemi(Gar_Sistemi garSistemi) {
        this.garSistemi = garSistemi;
    }
   
    
    
}

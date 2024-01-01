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
public class Gar_Sistemi {
    private Long garSistemiID;
    private List<Tren> trenListesi;
    private List<Bilet> biletListesi;

    public Gar_Sistemi() {
    }

    public Gar_Sistemi(Long garSistemiID, List<Tren> trenListesi, List<Bilet> biletListesi) {
        this.garSistemiID = garSistemiID;
        this.trenListesi = trenListesi;
        this.biletListesi = biletListesi;
    }

    public Long getGarSistemiID() {
        return garSistemiID;
    }

    public void setGarSistemiID(Long garSistemiID) {
        this.garSistemiID = garSistemiID;
    }

    public List<Tren> getTrenListesi() {
        return trenListesi;
    }

    public void setTrenListesi(List<Tren> trenListesi) {
        this.trenListesi = trenListesi;
    }

    public List<Bilet> getBiletListesi() {
        return biletListesi;
    }

    public void setBiletListesi(List<Bilet> biletListesi) {
        this.biletListesi = biletListesi;
    }

    
    
}

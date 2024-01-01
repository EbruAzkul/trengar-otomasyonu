/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Lenovo
 */
public class Bilet {
    private Long biletID;
    private String yolcuAdi;
    private int koltukNumarasi;
    private Tren tren;

    public Bilet() {
    }

    public Bilet(Long biletID, String yolcuAdi, int koltukNumarasi, Tren tren) {
        this.biletID = biletID;
        this.yolcuAdi = yolcuAdi;
        this.koltukNumarasi = koltukNumarasi;
        this.tren = tren;
    }

    public Long getBiletID() {
        return biletID;
    }

    public void setBiletID(Long biletID) {
        this.biletID = biletID;
    }

    public String getYolcuAdi() {
        return yolcuAdi;
    }

    public void setYolcuAdi(String yolcuAdi) {
        this.yolcuAdi = yolcuAdi;
    }

    public int getKoltukNumarasi() {
        return koltukNumarasi;
    }

    public void setKoltukNumarasi(int koltukNumarasi) {
        this.koltukNumarasi = koltukNumarasi;
    }

    public Tren getTren() {
        return tren;
    }

    public void setTren(Tren tren) {
        this.tren = tren;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Lenovo
 */
public class Istasyon {
    private Long istasyonID;
    private String istasyonAdi;
    private String konum;

    public Istasyon() {
    }

    public Istasyon(Long istasyonID, String istasyonAdi, String konum) {
        this.istasyonID = istasyonID;
        this.istasyonAdi = istasyonAdi;
        this.konum = konum;
    }

    public Long getIstasyonID() {
        return istasyonID;
    }

    public void setIstasyonID(Long istasyonID) {
        this.istasyonID = istasyonID;
    }

    public String getIstasyonAdi() {
        return istasyonAdi;
    }

    public void setIstasyonAdi(String istasyonAdi) {
        this.istasyonAdi = istasyonAdi;
    }

    public String getKonum() {
        return konum;
    }

    public void setKonum(String konum) {
        this.konum = konum;
    }
   
    
}

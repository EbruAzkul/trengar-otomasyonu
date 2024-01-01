/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Lenovo
 */
public class Kapi_Bariyer_Kontrolu {
    private Long kapiBariyerKontroluID;
    private String durum;

    public Kapi_Bariyer_Kontrolu() {
    }

    public Kapi_Bariyer_Kontrolu(Long kapiBariyerKontroluID, String durum) {
        this.kapiBariyerKontroluID = kapiBariyerKontroluID;
        this.durum = durum;
    }

    public Long getKapiBariyerKontroluID() {
        return kapiBariyerKontroluID;
    }

    public void setKapiBariyerKontroluID(Long kapiBariyerKontroluID) {
        this.kapiBariyerKontroluID = kapiBariyerKontroluID;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }
   
    
}

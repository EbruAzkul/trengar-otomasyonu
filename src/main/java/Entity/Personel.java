/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Lenovo
 */
public class Personel {
    private Long personelID;
    private String adiSoyadi;
    private String gorevi;

    public Personel() {
    }

    public Personel(Long personelID, String adiSoyadi, String gorevi) {
        this.personelID = personelID;
        this.adiSoyadi = adiSoyadi;
        this.gorevi = gorevi;
    }

    public Long getPersonelID() {
        return personelID;
    }

    public void setPersonelID(Long personelID) {
        this.personelID = personelID;
    }

    public String getAdiSoyadi() {
        return adiSoyadi;
    }

    public void setAdiSoyadi(String adiSoyadi) {
        this.adiSoyadi = adiSoyadi;
    }

    public String getGorevi() {
        return gorevi;
    }

    public void setGorevi(String gorevi) {
        this.gorevi = gorevi;
    }
  
    

}

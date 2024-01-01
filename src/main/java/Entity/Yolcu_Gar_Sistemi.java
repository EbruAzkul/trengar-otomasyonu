/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Lenovo
 */
public class Yolcu_Gar_Sistemi {
     private Long yolcuGarSistemiID;
    private String durum;

    public Yolcu_Gar_Sistemi() {
    }

    public Yolcu_Gar_Sistemi(Long yolcuGarSistemiID, String durum) {
        this.yolcuGarSistemiID = yolcuGarSistemiID;
        this.durum = durum;
    }

    public Long getYolcuGarSistemiID() {
        return yolcuGarSistemiID;
    }

    public void setYolcuGarSistemiID(Long yolcuGarSistemiID) {
        this.yolcuGarSistemiID = yolcuGarSistemiID;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }
 
    
}

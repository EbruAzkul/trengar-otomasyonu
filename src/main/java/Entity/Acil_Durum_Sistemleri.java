/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Lenovo
 */
public class Acil_Durum_Sistemleri {
    private Long acilDurumSistemiID;
    private String acilDurumMesaji;

    public Acil_Durum_Sistemleri() {
    }

    public Acil_Durum_Sistemleri(Long acilDurumSistemiID, String acilDurumMesaji) {
        this.acilDurumSistemiID = acilDurumSistemiID;
        this.acilDurumMesaji = acilDurumMesaji;
    }

    public Long getAcilDurumSistemiID() {
        return acilDurumSistemiID;
    }

    public void setAcilDurumSistemiID(Long acilDurumSistemiID) {
        this.acilDurumSistemiID = acilDurumSistemiID;
    }

    public String getAcilDurumMesaji() {
        return acilDurumMesaji;
    }

    public void setAcilDurumMesaji(String acilDurumMesaji) {
        this.acilDurumMesaji = acilDurumMesaji;
    }
   
    
}

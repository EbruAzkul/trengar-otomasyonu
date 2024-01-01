/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Lenovo
 */
public class Guvenlik_Sistemi {
    private Long guvenlikSistemiID;
    private Kapi_Bariyer_Kontrolu kapıBarYerKontrolu;

    public Guvenlik_Sistemi() {
    }

    public Guvenlik_Sistemi(Long guvenlikSistemiID, Kapi_Bariyer_Kontrolu kapıBarYerKontrolu) {
        this.guvenlikSistemiID = guvenlikSistemiID;
        this.kapıBarYerKontrolu = kapıBarYerKontrolu;
    }

    public Long getGuvenlikSistemiID() {
        return guvenlikSistemiID;
    }

    public void setGuvenlikSistemiID(Long guvenlikSistemiID) {
        this.guvenlikSistemiID = guvenlikSistemiID;
    }

    public Kapi_Bariyer_Kontrolu getKapıBarYerKontrolu() {
        return kapıBarYerKontrolu;
    }

    public void setKapıBarYerKontrolu(Kapi_Bariyer_Kontrolu kapıBarYerKontrolu) {
        this.kapıBarYerKontrolu = kapıBarYerKontrolu;
    }
    
    
}

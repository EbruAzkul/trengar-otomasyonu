/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import Entity.Guvenlik_Sistemi;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface GuvenlikSistemiRepository {
    Guvenlik_Sistemi guvenlikSistemiBul(Long guvenlikSistemiID);
    void guvenlikSistemiEkle(Guvenlik_Sistemi guvenlikSistemi);
    void guvenlikSistemiGuncelle(Guvenlik_Sistemi guvenlikSistemi);
    void guvenlikSistemiSil(Long guvenlikSistemiID);
    List<Guvenlik_Sistemi> tumGuvenlikSistemleriListele();
}

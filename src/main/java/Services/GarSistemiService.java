/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import Entity.Gar_Sistemi;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface GarSistemiService {
    Gar_Sistemi garSistemiBul(Long garSistemiID);
    void garSistemiEkle(Gar_Sistemi garSistemi);
    void garSistemiGuncelle(Gar_Sistemi garSistemi);
    void garSistemiSil(Long garSistemiID);
    List<Gar_Sistemi> tumGarSistemleriListele();
}

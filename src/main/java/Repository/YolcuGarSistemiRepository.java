/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import Entity.Yolcu_Gar_Sistemi;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface YolcuGarSistemiRepository {
    Yolcu_Gar_Sistemi yolcuGarSistemiBul(Long yolcuGarSistemiID);
    void yolcuGarSistemiEkle(Yolcu_Gar_Sistemi yolcuGarSistemi);
    void yolcuGarSistemiGuncelle(Yolcu_Gar_Sistemi yolcuGarSistemi);
    void yolcuGarSistemiSil(Long yolcuGarSistemiID);
    List<Yolcu_Gar_Sistemi> tumYolcuGarSistemleriListele();
}

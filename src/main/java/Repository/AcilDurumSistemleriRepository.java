/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import Entity.Acil_Durum_Sistemleri;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface AcilDurumSistemleriRepository {
    Acil_Durum_Sistemleri acilDurumSistemiBul(Long acilDurumSistemiID);
    void acilDurumSistemiEkle(Acil_Durum_Sistemleri acilDurumSistemleri);
    void acilDurumSistemiGuncelle(Acil_Durum_Sistemleri acilDurumSistemleri);
    void acilDurumSistemiSil(Long acilDurumSistemiID);
    List<Acil_Durum_Sistemleri> tumAcilDurumSistemleriListele(); 
}

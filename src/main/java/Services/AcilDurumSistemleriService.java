/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import Entity.Acil_Durum_Sistemleri;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface AcilDurumSistemleriService {
    Acil_Durum_Sistemleri acilDurumSistemiBul(Long acilDurumSistemiID);
    void acilDurumSistemiEkle(Acil_Durum_Sistemleri acilDurumSistemleri);
    void acilDurumSistemiGuncelle(Acil_Durum_Sistemleri acilDurumSistemleri);
    void acilDurumSistemiSil(Long acilDurumSistemiID);
    List<Acil_Durum_Sistemleri> tumAcilDurumSistemleriListele();
}

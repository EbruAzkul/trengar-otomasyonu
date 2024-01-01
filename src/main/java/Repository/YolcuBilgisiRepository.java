/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import Entity.YolcuBilgisi;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface YolcuBilgisiRepository {
    YolcuBilgisi yolcuBilgisiBul(Long yolcuBilgisiID);
    void yolcuBilgisiEkle(YolcuBilgisi yolcuBilgisi);
    void yolcuBilgisiGuncelle(YolcuBilgisi yolcuBilgisi);
    void yolcuBilgisiSil(Long yolcuBilgisiID);
    List<YolcuBilgisi> tumYolcuBilgileriListele();
}

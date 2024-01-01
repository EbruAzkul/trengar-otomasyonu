/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import Entity.Yolcu_Listesi;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface YolcuListesiRepository {
    Yolcu_Listesi yolcuListesiBul(Long yolcuListesiID);
    void yolcuListesiEkle(Yolcu_Listesi yolcuListesi);
    void yolcuListesiGuncelle(Yolcu_Listesi yolcuListesi);
    void yolcuListesiSil(Long yolcuListesiID);
    List<Yolcu_Listesi> tumYolcuListeleriListele();
}

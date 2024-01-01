/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import Entity.Bilet;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface BiletService {
   Bilet biletBul(Long biletID);
    void biletEkle(Bilet bilet);
    void biletGuncelle(Bilet bilet);
    void biletSil(Long biletID);
    List<Bilet> tumBiletleriListele(); 
}

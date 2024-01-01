/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import Entity.Personel;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface PersonelService {
    Personel personelBul(Long personelID);
    void personelEkle(Personel personel);
    void personelGuncelle(Personel personel);
    void personelSil(Long personelID);
    List<Personel> tumPersonelleriListele();
}

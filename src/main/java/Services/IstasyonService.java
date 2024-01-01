/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import Entity.Istasyon;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface IstasyonService {
    Istasyon istasyonBul(Long istasyonID);
    void istasyonEkle(Istasyon istasyon);
    void istasyonGuncelle(Istasyon istasyon);
    void istasyonSil(Long istasyonID);
    List<Istasyon> tumIstasyonlariListele();
}

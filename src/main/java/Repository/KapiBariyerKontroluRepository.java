/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import Entity.Kapi_Bariyer_Kontrolu;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface KapiBariyerKontroluRepository {
    Kapi_Bariyer_Kontrolu kapiBariyerKontroluBul(Long kapiBariyerKontroluID);
    void kapiBariyerKontroluEkle(Kapi_Bariyer_Kontrolu kapiBariyerKontrolu);
    void kapiBariyerKontroluGuncelle(Kapi_Bariyer_Kontrolu kapiBariyerKontrolu);
    void kapiBariyerKontroluSil(Long kapiBariyerKontroluID);
    List<Kapi_Bariyer_Kontrolu> tumKapiBariyerKontroluListele();
}


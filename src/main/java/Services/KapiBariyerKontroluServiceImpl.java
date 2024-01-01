/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entity.Kapi_Bariyer_Kontrolu;
import Repository.KapiBariyerKontroluRepository;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class KapiBariyerKontroluServiceImpl implements KapiBariyerKontroluService {
    private KapiBariyerKontroluRepository kapiBariyerKontroluRepository;

    public KapiBariyerKontroluServiceImpl(KapiBariyerKontroluRepository kapiBariyerKontroluRepository) {
        this.kapiBariyerKontroluRepository = kapiBariyerKontroluRepository;
    }

    @Override
    public Kapi_Bariyer_Kontrolu kapiBariyerKontroluBul(Long kapiBariyerKontroluID) {
        return kapiBariyerKontroluRepository.kapiBariyerKontroluBul(kapiBariyerKontroluID);
    }

    @Override
    public void kapiBariyerKontroluEkle(Kapi_Bariyer_Kontrolu kapiBariyerKontrolu) {
        kapiBariyerKontroluRepository.kapiBariyerKontroluEkle(kapiBariyerKontrolu);
    }

    @Override
    public void kapiBariyerKontroluGuncelle(Kapi_Bariyer_Kontrolu kapiBariyerKontrolu) {
        kapiBariyerKontroluRepository.kapiBariyerKontroluGuncelle(kapiBariyerKontrolu);
    }

    @Override
    public void kapiBariyerKontroluSil(Long kapiBariyerKontroluID) {
        kapiBariyerKontroluRepository.kapiBariyerKontroluSil(kapiBariyerKontroluID);
    }

    @Override
    public List<Kapi_Bariyer_Kontrolu> tumKapiBariyerKontroluListele() {
        return kapiBariyerKontroluRepository.tumKapiBariyerKontroluListele();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entity.Acil_Durum_Sistemleri;
import Repository.AcilDurumSistemleriRepository;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class AcilDurumSistemleriServiceImpl implements AcilDurumSistemleriService {
    private AcilDurumSistemleriRepository acilDurumSistemleriRepository;

    public AcilDurumSistemleriServiceImpl(AcilDurumSistemleriRepository acilDurumSistemleriRepository) {
        this.acilDurumSistemleriRepository = acilDurumSistemleriRepository;
    }

    @Override
    public Acil_Durum_Sistemleri acilDurumSistemiBul(Long acilDurumSistemiID) {
        return acilDurumSistemleriRepository.acilDurumSistemiBul(acilDurumSistemiID);
    }

    @Override
    public void acilDurumSistemiEkle(Acil_Durum_Sistemleri acilDurumSistemleri) {
        acilDurumSistemleriRepository.acilDurumSistemiEkle(acilDurumSistemleri);
    }

    @Override
    public void acilDurumSistemiGuncelle(Acil_Durum_Sistemleri acilDurumSistemleri) {
        acilDurumSistemleriRepository.acilDurumSistemiGuncelle(acilDurumSistemleri);
    }

    @Override
    public void acilDurumSistemiSil(Long acilDurumSistemiID) {
        acilDurumSistemleriRepository.acilDurumSistemiSil(acilDurumSistemiID);
    }

    @Override
    public List<Acil_Durum_Sistemleri> tumAcilDurumSistemleriListele() {
        return acilDurumSistemleriRepository.tumAcilDurumSistemleriListele();
    } 
}

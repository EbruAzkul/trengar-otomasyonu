/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entity.Istasyon;
import Repository.IstasyonRepository;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class IstasyonServiceImpl  implements IstasyonService {
    private IstasyonRepository istasyonRepository;

    public IstasyonServiceImpl(IstasyonRepository istasyonRepository) {
        this.istasyonRepository = istasyonRepository;
    }

    @Override
    public Istasyon istasyonBul(Long istasyonID) {
        return istasyonRepository.istasyonBul(istasyonID);
    }

    @Override
    public void istasyonEkle(Istasyon istasyon) {
        istasyonRepository.istasyonEkle(istasyon);
    }

    @Override
    public void istasyonGuncelle(Istasyon istasyon) {
        istasyonRepository.istasyonGuncelle(istasyon);
    }

    @Override
    public void istasyonSil(Long istasyonID) {
        istasyonRepository.istasyonSil(istasyonID);
    }

    @Override
    public List<Istasyon> tumIstasyonlariListele() {
        return istasyonRepository.tumIstasyonlariListele();
    }
}

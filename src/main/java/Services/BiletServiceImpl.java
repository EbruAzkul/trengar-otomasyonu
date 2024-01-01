/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entity.Bilet;
import Repository.BiletRepository;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class BiletServiceImpl implements BiletService {
    private BiletRepository biletRepository;

    public BiletServiceImpl(BiletRepository biletRepository) {
        this.biletRepository = biletRepository;
    }

    @Override
    public Bilet biletBul(Long biletID) {
        return biletRepository.biletBul(biletID);
    }

    @Override
    public void biletEkle(Bilet bilet) {
        biletRepository.biletEkle(bilet);
    }

    @Override
    public void biletGuncelle(Bilet bilet) {
        biletRepository.biletGuncelle(bilet);
    }

    @Override
    public void biletSil(Long biletID) {
        biletRepository.biletSil(biletID);
    }

    @Override
    public List<Bilet> tumBiletleriListele() {
        return biletRepository.tumBiletleriListele();
    }
}

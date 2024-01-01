/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entity.Gar_Sistemi;
import Repository.GarSistemiRepository;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class GarSistemiServiceImpl implements GarSistemiService {
    private GarSistemiRepository garSistemiRepository;

    public GarSistemiServiceImpl(GarSistemiRepository garSistemiRepository) {
        this.garSistemiRepository = garSistemiRepository;
    }

    @Override
    public Gar_Sistemi garSistemiBul(Long garSistemiID) {
        return garSistemiRepository.garSistemiBul(garSistemiID);
    }

    @Override
    public void garSistemiEkle(Gar_Sistemi garSistemi) {
        garSistemiRepository.garSistemiEkle(garSistemi);
    }

    @Override
    public void garSistemiGuncelle(Gar_Sistemi garSistemi) {
        garSistemiRepository.garSistemiGuncelle(garSistemi);
    }

    @Override
    public void garSistemiSil(Long garSistemiID) {
        garSistemiRepository.garSistemiSil(garSistemiID);
    }

    @Override
    public List<Gar_Sistemi> tumGarSistemleriListele() {
        return garSistemiRepository.tumGarSistemleriListele();
    }
}

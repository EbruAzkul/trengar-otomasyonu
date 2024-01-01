/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entity.Guvenlik_Sistemi;
import Repository.GuvenlikSistemiRepository;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class GuvenlikSistemiServiceImpl implements GuvenlikSistemiService {
    private GuvenlikSistemiRepository guvenlikSistemiRepository;

    public GuvenlikSistemiServiceImpl(GuvenlikSistemiRepository guvenlikSistemiRepository) {
        this.guvenlikSistemiRepository = guvenlikSistemiRepository;
    }

    @Override
    public Guvenlik_Sistemi guvenlikSistemiBul(Long guvenlikSistemiID) {
        return guvenlikSistemiRepository.guvenlikSistemiBul(guvenlikSistemiID);
    }

    @Override
    public void guvenlikSistemiEkle(Guvenlik_Sistemi guvenlikSistemi) {
        guvenlikSistemiRepository.guvenlikSistemiEkle(guvenlikSistemi);
    }

    @Override
    public void guvenlikSistemiGuncelle(Guvenlik_Sistemi guvenlikSistemi) {
        guvenlikSistemiRepository.guvenlikSistemiGuncelle(guvenlikSistemi);
    }

    @Override
    public void guvenlikSistemiSil(Long guvenlikSistemiID) {
        guvenlikSistemiRepository.guvenlikSistemiSil(guvenlikSistemiID);
    }

    @Override
    public List<Guvenlik_Sistemi> tumGuvenlikSistemleriListele() {
        return guvenlikSistemiRepository.tumGuvenlikSistemleriListele();
    }
    
}

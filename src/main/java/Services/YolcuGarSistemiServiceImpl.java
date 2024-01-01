/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entity.Yolcu_Gar_Sistemi;
import Repository.YolcuGarSistemiRepository;
import java.util.List;


public class YolcuGarSistemiServiceImpl implements YolcuGarSistemiService {
    private YolcuGarSistemiRepository yolcuGarSistemiRepository;

    public YolcuGarSistemiServiceImpl(YolcuGarSistemiRepository yolcuGarSistemiRepository) {
        this.yolcuGarSistemiRepository = yolcuGarSistemiRepository;
    }

    @Override
    public Yolcu_Gar_Sistemi yolcuGarSistemiBul(Long yolcuGarSistemiID) {
        return yolcuGarSistemiRepository.yolcuGarSistemiBul(yolcuGarSistemiID);
    }

    @Override
    public void yolcuGarSistemiEkle(Yolcu_Gar_Sistemi yolcuGarSistemi) {
        yolcuGarSistemiRepository.yolcuGarSistemiEkle(yolcuGarSistemi);
    }

    @Override
    public void yolcuGarSistemiGuncelle(Yolcu_Gar_Sistemi yolcuGarSistemi) {
        yolcuGarSistemiRepository.yolcuGarSistemiGuncelle(yolcuGarSistemi);
    }

    @Override
    public void yolcuGarSistemiSil(Long yolcuGarSistemiID) {
        yolcuGarSistemiRepository.yolcuGarSistemiSil(yolcuGarSistemiID);
    }

    @Override
    public List<Yolcu_Gar_Sistemi> tumYolcuGarSistemleriListele() {
        return yolcuGarSistemiRepository.tumYolcuGarSistemleriListele();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entity.YolcuBilgisi;
import Repository.YolcuBilgisiRepository;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class YolcuBilgisiServiceImpl implements YolcuBilgisiService {
    private YolcuBilgisiRepository yolcuBilgisiRepository;

    public YolcuBilgisiServiceImpl(YolcuBilgisiRepository yolcuBilgisiRepository) {
        this.yolcuBilgisiRepository = yolcuBilgisiRepository;
    }

    @Override
    public YolcuBilgisi yolcuBilgisiBul(Long yolcuBilgisiID) {
        return yolcuBilgisiRepository.yolcuBilgisiBul(yolcuBilgisiID);
    }

    @Override
    public void yolcuBilgisiEkle(YolcuBilgisi yolcuBilgisi) {
        yolcuBilgisiRepository.yolcuBilgisiEkle(yolcuBilgisi);
    }

    @Override
    public void yolcuBilgisiGuncelle(YolcuBilgisi yolcuBilgisi) {
        yolcuBilgisiRepository.yolcuBilgisiGuncelle(yolcuBilgisi);
    }

    @Override
    public void yolcuBilgisiSil(Long yolcuBilgisiID) {
        yolcuBilgisiRepository.yolcuBilgisiSil(yolcuBilgisiID);
    }

    @Override
    public List<YolcuBilgisi> tumYolcuBilgileriListele() {
        return yolcuBilgisiRepository.tumYolcuBilgileriListele();
    }
}

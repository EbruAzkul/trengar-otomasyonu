/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entity.Yolcu_Listesi;
import Repository.YolcuListesiRepository;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class YolcuListesiServiceImpl implements YolcuListesiService {
    private YolcuListesiRepository yolcuListesiRepository;

    public YolcuListesiServiceImpl(YolcuListesiRepository yolcuListesiRepository) {
        this.yolcuListesiRepository = yolcuListesiRepository;
    }

    @Override
    public Yolcu_Listesi yolcuListesiBul(Long yolcuListesiID) {
        return yolcuListesiRepository.yolcuListesiBul(yolcuListesiID);
    }

    @Override
    public void yolcuListesiEkle(Yolcu_Listesi yolcuListesi) {
        yolcuListesiRepository.yolcuListesiEkle(yolcuListesi);
    }

    @Override
    public void yolcuListesiGuncelle(Yolcu_Listesi yolcuListesi) {
        yolcuListesiRepository.yolcuListesiGuncelle(yolcuListesi);
    }

    @Override
    public void yolcuListesiSil(Long yolcuListesiID) {
        yolcuListesiRepository.yolcuListesiSil(yolcuListesiID);
    }

    @Override
    public List<Yolcu_Listesi> tumYolcuListeleriListele() {
        return yolcuListesiRepository.tumYolcuListeleriListele();
    }
}

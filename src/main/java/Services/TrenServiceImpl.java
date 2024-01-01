/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entity.Tren;
import Repository.TrenRepository;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class TrenServiceImpl implements TrenService {
    
    private TrenRepository trenRepository;

    public TrenServiceImpl(TrenRepository trenRepository) {
        this.trenRepository = trenRepository;
    }

    @Override
    public Tren trenBul(Long trenID) {
        return trenRepository.trenBul(trenID);
    }

    @Override
    public void trenEkle(Tren tren) {
        trenRepository.trenEkle(tren);
    }

    @Override
    public void trenGuncelle(Tren tren) {
        trenRepository.trenGuncelle(tren);
    }

    @Override
    public void trenSil(Long trenID) {
        trenRepository.trenSil(trenID);
    }

    @Override
    public List<Tren> tumTrenleriListele() {
        return trenRepository.tumTrenleriListele();
    }
}

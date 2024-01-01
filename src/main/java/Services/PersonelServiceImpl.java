/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entity.Personel;
import Repository.PersonelRepository;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class PersonelServiceImpl implements PersonelService {
    private PersonelRepository personelRepository;

    public PersonelServiceImpl(PersonelRepository personelRepository) {
        this.personelRepository = personelRepository;
    }

    @Override
    public Personel personelBul(Long personelID) {
        return personelRepository.personelBul(personelID);
    }

    @Override
    public void personelEkle(Personel personel) {
        personelRepository.personelEkle(personel);
    }

    @Override
    public void personelGuncelle(Personel personel) {
        personelRepository.personelGuncelle(personel);
    }

    @Override
    public void personelSil(Long personelID) {
        personelRepository.personelSil(personelID);
    }

    @Override
    public List<Personel> tumPersonelleriListele() {
        return personelRepository.tumPersonelleriListele();
    }
}

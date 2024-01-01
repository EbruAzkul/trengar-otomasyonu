/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import Entity.Tren;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface TrenRepository {
    Tren trenBul(Long trenID);
    void trenEkle(Tren tren);
    void trenGuncelle(Tren tren);
    void trenSil(Long trenID);
    List<Tren> tumTrenleriListele();
}

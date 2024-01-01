/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Entity.Yolcu_Listesi;
import Util.VeritabaniBaglantisi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcYolcuListesiRepository implements YolcuListesiRepository {
    private VeritabaniBaglantisi veritabaniBaglantisi;

    public JdbcYolcuListesiRepository(VeritabaniBaglantisi veritabaniBaglantisi) {
        this.veritabaniBaglantisi = veritabaniBaglantisi;
    }

    @Override
    public Yolcu_Listesi yolcuListesiBul(Long yolcuListesiID) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "SELECT * FROM yolcu_listeleri WHERE yolcu_listesi_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, yolcuListesiID);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        Yolcu_Listesi yolcuListesi = new Yolcu_Listesi();
                        // resultSet'dan verileri çekerek Yolcu_Listesi nesnesini doldur
                        return yolcuListesi;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Yolcu Listesi bulunurken bir hata oluştu.");
        }
        return null;
    }

    @Override
    public void yolcuListesiEkle(Yolcu_Listesi yolcuListesi) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "INSERT INTO yolcu_listeleri (kolon1, kolon2, kolon3) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // preparedStatement ile Yolcu_Listesi nesnesindeki verileri sorguya set et
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Yolcu Listesi eklenirken bir hata oluştu.");
        }
    }

    @Override
    public void yolcuListesiGuncelle(Yolcu_Listesi yolcuListesi) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "UPDATE yolcu_listeleri SET kolon1 = ?, kolon2 = ?, kolon3 = ? WHERE yolcu_listesi_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // preparedStatement ile Yolcu_Listesi nesnesindeki verileri sorguya set et
                preparedStatement.setLong(4, yolcuListesi.getYolcuListesiID());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Yolcu Listesi güncellenirken bir hata oluştu.");
        }
    }

    @Override
    public void yolcuListesiSil(Long yolcuListesiID) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "DELETE FROM yolcu_listeleri WHERE yolcu_listesi_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, yolcuListesiID);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Yolcu Listesi silinirken bir hata oluştu.");
        }
    }

    @Override
    public List<Yolcu_Listesi> tumYolcuListeleriListele() {
        List<Yolcu_Listesi> yolcuListeleriList = new ArrayList<>();
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "SELECT * FROM yolcu_listeleri";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Yolcu_Listesi yolcuListesi = new Yolcu_Listesi();
                    // resultSet'dan verileri çekerek Yolcu_Listesi nesnesini doldur
                    yolcuListeleriList.add(yolcuListesi);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Tüm Yolcu Listeleri listelenirken bir hata oluştu.");
        }
        return yolcuListeleriList;
    }
}

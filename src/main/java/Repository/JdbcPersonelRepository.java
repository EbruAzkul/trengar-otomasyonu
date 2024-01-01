/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Entity.Personel;
import Util.VeritabaniBaglantisi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcPersonelRepository implements PersonelRepository {
    private VeritabaniBaglantisi veritabaniBaglantisi;

    public JdbcPersonelRepository(VeritabaniBaglantisi veritabaniBaglantisi) {
        this.veritabaniBaglantisi = veritabaniBaglantisi;
    }

    @Override
    public Personel personelBul(Long personelID) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "SELECT * FROM personeller WHERE personel_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, personelID);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        Personel personel = new Personel();
                        // resultSet'dan verileri çekerek Personel nesnesini doldur
                        return personel;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Personel bulunurken bir hata oluştu.");
        }
        return null;
    }

    @Override
    public void personelEkle(Personel personel) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "INSERT INTO personeller (kolon1, kolon2, kolon3) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // preparedStatement ile Personel nesnesindeki verileri sorguya set et
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Personel eklenirken bir hata oluştu.");
        }
    }

    @Override
    public void personelGuncelle(Personel personel) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "UPDATE personeller SET kolon1 = ?, kolon2 = ?, kolon3 = ? WHERE personel_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // preparedStatement ile Personel nesnesindeki verileri sorguya set et
                preparedStatement.setLong(4, personel.getPersonelID());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Personel güncellenirken bir hata oluştu.");
        }
    }

    @Override
    public void personelSil(Long personelID) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "DELETE FROM personeller WHERE personel_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, personelID);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Personel silinirken bir hata oluştu.");
        }
    }

    @Override
    public List<Personel> tumPersonelleriListele() {
        List<Personel> personellerList = new ArrayList<>();
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "SELECT * FROM personeller";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Personel personel = new Personel();
                    // resultSet'dan verileri çekerek Personel nesnesini doldur
                    personellerList.add(personel);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Tüm personeller listelenirken bir hata oluştu.");
        }
        return personellerList;
    }
}


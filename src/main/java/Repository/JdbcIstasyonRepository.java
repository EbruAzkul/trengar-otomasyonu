/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Entity.Istasyon;
import Util.VeritabaniBaglantisi;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcIstasyonRepository implements IstasyonRepository {
    private VeritabaniBaglantisi veritabaniBaglantisi;

    public JdbcIstasyonRepository(VeritabaniBaglantisi veritabaniBaglantisi) {
        this.veritabaniBaglantisi = veritabaniBaglantisi;
    }

    @Override
    public Istasyon istasyonBul(Long istasyonID) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "SELECT * FROM istasyonlar WHERE istasyon_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, istasyonID);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        Istasyon istasyon = new Istasyon();
                        // resultSet'dan verileri çekerek Istasyon nesnesini doldur
                        return istasyon;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("İstasyon bulunurken bir hata oluştu.");
        }
        return null;
    }

    @Override
    public void istasyonEkle(Istasyon istasyon) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "INSERT INTO istasyonlar (kolon1, kolon2, kolon3) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // preparedStatement ile Istasyon nesnesindeki verileri sorguya set et
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("İstasyon eklenirken bir hata oluştu.");
        }
    }

    @Override
    public void istasyonGuncelle(Istasyon istasyon) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "UPDATE istasyonlar SET kolon1 = ?, kolon2 = ?, kolon3 = ? WHERE istasyon_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // preparedStatement ile Istasyon nesnesindeki verileri sorguya set et
                preparedStatement.setLong(4, istasyon.getIstasyonID());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("İstasyon güncellenirken bir hata oluştu.");
        }
    }

    @Override
    public void istasyonSil(Long istasyonID) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "DELETE FROM istasyonlar WHERE istasyon_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, istasyonID);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("İstasyon silinirken bir hata oluştu.");
        }
    }

    @Override
    public List<Istasyon> tumIstasyonlariListele() {
        List<Istasyon> istasyonlarList = new ArrayList<>();
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "SELECT * FROM istasyonlar";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Istasyon istasyon = new Istasyon();
                    // resultSet'dan verileri çekerek Istasyon nesnesini doldur
                    istasyonlarList.add(istasyon);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Tüm istasyonlar listelenirken bir hata oluştu.");
        }
        return istasyonlarList;
    }
}


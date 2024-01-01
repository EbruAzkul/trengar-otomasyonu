/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Entity.Bilet;
import Util.VeritabaniBaglantisi;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class JdbcBiletRepository implements BiletRepository {
    private VeritabaniBaglantisi veritabaniBaglantisi;

    public JdbcBiletRepository(VeritabaniBaglantisi veritabaniBaglantisi) {
        this.veritabaniBaglantisi = veritabaniBaglantisi;
    }

    @Override
    public Bilet biletBul(Long biletID) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "SELECT * FROM biletler WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, biletID);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // Veritabanından alınan bilgilerle Bilet nesnesi oluşturulabilir
                        Bilet bilet = new Bilet();
                        // ... Veritabanından bilgileri çek ve nesneyi oluştur
                        return bilet;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Bilet bulma hatası: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void biletEkle(Bilet bilet) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "INSERT INTO biletler (column1, column2, ...) VALUES (?, ?, ...)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // PreparedStatement ile parametreleri set et ve execute et
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Bilet ekleme hatası: " + e.getMessage());
        }
    }

    @Override
    public void biletGuncelle(Bilet bilet) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "UPDATE biletler SET column1 = ?, column2 = ?, ... WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // PreparedStatement ile parametreleri set et ve execute et
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Bilet güncelleme hatası: " + e.getMessage());
        }
    }

    @Override
    public void biletSil(Long biletID) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "DELETE FROM biletler WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, biletID);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Bilet silme hatası: " + e.getMessage());
        }
    }

    @Override
    public List<Bilet> tumBiletleriListele() {
        List<Bilet> biletList = new ArrayList<>();
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "SELECT * FROM biletler";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    // Her bir satır için Bilet nesnesi oluştur ve listeye ekle
                    Bilet bilet = new Bilet();
                    // ... Veritabanından bilgileri çek ve nesneyi oluştur
                    biletList.add(bilet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Tüm biletleri listeleme hatası: " + e.getMessage());
        }
        return biletList;
    }
}


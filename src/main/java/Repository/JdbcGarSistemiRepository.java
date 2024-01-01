/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Entity.Gar_Sistemi;
import Util.VeritabaniBaglantisi;
import java.util.ArrayList;
import java.util.List;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcGarSistemiRepository implements GarSistemiRepository {
    private VeritabaniBaglantisi veritabaniBaglantisi;

    public JdbcGarSistemiRepository(VeritabaniBaglantisi veritabaniBaglantisi) {
        this.veritabaniBaglantisi = veritabaniBaglantisi;
    }

    @Override
    public Gar_Sistemi garSistemiBul(Long garSistemiID) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "SELECT * FROM gar_sistemleri WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, garSistemiID);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        Gar_Sistemi garSistemi = new Gar_Sistemi();
                        // Veritabanından alınan bilgilerle Gar_Sistemi nesnesi oluşturulabilir
                        // ... Veritabanından bilgileri çek ve nesneyi oluştur
                        return garSistemi;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Gar sistemi bulma hatası: " + e.getMessage());
        }
        return null;
    }

   @Override
public void garSistemiEkle(Gar_Sistemi garSistemi) {
    try (Connection connection = veritabaniBaglantisi.baglan()) {
        String sql = "INSERT INTO gar_sistemleri (column1, column2, ...) VALUES (?, ?, ...)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // PreparedStatement ile parametreleri set et ve execute et
            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    garSistemi.setGarSistemiID(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Gar sistemi eklerken ID alınamadı.");
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException("Gar sistemi ekleme hatası: " + e.getMessage());
    }
}


    @Override
    public void garSistemiGuncelle(Gar_Sistemi garSistemi) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "UPDATE gar_sistemleri SET column1 = ?, column2 = ?, ... WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // PreparedStatement ile parametreleri set et ve execute et
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Gar sistemi güncelleme hatası: " + e.getMessage());
        }
    }

    @Override
    public void garSistemiSil(Long garSistemiID) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "DELETE FROM gar_sistemleri WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, garSistemiID);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Gar sistemi silme hatası: " + e.getMessage());
        }
    }

    @Override
    public List<Gar_Sistemi> tumGarSistemleriListele() {
        List<Gar_Sistemi> garSistemleriList = new ArrayList<>();
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "SELECT * FROM gar_sistemleri";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Gar_Sistemi garSistemi = new Gar_Sistemi();
                    // Her bir satır için Gar_Sistemi nesnesi oluştur ve listeye ekle
                    // ... Veritabanından bilgileri çek ve nesneyi oluştur
                    garSistemleriList.add(garSistemi);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Tüm gar sistemleri listeleme hatası: " + e.getMessage());
        }
        return garSistemleriList;
    }
}


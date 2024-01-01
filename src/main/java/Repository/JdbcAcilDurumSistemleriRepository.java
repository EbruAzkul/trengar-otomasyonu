/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Entity.Acil_Durum_Sistemleri;
import Util.VeritabaniBaglantisi;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class JdbcAcilDurumSistemleriRepository implements AcilDurumSistemleriRepository {
    
    private VeritabaniBaglantisi veritabaniBaglantisi;

    public JdbcAcilDurumSistemleriRepository(VeritabaniBaglantisi veritabaniBaglantisi) {
        this.veritabaniBaglantisi = veritabaniBaglantisi;
    }

    @Override
    public Acil_Durum_Sistemleri acilDurumSistemiBul(Long acilDurumSistemiID) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "SELECT * FROM acil_durum_sistemleri WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, acilDurumSistemiID);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // Veritabanından alınan bilgilerle Acil_Durum_Sistemleri nesnesi oluşturulabilir
                        Acil_Durum_Sistemleri acilDurumSistemi = new Acil_Durum_Sistemleri();
                        // ... Veritabanından bilgileri çek ve nesneyi oluştur
                        return acilDurumSistemi;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Acil durum sistemi bulma hatası: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void acilDurumSistemiEkle(Acil_Durum_Sistemleri acilDurumSistemleri) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "INSERT INTO acil_durum_sistemleri (column1, column2, ...) VALUES (?, ?, ...)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // PreparedStatement ile parametreleri set et ve execute et
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Acil durum sistemi ekleme hatası: " + e.getMessage());
        }
    }

    @Override
    public void acilDurumSistemiGuncelle(Acil_Durum_Sistemleri acilDurumSistemleri) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "UPDATE acil_durum_sistemleri SET column1 = ?, column2 = ?, ... WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // PreparedStatement ile parametreleri set et ve execute et
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Acil durum sistemi güncelleme hatası: " + e.getMessage());
        }
    }

    @Override
    public void acilDurumSistemiSil(Long acilDurumSistemiID) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "DELETE FROM acil_durum_sistemleri WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, acilDurumSistemiID);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Acil durum sistemi silme hatası: " + e.getMessage());
        }
    }

    @Override
    public List<Acil_Durum_Sistemleri> tumAcilDurumSistemleriListele() {
        List<Acil_Durum_Sistemleri> acilDurumSistemleriList = new ArrayList<>();
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "SELECT * FROM acil_durum_sistemleri";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    // Her bir satır için Acil_Durum_Sistemleri nesnesi oluştur ve listeye ekle
                    Acil_Durum_Sistemleri acilDurumSistemi = new Acil_Durum_Sistemleri();
                    // ... Veritabanından bilgileri çek ve nesneyi oluştur
                    acilDurumSistemleriList.add(acilDurumSistemi);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Tüm acil durum sistemleri listeleme hatası: " + e.getMessage());
        }
        return acilDurumSistemleriList;
    }
}


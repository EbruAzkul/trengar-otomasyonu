/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Entity.Guvenlik_Sistemi;
import Util.VeritabaniBaglantisi;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcGuvenlikSistemiRepository implements GuvenlikSistemiRepository {
    private VeritabaniBaglantisi veritabaniBaglantisi;

    public JdbcGuvenlikSistemiRepository(VeritabaniBaglantisi veritabaniBaglantisi) {
        this.veritabaniBaglantisi = veritabaniBaglantisi;
    }

    @Override
    public Guvenlik_Sistemi guvenlikSistemiBul(Long guvenlikSistemiID) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "SELECT * FROM guvenlik_sistemleri WHERE guvenlik_sistemi_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, guvenlikSistemiID);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        Guvenlik_Sistemi guvenlikSistemi = new Guvenlik_Sistemi();
                        // resultSet'dan verileri çekerek Guvenlik_Sistemi nesnesini doldur
                        return guvenlikSistemi;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Güvenlik sistemi bulunurken bir hata oluştu.");
        }
        return null;
    }

    @Override
    public void guvenlikSistemiEkle(Guvenlik_Sistemi guvenlikSistemi) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "INSERT INTO guvenlik_sistemleri (kolon1, kolon2, kolon3) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // preparedStatement ile Guvenlik_Sistemi nesnesindeki verileri sorguya set et
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Güvenlik sistemi eklenirken bir hata oluştu.");
        }
    }

    @Override
    public void guvenlikSistemiGuncelle(Guvenlik_Sistemi guvenlikSistemi) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "UPDATE guvenlik_sistemleri SET kolon1 = ?, kolon2 = ?, kolon3 = ? WHERE guvenlik_sistemi_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // preparedStatement ile Guvenlik_Sistemi nesnesindeki verileri sorguya set et
                preparedStatement.setLong(4, guvenlikSistemi.getGuvenlikSistemiID());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Güvenlik sistemi güncellenirken bir hata oluştu.");
        }
    }

    @Override
    public void guvenlikSistemiSil(Long guvenlikSistemiID) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "DELETE FROM guvenlik_sistemleri WHERE guvenlik_sistemi_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, guvenlikSistemiID);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Güvenlik sistemi silinirken bir hata oluştu.");
        }
    }

    @Override
    public List<Guvenlik_Sistemi> tumGuvenlikSistemleriListele() {
        List<Guvenlik_Sistemi> guvenlikSistemleriList = new ArrayList<>();
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "SELECT * FROM guvenlik_sistemleri";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Guvenlik_Sistemi guvenlikSistemi = new Guvenlik_Sistemi();
                    // resultSet'dan verileri çekerek Guvenlik_Sistemi nesnesini doldur
                    guvenlikSistemleriList.add(guvenlikSistemi);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Tüm güvenlik sistemleri listelenirken bir hata oluştu.");
        }
        return guvenlikSistemleriList;
    }
}


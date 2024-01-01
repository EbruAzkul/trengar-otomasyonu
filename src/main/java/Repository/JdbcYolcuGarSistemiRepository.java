/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Entity.Yolcu_Gar_Sistemi;
import Util.VeritabaniBaglantisi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcYolcuGarSistemiRepository implements YolcuGarSistemiRepository {
    private VeritabaniBaglantisi veritabaniBaglantisi;

    public JdbcYolcuGarSistemiRepository(VeritabaniBaglantisi veritabaniBaglantisi) {
        this.veritabaniBaglantisi = veritabaniBaglantisi;
    }

    @Override
    public Yolcu_Gar_Sistemi yolcuGarSistemiBul(Long yolcuGarSistemiID) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "SELECT * FROM yolcu_gar_sistemleri WHERE yolcu_gar_sistemi_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, yolcuGarSistemiID);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        Yolcu_Gar_Sistemi yolcuGarSistemi = new Yolcu_Gar_Sistemi();
                        // resultSet'dan verileri çekerek Yolcu_Gar_Sistemi nesnesini doldur
                        return yolcuGarSistemi;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Yolcu Gar Sistemi bulunurken bir hata oluştu.");
        }
        return null;
    }

    @Override
    public void yolcuGarSistemiEkle(Yolcu_Gar_Sistemi yolcuGarSistemi) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "INSERT INTO yolcu_gar_sistemleri (kolon1, kolon2, kolon3) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // preparedStatement ile Yolcu_Gar_Sistemi nesnesindeki verileri sorguya set et
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Yolcu Gar Sistemi eklenirken bir hata oluştu.");
        }
    }

    @Override
    public void yolcuGarSistemiGuncelle(Yolcu_Gar_Sistemi yolcuGarSistemi) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "UPDATE yolcu_gar_sistemleri SET kolon1 = ?, kolon2 = ?, kolon3 = ? WHERE yolcu_gar_sistemi_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // preparedStatement ile Yolcu_Gar_Sistemi nesnesindeki verileri sorguya set et
                preparedStatement.setLong(4, yolcuGarSistemi.getYolcuGarSistemiID());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Yolcu Gar Sistemi güncellenirken bir hata oluştu.");
        }
    }

    @Override
    public void yolcuGarSistemiSil(Long yolcuGarSistemiID) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "DELETE FROM yolcu_gar_sistemleri WHERE yolcu_gar_sistemi_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, yolcuGarSistemiID);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Yolcu Gar Sistemi silinirken bir hata oluştu.");
        }
    }

    @Override
    public List<Yolcu_Gar_Sistemi> tumYolcuGarSistemleriListele() {
        List<Yolcu_Gar_Sistemi> yolcuGarSistemleriList = new ArrayList<>();
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "SELECT * FROM yolcu_gar_sistemleri";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Yolcu_Gar_Sistemi yolcuGarSistemi = new Yolcu_Gar_Sistemi();
                    // resultSet'dan verileri çekerek Yolcu_Gar_Sistemi nesnesini doldur
                    yolcuGarSistemleriList.add(yolcuGarSistemi);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Tüm Yolcu Gar Sistemleri listelenirken bir hata oluştu.");
        }
        return yolcuGarSistemleriList;
    }
}

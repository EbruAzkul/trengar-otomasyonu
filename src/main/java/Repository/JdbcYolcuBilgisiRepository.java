/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Entity.YolcuBilgisi;
import Util.VeritabaniBaglantisi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcYolcuBilgisiRepository implements YolcuBilgisiRepository {
    private VeritabaniBaglantisi veritabaniBaglantisi;

    public JdbcYolcuBilgisiRepository(VeritabaniBaglantisi veritabaniBaglantisi) {
        this.veritabaniBaglantisi = veritabaniBaglantisi;
    }

    @Override
    public YolcuBilgisi yolcuBilgisiBul(Long yolcuBilgisiID) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "SELECT * FROM yolcu_bilgileri WHERE yolcu_bilgisi_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, yolcuBilgisiID);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        YolcuBilgisi yolcuBilgisi = new YolcuBilgisi();
                        // resultSet'dan verileri çekerek YolcuBilgisi nesnesini doldur
                        return yolcuBilgisi;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Yolcu bilgisi bulunurken bir hata oluştu.");
        }
        return null;
    }

    @Override
    public void yolcuBilgisiEkle(YolcuBilgisi yolcuBilgisi) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "INSERT INTO yolcu_bilgileri (kolon1, kolon2, kolon3) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // preparedStatement ile YolcuBilgisi nesnesindeki verileri sorguya set et
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Yolcu bilgisi eklenirken bir hata oluştu.");
        }
    }

    @Override
    public void yolcuBilgisiGuncelle(YolcuBilgisi yolcuBilgisi) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "UPDATE yolcu_bilgileri SET kolon1 = ?, kolon2 = ?, kolon3 = ? WHERE yolcu_bilgisi_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // preparedStatement ile YolcuBilgisi nesnesindeki verileri sorguya set et
                preparedStatement.setLong(4, yolcuBilgisi.getYolcuBilgisiID());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Yolcu bilgisi güncellenirken bir hata oluştu.");
        }
    }

    @Override
    public void yolcuBilgisiSil(Long yolcuBilgisiID) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "DELETE FROM yolcu_bilgileri WHERE yolcu_bilgisi_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, yolcuBilgisiID);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Yolcu bilgisi silinirken bir hata oluştu.");
        }
    }

    @Override
    public List<YolcuBilgisi> tumYolcuBilgileriListele() {
        List<YolcuBilgisi> yolcuBilgileriList = new ArrayList<>();
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "SELECT * FROM yolcu_bilgileri";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    YolcuBilgisi yolcuBilgisi = new YolcuBilgisi();
                    // resultSet'dan verileri çekerek YolcuBilgisi nesnesini doldur
                    yolcuBilgileriList.add(yolcuBilgisi);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Tüm yolcu bilgileri listelenirken bir hata oluştu.");
        }
        return yolcuBilgileriList;
    }
}


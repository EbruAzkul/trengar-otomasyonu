/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Entity.Kapi_Bariyer_Kontrolu;
import Util.VeritabaniBaglantisi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcKapiBariyerKontroluRepository implements KapiBariyerKontroluRepository {
    private VeritabaniBaglantisi veritabaniBaglantisi;

    public JdbcKapiBariyerKontroluRepository(VeritabaniBaglantisi veritabaniBaglantisi) {
        this.veritabaniBaglantisi = veritabaniBaglantisi;
    }

    @Override
    public Kapi_Bariyer_Kontrolu kapiBariyerKontroluBul(Long kapiBariyerKontroluID) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "SELECT * FROM kapi_bariyer_kontrolu WHERE kapi_bariyer_kontrolu_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, kapiBariyerKontroluID);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        Kapi_Bariyer_Kontrolu kapiBariyerKontrolu = new Kapi_Bariyer_Kontrolu();
                        // resultSet'dan verileri çekerek Kapi_Bariyer_Kontrolu nesnesini doldur
                        return kapiBariyerKontrolu;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Kapı bariyer kontrolü bulunurken bir hata oluştu.");
        }
        return null;
    }

    @Override
    public void kapiBariyerKontroluEkle(Kapi_Bariyer_Kontrolu kapiBariyerKontrolu) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "INSERT INTO kapi_bariyer_kontrolu (kolon1, kolon2, kolon3) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // preparedStatement ile Kapi_Bariyer_Kontrolu nesnesindeki verileri sorguya set et
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Kapı bariyer kontrolü eklenirken bir hata oluştu.");
        }
    }

    @Override
    public void kapiBariyerKontroluGuncelle(Kapi_Bariyer_Kontrolu kapiBariyerKontrolu) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "UPDATE kapi_bariyer_kontrolu SET kolon1 = ?, kolon2 = ?, kolon3 = ? WHERE kapi_bariyer_kontrolu_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // preparedStatement ile Kapi_Bariyer_Kontrolu nesnesindeki verileri sorguya set et
                preparedStatement.setLong(4, kapiBariyerKontrolu.getKapiBariyerKontroluID());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Kapı bariyer kontrolü güncellenirken bir hata oluştu.");
        }
    }

    @Override
    public void kapiBariyerKontroluSil(Long kapiBariyerKontroluID) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "DELETE FROM kapi_bariyer_kontrolu WHERE kapi_bariyer_kontrolu_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, kapiBariyerKontroluID);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Kapı bariyer kontrolü silinirken bir hata oluştu.");
        }
    }

    @Override
    public List<Kapi_Bariyer_Kontrolu> tumKapiBariyerKontroluListele() {
        List<Kapi_Bariyer_Kontrolu> kapiBariyerKontroluList = new ArrayList<>();
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "SELECT * FROM kapi_bariyer_kontrolu";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Kapi_Bariyer_Kontrolu kapiBariyerKontrolu = new Kapi_Bariyer_Kontrolu();
                    // resultSet'dan verileri çekerek Kapi_Bariyer_Kontrolu nesnesini doldur
                    kapiBariyerKontroluList.add(kapiBariyerKontrolu);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Tüm kapı bariyer kontrolü listelenirken bir hata oluştu.");
        }
        return kapiBariyerKontroluList;
    }
}



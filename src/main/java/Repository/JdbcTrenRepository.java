/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Entity.Tren;
import Util.VeritabaniBaglantisi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcTrenRepository implements TrenRepository {
    private VeritabaniBaglantisi veritabaniBaglantisi;

    public JdbcTrenRepository(VeritabaniBaglantisi veritabaniBaglantisi) {
        this.veritabaniBaglantisi = veritabaniBaglantisi;
    }

    @Override
    public Tren trenBul(Long trenID) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "SELECT * FROM trenler WHERE tren_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, trenID);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        Tren tren = new Tren();
                        // resultSet'dan verileri çekerek Tren nesnesini doldur
                        return tren;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Tren bulunurken bir hata oluştu.");
        }
        return null;
    }

    @Override
    public void trenEkle(Tren tren) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "INSERT INTO trenler (kolon1, kolon2, kolon3) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // preparedStatement ile Tren nesnesindeki verileri sorguya set et
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Tren eklenirken bir hata oluştu.");
        }
    }

    @Override
    public void trenGuncelle(Tren tren) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "UPDATE trenler SET kolon1 = ?, kolon2 = ?, kolon3 = ? WHERE tren_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // preparedStatement ile Tren nesnesindeki verileri sorguya set et
                preparedStatement.setLong(4, tren.getTrenID());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Tren güncellenirken bir hata oluştu.");
        }
    }

    @Override
    public void trenSil(Long trenID) {
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "DELETE FROM trenler WHERE tren_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, trenID);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Tren silinirken bir hata oluştu.");
        }
    }

    @Override
    public List<Tren> tumTrenleriListele() {
        List<Tren> trenlerList = new ArrayList<>();
        try (Connection connection = veritabaniBaglantisi.baglan()) {
            String sql = "SELECT * FROM trenler";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Tren tren = new Tren();
                    // resultSet'dan verileri çekerek Tren nesnesini doldur
                    trenlerList.add(tren);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Tüm trenler listelenirken bir hata oluştu.");
        }
        return trenlerList;
    }
}


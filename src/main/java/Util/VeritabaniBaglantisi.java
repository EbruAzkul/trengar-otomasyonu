/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class VeritabaniBaglantisi {
    private static final String URL = "jdbc:postgresql://localhost:5432/trenGarOtomasyon";
    private static final String KULLANICI_ADI = "postgres";
    private static final String SIFRE = "12345";

    private static VeritabaniBaglantisi instance;

    private VeritabaniBaglantisi() {
        // Gizli kurucu metod
    }

    public static VeritabaniBaglantisi getInstance() {
        if (instance == null) {
            instance = new VeritabaniBaglantisi();
        }
        return instance;
    }

    public Connection baglan() {
        try {
            return DriverManager.getConnection(URL, KULLANICI_ADI, SIFRE);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Veritabanına bağlanılamadı.");
        }
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionedt.models;

/**
 *
 * @author diary
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connexionDB {
    
    private static Connection instance;

    private connexionDB() {}

    public static Connection getInstance() throws SQLException{
        if (instance == null || instance.isClosed()) {
            try {
                String url = "jdbc:postgresql://localhost:5432/gestionEDT";
                String user = "postgres";
                String password = "22juillet2024";

                instance = DriverManager.getConnection(url, user, password);
                instance.setAutoCommit(true);
                System.out.println("Connexion à PostgreSQL réussie !");
            } catch (SQLException e) {
                System.out.println("Erreur de connexion : " + e.getMessage());
                throw e;
            }
        }
        return instance;
    }
    
    public static void main(String[] args){
        try {
            Connection conn = getInstance();
            if (conn != null && !conn.isClosed()) {
                System.out.println("Test de connexion réussi.");
            } else {
                System.out.println("Test de connexion échoué.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors du test de connexion : " + e.getMessage());
        }
        }
    }



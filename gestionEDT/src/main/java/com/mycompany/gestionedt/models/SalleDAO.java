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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;



public class SalleDAO {
    private static final Logger logger = Logger.getLogger(SalleDAO.class.getName());
    private static final String INSERT_SALLE = "INSERT INTO SALLE (idsalle, design, occupation) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_SALLES = "SELECT idsalle, design, occupation FROM SALLE";
    private static final String UPDATE_SALLE = "UPDATE SALLE SET design = ?, occupation = ? WHERE idsalle = ?";
    private static final String DELETE_SALLE = "DELETE FROM SALLE WHERE idsalle = ?";
    private static final String SEARCH_SALLES_BY_DESIGN = "SELECT idsalle, design, occupation FROM salle WHERE design = ?"; // Recherche exacte par Design (INT)
    
    
    public void insertSalle(salleModels salle) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = connexionDB.getInstance();
            if (conn == null) {
                logger.log(java.util.logging.Level.SEVERE, "Connexion à la base de données échouée.");
                return;
            }

            logger.info("Tentative d'insertion pour : " + salle.getIdSalle());
            stmt = conn.prepareStatement(INSERT_SALLE);
            stmt.setString(1, salle.getIdSalle()); // idSalle comme String
            stmt.setInt(2, salle.getDesign()); // Design comme INT
            stmt.setString(3, salle.getOccupation()); // Occupation comme String
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(java.util.logging.Level.SEVERE, "Erreur SQL : " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                logger.log(java.util.logging.Level.SEVERE, "Erreur de fermeture : " + e.getMessage());
            }
        }
    }

    public ArrayList<salleModels> getAllSalles() {
        ArrayList<salleModels> salles = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = connexionDB.getInstance();
            if (conn == null) {
                logger.log(java.util.logging.Level.SEVERE, "Connexion à la base de données échouée.");
                return salles;
            }

            stmt = conn.prepareStatement(SELECT_ALL_SALLES);
            rs = stmt.executeQuery();

            while (rs.next()) {
                salleModels salle = new salleModels(
                    rs.getString("idsalle"), // Note : "idsalle" au lieu de "idSalle" pour correspondre à la casse de la table
                    rs.getInt("design"),
                    rs.getString("occupation") // Occupation comme String
                );
                salles.add(salle);
            }
        } catch (SQLException e) {
            logger.log(java.util.logging.Level.SEVERE, "Erreur SQL : " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                logger.log(java.util.logging.Level.SEVERE, "Erreur de fermeture : " + e.getMessage());
            }
        }
        return salles;
    }

    public void updateSalle(salleModels salle) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = connexionDB.getInstance();
            if (conn == null) {
                logger.log(java.util.logging.Level.SEVERE, "Connexion à la base de données échouée.");
                return;
            }

            logger.info("Tentative de mise à jour pour : " + salle.getIdSalle());
            stmt = conn.prepareStatement(UPDATE_SALLE);
            stmt.setInt(1, salle.getDesign()); // Design comme INT
            stmt.setString(2, salle.getOccupation()); // Occupation comme String
            stmt.setString(3, salle.getIdSalle());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(java.util.logging.Level.SEVERE, "Erreur SQL : " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                logger.log(java.util.logging.Level.SEVERE, "Erreur de fermeture : " + e.getMessage());
            }
        }
    }

    public void deleteSalle(String idSalle) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = connexionDB.getInstance();
            if (conn == null) {
                logger.log(java.util.logging.Level.SEVERE, "Connexion à la base de données échouée.");
                return;
            }

            logger.info("Tentative de suppression pour idSalle : " + idSalle);
            stmt = conn.prepareStatement(DELETE_SALLE);
            stmt.setString(1, idSalle);
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(java.util.logging.Level.SEVERE, "Erreur SQL : " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                logger.log(java.util.logging.Level.SEVERE, "Erreur de fermeture : " + e.getMessage());
            }
        }
    }

    public ArrayList<salleModels> getSallesByDesign(int designValue) {
        ArrayList<salleModels> salles = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = connexionDB.getInstance();
            if (conn == null) {
                logger.log(java.util.logging.Level.SEVERE, "Connexion à la base de données échouée.");
                return salles;
            }

            logger.info("Recherche de salles avec Design : " + designValue);
            stmt = conn.prepareStatement(SEARCH_SALLES_BY_DESIGN);
            stmt.setInt(1, designValue); // Recherche exacte par Design
            rs = stmt.executeQuery();

            while (rs.next()) {
                salleModels salle = new salleModels(
                    rs.getString("idsalle"), // Note : "idsalle" au lieu de "idSalle"
                    rs.getInt("design"),
                    rs.getString("occupation") // Occupation comme String
                );
                salles.add(salle);
            }
        } catch (SQLException e) {
            logger.log(java.util.logging.Level.SEVERE, "Erreur SQL lors de la recherche : " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                logger.log(java.util.logging.Level.SEVERE, "Erreur de fermeture : " + e.getMessage());
            }
        }
        return salles;
    }
    
    
}
    


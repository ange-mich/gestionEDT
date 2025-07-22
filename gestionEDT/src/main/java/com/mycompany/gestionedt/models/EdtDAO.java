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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EdtDAO {
   private static final Logger logger = Logger.getLogger(EdtDAO.class.getName());
    private static final String INSERT_EDT = "INSERT INTO EDT (idEDT, IDSalle, idProf, IDClasse, Cours, Date) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_EDTS = "SELECT idEDT, IDSalle, idProf, IDClasse, Cours, Date FROM EDT";
    private static final String UPDATE_EDT = "UPDATE EDT SET IDSalle = ?, idProf = ?, IDClasse = ?, Cours = ?, Date = ? WHERE idEDT = ?";
    private static final String DELETE_EDT = "DELETE FROM EDT WHERE idEDT = ?";
    private static final String SELECT_OCCUPIED_ROOMS = "SELECT DISTINCT IDSalle FROM emploi_du_temps WHERE Date <= ? AND DATE_ADD(Date, INTERVAL 1 HOUR) >= ?";
   /*public void insertEdt(EdtModels edt) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = connexionDB.getInstance();
            if (conn == null) {
                logger.log(Level.SEVERE, "Connexion échouée.");
                return;
            }
            stmt = conn.prepareStatement(INSERT_EDT);
            stmt.setString(1, edt.getIdEDT());
            stmt.setInt(2, edt.getIDSalle());
            stmt.setString(3, edt.getIdProf());
            stmt.setString(4, edt.getIDClasse());
            stmt.setString(5, edt.getCours());
            stmt.setTimestamp(6, edt.getDate());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erreur SQL : " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Erreur de fermeture : " + e.getMessage());
            }
        }
    }

    public ArrayList<EdtModels> getAllEdts() {
        ArrayList<EdtModels> edts = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = connexionDB.getInstance();
            if (conn == null) {
                logger.log(Level.SEVERE, "Connexion échouée.");
                return edts;
            }
            stmt = conn.prepareStatement(SELECT_ALL_EDTS);
            rs = stmt.executeQuery();
            while (rs.next()) {
                edts.add(new EdtModels(
                    rs.getString("idEDT"),
                    rs.getInt("IDSalle"),
                    rs.getString("idProf"),
                    rs.getString("IDClasse"),
                    rs.getString("Cours"),
                    rs.getTimestamp("Date")
                ));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erreur SQL : " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Erreur de fermeture : " + e.getMessage());
            }
        }
        return edts;
    }

    public void updateEdt(EdtModels edt) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = connexionDB.getInstance();
            if (conn == null) {
                logger.log(Level.SEVERE, "Connexion échouée.");
                return;
            }
            stmt = conn.prepareStatement(UPDATE_EDT);
            stmt.setInt(1, edt.getIDSalle());
            stmt.setString(2, edt.getIdProf());
            stmt.setString(3, edt.getIDClasse());
            stmt.setString(4, edt.getCours());
            stmt.setTimestamp(5, edt.getDate());
            stmt.setString(6, edt.getIdEDT());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erreur SQL : " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Erreur de fermeture : " + e.getMessage());
            }
        }
    }
    public void deleteEdt(String idEDT) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = connexionDB.getInstance();
            if (conn == null) {
                logger.log(Level.SEVERE, "Connexion échouée.");
                return;
            }
            stmt = conn.prepareStatement(DELETE_EDT);
            stmt.setString(1, idEDT);
            int rowsAffected = stmt.executeUpdate();
            logger.info("Suppression effectuée, lignes affectées : " + rowsAffected);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erreur SQL : " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Erreur de fermeture : " + e.getMessage());
            }
        }
    }*/
    
    
    
    
    public void insertEdt(EdtModels edt) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = connexionDB.getInstance();
            if (conn == null) {
                logger.log(Level.SEVERE, "Connexion échouée.");
                return;
            }
            stmt = conn.prepareStatement(INSERT_EDT);
            stmt.setString(1, edt.getIdEDT());
            stmt.setInt(2, edt.getIDSalle());
            stmt.setString(3, edt.getIdProf());
            stmt.setString(4, edt.getIDClasse());
            stmt.setString(5, edt.getCours());
            stmt.setTimestamp(6, edt.getDate());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erreur SQL : " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Erreur de fermeture : " + e.getMessage());
            }
        }
    }

    public ArrayList<EdtModels> getAllEdts() {
        ArrayList<EdtModels> edts = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = connexionDB.getInstance();
            if (conn == null) {
                logger.log(Level.SEVERE, "Connexion échouée.");
                return edts;
            }
            stmt = conn.prepareStatement(SELECT_ALL_EDTS);
            rs = stmt.executeQuery();
            while (rs.next()) {
                edts.add(new EdtModels(
                    rs.getString("idEDT"),
                    rs.getInt("IDSalle"),
                    rs.getString("idProf"),
                    rs.getString("IDClasse"),
                    rs.getString("Cours"),
                    rs.getTimestamp("Date")
                ));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erreur SQL : " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Erreur de fermeture : " + e.getMessage());
            }
        }
        return edts;
    }

    public void updateEdt(EdtModels edt) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = connexionDB.getInstance();
            if (conn == null) {
                logger.log(Level.SEVERE, "Connexion échouée.");
                return;
            }
            stmt = conn.prepareStatement(UPDATE_EDT);
            stmt.setInt(1, edt.getIDSalle());
            stmt.setString(2, edt.getIdProf());
            stmt.setString(3, edt.getIDClasse());
            stmt.setString(4, edt.getCours());
            stmt.setTimestamp(5, edt.getDate());
            stmt.setString(6, edt.getIdEDT());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erreur SQL : " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Erreur de fermeture : " + e.getMessage());
            }
        }
    }

    public void deleteEdt(String idEDT) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = connexionDB.getInstance();
            if (conn == null) {
                logger.log(Level.SEVERE, "Connexion échouée.");
                return;
            }
            stmt = conn.prepareStatement(DELETE_EDT);
            stmt.setString(1, idEDT);
            int rowsAffected = stmt.executeUpdate();
            logger.info("Suppression effectuée, lignes affectées : " + rowsAffected);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erreur SQL : " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Erreur de fermeture : " + e.getMessage());
            }
        }
    }

    public ArrayList<Integer> getFreeRooms(Timestamp checkTime) {
        ArrayList<Integer> occupiedRooms = new ArrayList<>();
        ArrayList<Integer> allRooms = new ArrayList<>(); // Simulation de toutes les salles
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = connexionDB.getInstance();
            if (conn == null) {
                logger.log(Level.SEVERE, "Connexion échouée.");
                return new ArrayList<>();
            }
            stmt = conn.prepareStatement(SELECT_OCCUPIED_ROOMS);
            stmt.setTimestamp(1, checkTime);
            stmt.setTimestamp(2, checkTime); // Vérifie si l'heure chevauche un cours d'1 heure
            rs = stmt.executeQuery();
            while (rs.next()) {
                occupiedRooms.add(rs.getInt("IDSalle"));
            }
            // Simulation d'une liste de toutes les salles (1 à 10)
            for (int i = 1; i <= 10; i++) {
                allRooms.add(i);
            }
            allRooms.removeAll(occupiedRooms);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erreur SQL : " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Erreur de fermeture : " + e.getMessage());
            }
        }
        return allRooms;
    }
}

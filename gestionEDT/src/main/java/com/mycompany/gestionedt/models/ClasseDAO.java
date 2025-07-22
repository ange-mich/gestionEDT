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
import java.util.logging.Level;
import java.util.logging.Logger;



public class ClasseDAO {
   private static final Logger logger = Logger.getLogger(ClasseDAO.class.getName());
    private static final String INSERT_CLASSE = "INSERT INTO CLASSE (idclass, niveau) VALUES (?, ?)"; // Changé idclasse en idclass
    private static final String SELECT_ALL_CLASSES = "SELECT idclass, niveau FROM CLASSE"; // Changé idclasse en idclass
    private static final String UPDATE_CLASSE = "UPDATE CLASSE SET niveau = ? WHERE idclass = ?"; // Changé idclasse en idclass
    private static final String DELETE_CLASSE = "DELETE FROM CLASSE WHERE idclass = ?"; // Changé idclasse en idclass

    public void insertClasse(ClasseModels classe) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = connexionDB.getInstance();
            if (conn == null) {
                logger.log(Level.SEVERE, "Connexion échouée.");
                return;
            }
            stmt = conn.prepareStatement(INSERT_CLASSE);
            stmt.setInt(1, classe.getIdclasse());
            stmt.setString(2, classe.getNiveau());
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

    public ArrayList<ClasseModels> getAllClasses() {
        ArrayList<ClasseModels> classes = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = connexionDB.getInstance();
            if (conn == null) {
                logger.log(Level.SEVERE, "Connexion échouée.");
                return classes;
            }
            stmt = conn.prepareStatement(SELECT_ALL_CLASSES);
            rs = stmt.executeQuery();
            while (rs.next()) {
                classes.add(new ClasseModels(
                    rs.getInt("idclass"), // Changé idclasse en idclass
                    rs.getString("niveau")
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
        return classes;
    }

    public void updateClasse(ClasseModels classe) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = connexionDB.getInstance();
            if (conn == null) {
                logger.log(Level.SEVERE, "Connexion échouée.");
                return;
            }
            stmt = conn.prepareStatement(UPDATE_CLASSE);
            stmt.setString(1, classe.getNiveau());
            stmt.setInt(2, classe.getIdclasse());
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

    public void deleteClasse(int idClasse) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = connexionDB.getInstance();
            if (conn == null) {
                logger.log(Level.SEVERE, "Connexion échouée.");
                return;
            }
            stmt = conn.prepareStatement(DELETE_CLASSE);
            stmt.setInt(1, idClasse);
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
}

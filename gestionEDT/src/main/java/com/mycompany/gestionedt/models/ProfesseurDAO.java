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
import java.util.logging.Logger;
import java.util.ArrayList;


public class ProfesseurDAO {
    private static final Logger logger = Logger.getLogger(ProfesseurDAO.class.getName());
    private static final String INSERT_PROF = "INSERT INTO PROFESSEUR (idProf,NomProf,PrenomProf,Grade) VALUES (?,?,?,?)";
    private static final String SELECT_ALL_PROFS = "SELECT idProf, NomProf, PrenomProf, Grade FROM PROFESSEUR ORDER BY idProf ASC";
   private static final String UPDATE_PROF = "UPDATE PROFESSEUR SET NomProf = ?, PrenomProf = ?, Grade = ? WHERE idProf = ?";
    private static final String DELETE_PROF = "DELETE FROM PROFESSEUR WHERE idProf = ?";
    private static final String SEARCH_PROFS_BY_NAME = "SELECT idProf, NomProf, PrenomProf, GradeProf FROM PROFESSEUR WHERE (NomProf) LIKE ? OR (PrenomProf) LIKE ?";
   public void insertProfesseur(ProfesseurModels  prof){
       Connection conn = null;
       PreparedStatement stmt = null;
     
       
      try{
       
          conn = connexionDB.getInstance();
            if (conn == null) {
                logger.log(java.util.logging.Level.SEVERE, "Connexion à la base de données échouée.");
                return;
      }
            /*Generer l'ID Automatiquement*/
           
            
            logger.info("Tentative d'insertion pour : " + prof.getNomProf() + ", " + prof.getPrenomProf() + ", " + prof.getGrade());
            stmt = conn.prepareStatement(INSERT_PROF);
            stmt.setString(1, prof.getIdProf());
            stmt.setString(2, prof.getNomProf());
            stmt.setString(3, prof.getPrenomProf());
            stmt.setString(4, prof.getGrade());
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
                logger.info("Insertion réussie pour idProf : " + prof.getIdProf());
            } else {
                logger.warning("Aucune ligne insérée pour : " + prof.getIdProf());
            }
            
   }catch (SQLException e) {
            logger.log(java.util.logging.Level.SEVERE, "Erreur SQL lors de l'insertion : " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                logger.log(java.util.logging.Level.SEVERE, "Erreur de fermeture : " + e.getMessage());
            }
        }
      }
   
   public ArrayList<ProfesseurModels> getAllProfesseurs(){
       ArrayList<ProfesseurModels> professeurs = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
   try {
            conn = connexionDB.getInstance();
            if (conn == null) {
                logger.log(java.util.logging.Level.SEVERE, "Connexion à la base de données échouée.");
                return professeurs;
            }
            stmt = conn.prepareStatement(SELECT_ALL_PROFS);
            rs = stmt.executeQuery();

            while (rs.next()) {
                ProfesseurModels prof = new ProfesseurModels(
                    rs.getString("idProf"),
                    rs.getString("NomProf"),
                    rs.getString("PrenomProf"),
                    rs.getString("Grade")
                );
                professeurs.add(prof);
                }
            logger.info("Récupération de " + professeurs.size() + " professeurs réussie.");
        } catch (SQLException e) {
            logger.log(java.util.logging.Level.SEVERE, "Erreur SQL lors de la récupération : " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                logger.log(java.util.logging.Level.SEVERE, "Erreur de fermeture : " + e.getMessage());
            }
        }
        return professeurs;
    }

   public void updateProfesseur(ProfesseurModels prof) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try{
            conn = connexionDB.getInstance();
            if (conn == null) {
                logger.log(java.util.logging.Level.SEVERE, "Connexion à la base de données échouée.");
                return;
            }
            logger.info("Tentative de mise à jour pour : " + prof.getIdProf() + ", " + prof.getNomProf() + ", " + prof.getPrenomProf() + ", " + prof.getGrade());
            stmt = conn.prepareStatement(UPDATE_PROF);
            stmt.setString(1, prof.getNomProf());
            stmt.setString(2, prof.getPrenomProf());
            stmt.setString(3, prof.getGrade());
            stmt.setString(4, prof.getIdProf());
            int rowsAffected = stmt.executeUpdate();
           
        if (rowsAffected > 0) {
                logger.info("Mise à jour réussie pour idProf : " + prof.getIdProf());
            } else {
                logger.warning("Aucune mise à jour effectuée pour idProf : " + prof.getIdProf());
            }
        }catch (SQLException e) {
            logger.log(java.util.logging.Level.SEVERE, "Erreur SQL lors de la mise à jour : " + e.getMessage());
        }finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                logger.log(java.util.logging.Level.SEVERE, "Erreur de fermeture : " + e.getMessage());
            }
}
   }
   
   
   public void deleteProfesseur(String idProf) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = connexionDB.getInstance();
            if (conn == null) {
                logger.log(java.util.logging.Level.SEVERE, "Connexion à la base de données échouée.");
                return;
            }

            logger.info("Tentative de suppression pour idProf : " + idProf);
            stmt = conn.prepareStatement(DELETE_PROF);
            stmt.setString(1, idProf);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                logger.info("Suppression réussie pour idProf : " + idProf);
            } else {
                logger.warning("Aucune suppression effectuée pour idProf : " + idProf);
            }
        } catch (SQLException e) {
            logger.log(java.util.logging.Level.SEVERE, "Erreur SQL lors de la suppression : " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                logger.log(java.util.logging.Level.SEVERE, "Erreur de fermeture : " + e.getMessage());
            }
        }
   }
        
        
        
        public ArrayList<ProfesseurModels> getProfesseursByName(String searchText) {
        ArrayList<ProfesseurModels> professeurs = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = connexionDB.getInstance();
            if (conn == null) {
                logger.log(java.util.logging.Level.SEVERE, "Connexion à la base de données échouée.");
                return professeurs;
            }

            logger.info("Recherche de professeurs avec nom contenant : " + searchText);
            stmt = conn.prepareStatement(SEARCH_PROFS_BY_NAME);
            stmt.setString(1, "%" + searchText.toLowerCase() + "%"); // Recherche insensible à la casse
            rs = stmt.executeQuery();

            while (rs.next()) {
                ProfesseurModels prof = new ProfesseurModels(
                    rs.getString("idProf"),
                    rs.getString("NomProf"),
                    rs.getString("PrenomProf"),
                    rs.getString("GradeProf")
                );
                professeurs.add(prof);
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
        return professeurs;
    }
 }


   



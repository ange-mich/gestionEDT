/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionedt.controllers;

import com.mycompany.gestionedt.models.ProfesseurDAO;
import com.mycompany.gestionedt.models.ProfesseurModels;
import java.util.ArrayList;

/**
 *
 * @author diary
 */
public class ProfesseurControllers {
    private ProfesseurDAO professeurDAO;
    
    public ProfesseurControllers(){
    this.professeurDAO = new ProfesseurDAO();
            }
    
    public ProfesseurModels  ajouterProfesseur(String idProf,String NomProf, String PrenomProf, String Grade){
        ProfesseurModels  prof = new ProfesseurModels (idProf,NomProf, PrenomProf, Grade); // Crée un nouveau professeur
        professeurDAO.insertProfesseur(prof); // Insère et met à jour l'idProf
        if (prof.getIdProf() == null) {
            System.out.println("Attention : idProf est null après insertion !");
        }
        return prof;
        
    }
    
    public ArrayList<ProfesseurModels> getAllProfesseurs(){
        return professeurDAO.getAllProfesseurs();
    }
    
    public void updateProfesseur(ProfesseurModels prof){
        professeurDAO.updateProfesseur(prof);
    }
    
    public void deleteProfesseur(String idProf) {
        professeurDAO.deleteProfesseur(idProf);
    }
    public ArrayList<ProfesseurModels> getProfesseursByName(String searchText) {
        return professeurDAO.getProfesseursByName(searchText);
    }
}

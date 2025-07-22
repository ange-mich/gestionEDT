/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionedt.controllers;

import com.mycompany.gestionedt.models.SalleDAO;
import com.mycompany.gestionedt.models.salleModels;
import java.util.ArrayList;

/**
 *
 * @author diary
 */
public class SalleControllers {
    private SalleDAO salleDAO;

    public SalleControllers() {
        this.salleDAO = new SalleDAO();
    }

    public salleModels ajouterSalle(String idSalle, int design, String occupation) {
        salleModels salle = new salleModels(idSalle, design, occupation);
        salleDAO.insertSalle(salle);
        return salle;
    }

    public ArrayList<salleModels> getAllSalles() {
        return salleDAO.getAllSalles();
    }

    public void updateSalle(salleModels salle) {
        salleDAO.updateSalle(salle);
    }

    public void deleteSalle(String idSalle) {
        salleDAO.deleteSalle(idSalle);
    }

    public ArrayList<salleModels> getSallesByDesign(int designValue) {
        return salleDAO.getSallesByDesign(designValue);
    }
}

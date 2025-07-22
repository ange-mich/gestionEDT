/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionedt.controllers;

/**
 *
 * @author diary
 */
import com.mycompany.gestionedt.models.ClasseModels;
import com.mycompany.gestionedt.models.ClasseDAO;
import java.util.ArrayList;


public class ClasseControllers {
  
    private ClasseDAO classeDAO;

    public ClasseControllers() {
        this.classeDAO = new ClasseDAO();
    }

    public ClasseModels ajouterClasse(int idClasse, String niveau) {
        ClasseModels classe = new ClasseModels(idClasse, niveau);
        classeDAO.insertClasse(classe);
        return classe;
    }

    public ArrayList<ClasseModels> getAllClasses() {
        return classeDAO.getAllClasses();
    }

    public void updateClasse(ClasseModels classe) {
        classeDAO.updateClasse(classe);
    }

    public void deleteClasse(int idClasse) {
        classeDAO.deleteClasse(idClasse);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionedt.models;

/**
 *
 * @author diary
 */
public class ClasseModels {
   private int idclass; // Changé de idClasse à idClass pour cohérence (optionnel)
    private String niveau;

    public ClasseModels(int idClass, String niveau) {
        this.idclass = idClass;
        this.niveau = niveau;
    }

    public int getIdclasse() { return idclass; } // Changé getIdClasse en getIdClass
    public String getNiveau() { return niveau; }

    public void setIdClass(int idClass) { this.idclass = idClass; }
    public void setNiveau(String niveau) { this.niveau = niveau; }
}

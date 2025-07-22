/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionedt.models;

/**
 *
 * @author diary
 */
public class salleModels {
   private String idSalle;
    private int design;
    private String occupation;

    public salleModels(String idSalle, int design, String occupation) {
        this.idSalle = idSalle;
        this.design = design;
        this.occupation = occupation;
    }

    public String getIdSalle() { return idSalle; }
    public int getDesign() { return design; }
    public String getOccupation() { return occupation; }

    public void setIdSalle(String idSalle) { this.idSalle = idSalle; }
    public void setDesign(int design) { this.design = design; }
    public void setOccupation(String occupation) { this.occupation = occupation; }
}

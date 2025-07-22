/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionedt.models;

/**
 *
 * @author diary
 */
public class EdtModels {
 
    private String idEDT;
    private int IDSalle;
    private String idProf;
    private String IDClasse;
    private String Cours;
    private java.sql.Timestamp Date;

    public EdtModels(String idEDT, int IDSalle, String idProf, String IDClasse, String Cours, java.sql.Timestamp Date) {
        this.idEDT = idEDT;
        this.IDSalle = IDSalle;
        this.idProf = idProf;
        this.IDClasse = IDClasse;
        this.Cours = Cours;
        this.Date = Date;
    }

    public String getIdEDT() { return idEDT; }
    public int getIDSalle() { return IDSalle; }
    public String getIdProf() { return idProf; }
    public String getIDClasse() { return IDClasse; }
    public String getCours() { return Cours; }
    public java.sql.Timestamp getDate() { return Date; }

    public void setIdEDT(String idEDT) { this.idEDT = idEDT; }
    public void setIDSalle(int IDSalle) { this.IDSalle = IDSalle; }
    public void setIdProf(String idProf) { this.idProf = idProf; }
    public void setIDClasse(String IDClasse) { this.IDClasse = IDClasse; }
    public void setCours(String Cours) { this.Cours = Cours; }
    public void setDate(java.sql.Timestamp Date) { this.Date = Date; }
  }


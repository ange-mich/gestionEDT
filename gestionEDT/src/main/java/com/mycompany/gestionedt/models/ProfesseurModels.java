/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionedt.models;

/**
 *
 * @author diary
 */
public class ProfesseurModels {
     private String idProf;
    private String NomProf;
    private String PrenomProf;
    private String Grade;
    
    public ProfesseurModels  (String idProf, String NomProf, String PrenomProf,String Grade){
        this.idProf = idProf;
        this.NomProf = NomProf;
        this.PrenomProf = PrenomProf;
        this.Grade = Grade;
    }
    
    public ProfesseurModels (String NomProf,String PrenomProf,String Grade){
        this.NomProf = NomProf;
        this.PrenomProf = PrenomProf;
        this.Grade = Grade;
    }
    
    //getters et setters
            
            public String getIdProf(){return idProf;}
            public void setIdProf(String idProf ){this.idProf = idProf;}
            public String getNomProf(){return NomProf;}
            public void setNomProf(String NomProf){this.NomProf = NomProf;}
            public String getPrenomProf(){return PrenomProf;}
            public void setPrenomProf(String PrenomProf){this.PrenomProf = PrenomProf;}
            public String getGrade(){return Grade;}
            public void setGrade(String gradeProf){this.Grade = Grade;}
}

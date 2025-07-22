/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionedt.controllers;

/**
 *
 * @author diary
 */
import com.mycompany.gestionedt.models.EdtDAO;
import com.mycompany.gestionedt.models.EdtModels;
import java.sql.Timestamp;
import java.util.ArrayList;



public class EdtControllers {
   private EdtDAO edtDAO;

    public EdtControllers() {
        this.edtDAO = new EdtDAO();
    }

    public EdtModels ajouterEdt(String idEDT, int IDSalle, String idProf, String IDClasse, String Cours, Timestamp Date) {
        EdtModels edt = new EdtModels(idEDT, IDSalle, idProf, IDClasse, Cours, Date);
        edtDAO.insertEdt(edt);
        return edt;
    }

    public ArrayList<EdtModels> getAllEdts() {
        return edtDAO.getAllEdts();
    }

    public void updateEdt(EdtModels edt) {
        edtDAO.updateEdt(edt);
    }

    public void deleteEdt(String idEDT) {
        edtDAO.deleteEdt(idEDT);
    }

    public ArrayList<Integer> getFreeRooms(Timestamp checkTime) {
        return edtDAO.getFreeRooms(checkTime);
    }
}

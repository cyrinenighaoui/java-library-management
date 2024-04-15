/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.ActionEmploye;

import com.raven.main.LIBRAIRIE;
import com.raven.main.Reclamation;
import com.raven.main.Reservation;
import com.raven.projet_java_s2.emprunt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Vector;
import com.raven.projet_java_s2.employee;

/**
 *
 * @author USER
 */
public class GestionActionEmployee implements Actionemployee{

    @Override
    public Vector<employee> AfficherEmployee() {
         Vector<employee> emp = new Vector<>();
            try {
          String requete = "SELECT * FROM employee";
           Connection connection = LIBRAIRIE.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(requete);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("employee_id"); 
                int cin = resultSet.getInt("cin"); 
                LocalDateTime date_naissance = resultSet.getTimestamp("date_naissance").toLocalDateTime();
               float salaire = resultSet.getInt("salaire"); 
               String prenom = resultSet.getString("prenom"); 
               String nom = resultSet.getString("nom"); 
               employee empl=new employee(id,cin,prenom,nom,date_naissance,salaire);
                emp.add(empl);
              }
         }
          catch (SQLException e) {
             e.printStackTrace();
            // Gérer l'exception SQL
          }
                 return emp; 
    }

    @Override
    public Vector<emprunt> AfficherEmprunt() {      
 Vector<emprunt> emp = new Vector<>();
            try {
          String requete = "SELECT * FROM emprunt";
           Connection connection = LIBRAIRIE.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(requete);
            ResultSet resultSet = preparedStatement.executeQuery();
            LocalDateTime date_debut=null;
            while (resultSet.next()) {
                int id = resultSet.getInt("emprunt_id"); 
                int ouvrage_id = resultSet.getInt("ouvrage_id"); 
                 int abonne_id = resultSet.getInt("abonne_id"); 
                LocalDateTime date_fin_prevu = resultSet.getTimestamp("date_fin_prevu").toLocalDateTime();
                LocalDateTime date_fin_effective = resultSet.getTimestamp("date_fin_effective").toLocalDateTime();
                if(resultSet.getTimestamp("date_debut")!=null)
                { date_debut = resultSet.getTimestamp("date_debut").toLocalDateTime();}
               int retard = resultSet.getInt("retard"); 
               float amende = resultSet.getInt("amende"); 
               String etat = resultSet.getString("etat"); 
               emprunt empr=new emprunt(id,ouvrage_id,abonne_id,date_debut,date_fin_prevu,date_fin_effective,etat,retard,amende);
                emp.add(empr);
              }
         }
          catch (SQLException e) {
             e.printStackTrace();
            // Gérer l'exception SQL
          }
                 return emp; 
    }

    @Override
    public Vector<Reclamation> AfficherReclamation() {
         Vector<Reclamation> emp = new Vector<>();
   try {
          String requete = "SELECT * FROM reclamation";
           Connection connection = LIBRAIRIE.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(requete);
            ResultSet resultSet = preparedStatement.executeQuery();
            LocalDateTime date_debut=null;
            while (resultSet.next()) {
                 int abonne_id = resultSet.getInt("abonne_id"); 
                 boolean tel=resultSet.getBoolean("repondre_tel"); 
                String autre= resultSet.getString("autre"); 
               Reclamation rec=new Reclamation(abonne_id,tel,autre);
                emp.add(rec);
              }
         }
          catch (SQLException e) {
             e.printStackTrace();
            // Gérer l'exception SQL
          }
                 return emp; 
    }
    
    
}

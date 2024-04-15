/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.raven.projet_java_s2;

import java.time.LocalDate;
/**
 *
 * @author saif
 */
import com.raven.Interface_Graphique.Ajouter_abonn;
import com.raven.Interface_Graphique.Consulter_Abonne;
import com.raven.Interface_Graphique.Consulter_Connexion_Employee;
import com.raven.Interface_Graphique.Consulter_Historique;
import com.raven.Interface_Graphique.Consulter_connexion_Abonne;
import com.raven.Interface_Graphique.Delete_Abonn;
import com.raven.Interface_Graphique.Get_All_Users;
import com.raven.Interface_Graphique.Update_Email_Employee;
import com.raven.Interface_Graphique.Update_Abonn;
import com.raven.Interface_Graphique.Update_Adresse_Employee;
import com.raven.Interface_Graphique.Update_Email_Abonne;
import com.raven.Interface_Graphique.Update_Mdp_Employee;
public class Projet_Java_S2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        com.raven.go_db.tools_db.SetConnection("library");
        abonne a = new abonne(0);
        Consulter_Connexion_Employee form1 = new Consulter_Connexion_Employee();
        form1.setVisible(true);
        Consulter_connexion_Abonne form2 = new Consulter_connexion_Abonne();
        form2.setVisible(true);
        Consulter_Abonne form3 = new Consulter_Abonne();
        form3.setVisible(true);
        /*a.setAbonne_id(5);
        a.setCin(112414429);
        a.setDate_debut_abonnement(LocalDate.now());
        a.setDate_fin_abonnement(LocalDate.now().plusDays(30));
        LocalDate date = LocalDate.of(2023,12,2);
        a.setDate_naissance(date);
        a.setNom("Saife");
        a.setPrenom("YeSaif");
        a.setType_abonnement("One Month");*/
        //System.out.println(employee_service.insert_abonne(new abonne()));
    }
    
}

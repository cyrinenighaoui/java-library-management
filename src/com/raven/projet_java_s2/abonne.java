
package com.raven.projet_java_s2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class abonne {
    private int abonne_id;
    private int cin;
    private String prenom;
    private String nom;
    private LocalDate date_naissance;
    private String type_abonnement;
    private LocalDate date_debut_abonnement;
    private LocalDate date_fin_abonnement;

    public abonne(int abonne_id, int cin, String prenom, String nom, LocalDate date_naissance, String type_abonnement, LocalDate date_debut_abonnement, LocalDate date_fin_abonnement) {
        this.abonne_id = abonne_id;
        this.cin = cin;
        this.prenom = prenom;
        this.nom = nom;
        this.date_naissance = date_naissance;
        this.type_abonnement = type_abonnement;
        this.date_debut_abonnement = date_debut_abonnement;
        this.date_fin_abonnement = date_fin_abonnement;
    }
   
    public abonne(int i)
    {
        
    }
    public int getAbonne_id() {
        return abonne_id;
    }

    public void setAbonne_id(int abonne_id) {
        this.abonne_id = abonne_id;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(LocalDate date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getType_abonnement() {
        return type_abonnement;
    }

    public void setType_abonnement(String type_abonnement) {
        this.type_abonnement = type_abonnement;
    }

    public LocalDate getDate_debut_abonnement() {
        return date_debut_abonnement;
    }

    public void setDate_debut_abonnement(LocalDate date_debut_abonnement) {
        this.date_debut_abonnement = date_debut_abonnement;
    }

    public LocalDate getDate_fin_abonnement() {
        return date_fin_abonnement;
    }

    public void setDate_fin_abonnement(LocalDate date_fin_abonnement) {
        this.date_fin_abonnement = date_fin_abonnement;
    }

    @Override
    public String toString() {
        return "abonne{" + "abonne_id=" + abonne_id + ", cin=" + cin + ", prenom=" + prenom + ", nom=" + nom + ", date_naissance=" + date_naissance + ", type_abonnement=" + type_abonnement + ", date_debut_abonnement=" + date_debut_abonnement + ", date_fin_abonnement=" + date_fin_abonnement + '}';
    }
    
    
    
    
}

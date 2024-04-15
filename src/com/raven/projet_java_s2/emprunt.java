/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.projet_java_s2;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class emprunt {
   private int emprunt_id;
   private int ouvrage_id;
   private int abonne_id;
   private LocalDateTime date_debut;
   private LocalDateTime date_fin_prevu;
   private LocalDateTime date_fin_effective;
   private String etat;
   private int retard;
   private float amende;

    public emprunt(int emprunt_id, int ouvrage_id, int abonne_id, LocalDateTime date_debut, LocalDateTime date_fin_prevu, LocalDateTime date_fin_effective, String etat, int retard, float amende) {
        this.emprunt_id = emprunt_id;
        this.ouvrage_id = ouvrage_id;
        this.abonne_id = abonne_id;
        this.date_debut = date_debut;
        this.date_fin_prevu = date_fin_prevu;
        this.date_fin_effective = date_fin_effective;
        this.etat = etat;
        this.retard = retard;
        this.amende = amende;
    }

    public int getEmprunt_id() {
        return emprunt_id;
    }

    public void setEmprunt_id(int emprunt_id) {
        this.emprunt_id = emprunt_id;
    }

    public int getOuvrage_id() {
        return ouvrage_id;
    }

    public void setOuvrage_id(int ouvrage_id) {
        this.ouvrage_id = ouvrage_id;
    }

    public int getAbonne_id() {
        return abonne_id;
    }

    public void setAbonne_id(int abonne_id) {
        this.abonne_id = abonne_id;
    }

    public LocalDateTime getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(LocalDateTime date_debut) {
        this.date_debut = date_debut;
    }

    public LocalDateTime getDate_fin_prevu() {
        return date_fin_prevu;
    }

    public void setDate_fin_prevu(LocalDateTime date_fin_prevu) {
        this.date_fin_prevu = date_fin_prevu;
    }

    public LocalDateTime getDate_fin_effective() {
        return date_fin_effective;
    }

    public void setDate_fin_effective(LocalDateTime date_fin_effective) {
        this.date_fin_effective = date_fin_effective;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getRetard() {
        return retard;
    }

    public void setRetard(int retard) {
        this.retard = retard;
    }

    public float getAmende() {
        return amende;
    }

    public void setAmende(float amende) {
        this.amende = amende;
    }

    @Override
    public String toString() {
        return "emprunt{" + "emprunt_id=" + emprunt_id + ", ouvrage_id=" + ouvrage_id + ", abonne_id=" + abonne_id + ", date_debut=" + date_debut + ", date_fin_prevu=" + date_fin_prevu + ", date_fin_effective=" + date_fin_effective + ", etat=" + etat + ", retard=" + retard + ", amende=" + amende + '}';
    }
   
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.raven.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author USER
 */
public interface Ouvrage_interface {
    //AJOUT OUVRAGE 
     Boolean ajouter_livre(String titre, LocalDate date_pub,String genre,String Langue , double prix, int nbr_page);
     Boolean ajouter_livreAudio(String titre, LocalDate date_pub,String genre,String Langue , double prix,String format , LocalTime duree);
     Boolean ajouter_dictionnaire(String titre, LocalDate date_pub,String genre,String Langue , double prix,int nbr_page,int nbr_mot);
     Boolean ajouter_magazine(String titre, LocalDate date_pub,String genre,String Langue , double prix,int num_magazine, int nbre_page);
     Boolean Signaler_vol(int ouvrage_id) ;
    //SUPPRIMER OUVRAGE
    Boolean supprimer_ouvrage(int id);
    
    
    Boolean modifier_prix_ouvrage(int id,int nouveauPrix);
    
     Ouvrage obtenir_ouvrage_par_id(int id);
     
     
     Ouvrage obtenir_ouvrage_par_titre(String titre);
    Vector<Ouvrage> lister_tous_les_ouvrages();
    Vector<Ouvrage> obtenir_ouvrages_par_auteur(String auteur);
    Vector<Ouvrage> obtenir_ouvrages_par_annee(int annee);
    Vector<Ouvrage> obtenir_ouvrage_par_type(String type);
    Vector<Ouvrage> obtenir_ouvrage_premiere_lettre(String lettre);
    Vector<Ouvrage> obtenir_ouvrage_disponible();
    Vector<Ouvrage> obtenir_ouvrage_par_langue(String langue);
    Vector<Ouvrage> obtenir_ouvrage_par_genre(String genre);
    Vector<Ouvrage> obtenir_ouvrage_recommander(String genre); //selon les commentaires 
    
}

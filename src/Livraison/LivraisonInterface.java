/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Livraison;

import java.util.Vector;

/**
 *
 * @author USER
 */
public interface LivraisonInterface {
    boolean passer_livraison(int abonne_id,int ouvrage_id,String adresse , String intruction,int num);
    Vector<Livraison> obtenir_livraisons();
    boolean supprimer_livraison_livree(int id_livraison);
    int obtenir_id_livraison(int abonne_id,int ouvrage_id);
    boolean ajouter_declaration(Declaration d);
    boolean id_abonne_existe(int abonne_id);
    int calculer_nbre_reservation();
}

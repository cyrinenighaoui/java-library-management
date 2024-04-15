/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.raven.reservation;

import java.time.LocalDate;
import java.util.Vector;
import com.raven.main.Ouvrage;
import java.time.LocalDateTime;

/**
 *
 * @author USER
 */
public interface Emprunt {
    
    boolean enregistrerEmprunt(int ouvrageId, int abonneId, LocalDate dateFinPrevu);
    boolean recupererLivreReserve(int ouvrageId, int abonneId);
    boolean enregistrerRetour(int ouvrageId, int abonneId);  //on notifie si reservatio,
    boolean prolongerEmprunt();
    Vector<Integer>notifierRetard(int abonneId);
    int calculerAmende();
    boolean ajoutHistoriqueEmprunt();
}

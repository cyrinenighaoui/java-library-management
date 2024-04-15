/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.raven.reservation;

import com.raven.main.Ouvrage;
import java.time.LocalDateTime;
import java.util.Vector;
import com.raven.main.Reservation;


/**
 *
 * @author USER
 */
public interface ActionAbonne {
      Vector<Ouvrage> AfficherOuvrageARerserver() ;
      Vector<Reservation> AfficherToutesReservation() ;

      LocalDateTime reserverOuvrage(int id_abonne, int id_ouvrage) ;
      boolean annulerReservation(int id_abonne, int id_ouvrage) ;
      Vector<Reservation> afficherReservationsUtilisateur(int id) ;
      Vector<Integer> NotificationReservationAnnulePourRetard(int id_abonne) ;
      Vector<Integer> NotificationReservationRetardRes(int id_abonne) ;
      
}

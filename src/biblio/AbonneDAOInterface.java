/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package biblio;

import java.time.LocalDateTime;
import java.util.Vector;

/**
 *
 * @author pc
 */
public interface AbonneDAOInterface {
    String emprunter(Emprunt e);
    String retourner(Emprunt e);
    String prolonger(Emprunt e);
    Vector<Ouvrage> getAllOuvragesRecommendés(int id);
    Emprunt getEmprunt(int id);
    Vector<Emprunt> getAllMesEmpruntsActuels(int id);
    Vector<Emprunt> getAllMesEmpruntsRetardés(int id);
    Vector<Emprunt> getAllMonHistoriqueEmprunts(int id);
    //Vector<Reservation> getAllMesReservations(int id);
    Vector<Ouvrage> getAllOuvragesByTitle_part(String ch);
    Vector<Ouvrage> getAllOuvragesByMots_clés(String ch);
    //boolean reserver(Ouvrage o);
    boolean commenter(Commentaire c);
    boolean modifier_commentaire(Commentaire c);
    boolean supprimer_commentaire(int id);
    Commentaire getCommentaire(int id);
    
    
    Vector<Commentaire> getAllCommentaires();
    Vector<Commentaire> getAllCommentairesByTitle(String titre);
    Vector<Commentaire> getAllMesCommentaires(int id);
    Vector<Commentaire> getAllCommentairesOuvrages(int id);
    
    
    void update_emprunts();
    void update_rate(Ouvrage o);
    
    LocalDateTime reserverOuvrage(int id_abonne, int id_ouvrage);
     Vector<Reservation1> afficherReservationsUtilisateur(int abonne_id) ;
     boolean recupererLivreReserve(int ouvrageId, int abonneId) ;
     Vector<Ouvrage> AfficherOuvrageARerserver();
      Vector<Integer> NotificationReservationAnnulePourRetard(int id_abonne);
      Vector<Integer> NotificationReservationRetardRes(int id_abonne ) ;
           Ouvrage obtenir_ouvrage_par_id(int id);

}


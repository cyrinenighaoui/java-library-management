/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.reservation;

import com.raven.main.Dictionnaire;
import com.raven.main.LIBRAIRIE;
import com.raven.main.Livre;
import com.raven.main.LivreAudio;
import com.raven.main.Magazine;
import com.raven.main.Reservation;
import java.security.Timestamp;
import java.util.Vector;
import com.raven.main.Ouvrage;
   import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Collections;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class GererActionabonne1 implements ActionAbonne {
    
    
public void updatetable() {
    try (Connection connection = LIBRAIRIE.getConnection()) {
        LocalDate dateLimite = LocalDate.now();
        
        // Sélectionner tous les emprunts dont la date de retour prévue est après la date limite, sans retard, et qui sont retournés
   String queryEmprunt = "SELECT ouvrage_id FROM emprunt " +
                      "WHERE DATE_ADD(date_fin_effective, INTERVAL 4 DAY) < ? AND etat = 'retourne'";
        try (PreparedStatement preparedStatementEmprunt = connection.prepareStatement(queryEmprunt)) {
            preparedStatementEmprunt.setDate(1, java.sql.Date.valueOf(dateLimite));
            ResultSet emprunts = preparedStatementEmprunt.executeQuery();
            while (emprunts.next()) {
                int idOuvrage = emprunts.getInt("ouvrage_id");
                // Mise à jour de l'état des réservations correspondantes à 'annule'
                String updateReserve = "UPDATE ouvrage_reserve SET etat = 'annule', date_reservation=? " +
                                       "WHERE ouvrage_id = ? AND ordre_attente=0";
                // Mise à jour de l'état des réservations correspondantes à 'annule'
                String updateReserve1 = "UPDATE ouvrage_reserve SET etat = 'attribué' " +
                                       "WHERE ouvrage_id = ? AND ordre_attente=0 AND etat!='annule'";
                try (PreparedStatement preparedStatementReserve = connection.prepareStatement(updateReserve)) {
                    preparedStatementReserve.setInt(2, idOuvrage);
                       LocalDate today = LocalDate.now();
                     preparedStatementReserve.setDate(1, java.sql.Date.valueOf(today));
                    int rowsAffected = preparedStatementReserve.executeUpdate();
                    System.out.println("ici"+rowsAffected);
                    // Si des réservations ont été annulées, décrémenter l'ordre d'attente pour les autres réservations de cet ouvrage
                    if (rowsAffected > 0) {
                        String decrementOrder = "UPDATE ouvrage_reserve SET ordre_attente = ordre_attente - 1 " +
                                                "WHERE ouvrage_id = ? AND etat != 'annule'";
                        try (PreparedStatement preparedStatementDecrement = connection.prepareStatement(decrementOrder)) {
                            preparedStatementDecrement.setInt(1, idOuvrage);
                            preparedStatementDecrement.executeUpdate();
                        }
                         try (PreparedStatement preparedStatementDecrement1 = connection.prepareStatement(updateReserve1)) {
                            preparedStatementDecrement1.setInt(1, idOuvrage);
                            preparedStatementDecrement1.executeUpdate();
                        }
                        // Vérifier s'il reste des réservations actives pour cet ouvrage
                        String checkReservations = "SELECT COUNT(*) AS active_reservations FROM ouvrage_reserve " +
                                                   "WHERE ouvrage_id = ? AND etat != 'annule'";
                        try (PreparedStatement preparedStatementCheck = connection.prepareStatement(checkReservations)) {
                            preparedStatementCheck.setInt(1, idOuvrage);
                            ResultSet resultSet = preparedStatementCheck.executeQuery();
                            if (resultSet.next() && resultSet.getInt("active_reservations") == 0) {
                                // Mettre à jour l'état de l'ouvrage en 'non reserve' si aucune réservation active n'est trouvée
                                String updateOuvrage = "UPDATE ouvrages SET etat = 'non reserve' WHERE ouvrage_id = ?";
                                try (PreparedStatement preparedStatementUpdateOuvrage = connection.prepareStatement(updateOuvrage)) {
                                    preparedStatementUpdateOuvrage.setInt(1, idOuvrage);
                                    preparedStatementUpdateOuvrage.executeUpdate();
                                }
                            }
                        }
                    }
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

@Override
public Vector<Ouvrage> AfficherOuvrageARerserver() {
    Vector<Ouvrage> ouvrages = new Vector<>();       
    try (Connection connection = LIBRAIRIE.getConnection();
         PreparedStatement preparedStatementSelectionOuvrages = connection.prepareStatement("SELECT * FROM ouvrages WHERE disponibilite = false  ");
         ResultSet resultSet = preparedStatementSelectionOuvrages.executeQuery()) {
        updatetable();
        while (resultSet.next()) {
            String typeOuvrage = resultSet.getString("type_ouvrage");
            int ouvrageId = resultSet.getInt("ouvrage_id");
            String titre = resultSet.getString("titre_ouvrage");
            LocalDateTime datePublication = resultSet.getTimestamp("date_publication").toLocalDateTime();
            double prix = resultSet.getDouble("prix");
            String genre = resultSet.getString("genre");
            boolean disponibilite = resultSet.getBoolean("disponibilite");
            String langue = resultSet.getString("langue");
            Ouvrage ouvrage = null;
            switch (typeOuvrage) {
                case "Livre":
                    int nbrePageLivre = resultSet.getInt("nbre_page");
                    ouvrage = new Livre(nbrePageLivre, ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                    break;
                case "Magazine":
                    int num_magazine = resultSet.getInt("num_magazine");
                    int nbrePageMagazine = resultSet.getInt("nbre_page");
                    ouvrage = new Magazine(num_magazine, nbrePageMagazine, ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                    break;
                case "Dictionnaire":
                    int nbrePageDictionnaire = resultSet.getInt("nbre_page");
                    int nbre_mots = resultSet.getInt("nbre_mots");
                    ouvrage = new Dictionnaire(nbre_mots, nbrePageDictionnaire, ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                    break;
                case "LivreAudio":
                    String format = resultSet.getString("format");
                    Date duree = resultSet.getDate("duree");
                    ouvrage = new LivreAudio(format, duree, ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                    break;
                default:
                    throw new IllegalArgumentException("Type d'ouvrage inconnu: " + typeOuvrage);
            }

            if (ouvrage != null) {
                ouvrages.add(ouvrage);
            }
        }
    } catch (SQLException | IllegalArgumentException e) {
        e.printStackTrace();
    }

    return ouvrages;
}
@Override
public LocalDateTime reserverOuvrage(int id_abonne, int id_ouvrage) {
    updatetable();
    LocalDateTime date_retour = null;
    try {
        Connection connection = LIBRAIRIE.getConnection();
        // Sélectionner les détails de l'ouvrage
        String requete = "SELECT * FROM ouvrages WHERE ouvrage_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        preparedStatement.setInt(1, id_ouvrage);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println("Livre réservé. Dès qu'il sera prêt, nous vous enverrons une notification : ");
            String requete1 = "SELECT * FROM emprunt WHERE ouvrage_id = ?";
            PreparedStatement preparedStatement1 = connection.prepareStatement(requete1);
            preparedStatement1.setInt(1,id_ouvrage);
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            if (resultSet1.next()) {
               System.out.println("Livre réservé. Dès qu'il sera prêt, nous vous enverrons une notification : ");
                date_retour = resultSet1.getTimestamp("date_fin_effective").toLocalDateTime();
                // Calculer l'ordre d'attente
               String requeteOrdre = "SELECT o.ordre_attente AS max_ordre, o.date_reservation AS res " +
                "FROM ouvrage_reserve o " +
                "INNER JOIN ( " +
                "    SELECT MAX(ordre_attente) AS max_ordre " +
                "    FROM ouvrage_reserve " +
                "    WHERE ouvrage_id = ? AND etat = 'RESERVE' " +
                ") mo ON o.ordre_attente = mo.max_ordre AND o.ouvrage_id = ? AND o.etat = 'RESERVE'";
                PreparedStatement preparedStatementOrdre = connection.prepareStatement(requeteOrdre);
                preparedStatementOrdre.setInt(1, id_ouvrage);
                preparedStatementOrdre.setInt(2, id_ouvrage);
                ResultSet resultSetOrdre = preparedStatementOrdre.executeQuery();
                int ordreAttente = 1;
                if (resultSetOrdre.next() && resultSetOrdre.getInt("max_ordre") != 0) {
                    ordreAttente = resultSetOrdre.getInt("max_ordre") + 1;
                    System.out.println(ordreAttente);
                    date_retour = resultSetOrdre.getTimestamp("res").toLocalDateTime().plusDays(30);
                    System.out.println(date_retour);
                }

                String requete2 = "INSERT INTO ouvrage_reserve (ouvrage_id, abonne_id, date_reservation, ordre_attente,etat) VALUES (?, ?, ?, ?,?)";
                PreparedStatement preparedStatement2 = connection.prepareStatement(requete2);
                preparedStatement2.setInt(1, id_ouvrage);
                preparedStatement2.setInt(2, id_abonne);
                preparedStatement2.setObject(3, date_retour);
                preparedStatement2.setInt(4, ordreAttente);
                   preparedStatement2.setString(5, "RESERVE");

                preparedStatement2.executeUpdate();
                preparedStatement2.close();
                String requeteMiseAJour = "UPDATE ouvrages SET etat =? WHERE ouvrage_id = ?";
                PreparedStatement preparedStatementMiseAJour = connection.prepareStatement(requeteMiseAJour);
                preparedStatementMiseAJour.setString(1,"reserve");
                preparedStatementMiseAJour.setInt(2, id_ouvrage);
                preparedStatementMiseAJour.executeUpdate();
                preparedStatementMiseAJour.close();
            }
            resultSet1.close();
            preparedStatement1.close();
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return date_retour;
}

@Override
public boolean annulerReservation(int id_abonne, int id_ouvrage) {
    try {
        Connection connection = LIBRAIRIE.getConnection();
        updatetable();
        int count=1 ;
        String requete1 = "SELECT count(ouvrage_id) AS reservation_count FROM ouvrage_reserve WHERE ouvrage_id = ?";
        PreparedStatement preparedStatement1 = connection.prepareStatement(requete1);
        preparedStatement1.setInt(1, id_ouvrage);
        ResultSet resultSet1 = preparedStatement1.executeQuery();
        if (resultSet1.next()) {
             count = resultSet1.getInt("reservation_count");
        }
        String requeteOrdreAttente = "SELECT ordre_attente FROM ouvrage_reserve WHERE ouvrage_id = ? AND abonne_id = ?";
        PreparedStatement preparedStatementOrdreAttente = connection.prepareStatement(requeteOrdreAttente);
        preparedStatementOrdreAttente.setInt(1, id_ouvrage);
        preparedStatementOrdreAttente.setInt(2, id_abonne);
        ResultSet resultSet = preparedStatementOrdreAttente.executeQuery();
        int ordreAttenteActuel = 0;
        if (resultSet.next()) {
            ordreAttenteActuel = resultSet.getInt("ordre_attente");
        }
        String requeteMiseAJourOrdre = "UPDATE ouvrage_reserve SET ordre_attente = ordre_attente - 1 WHERE ouvrage_id = ? AND ordre_attente > ?";
        PreparedStatement preparedStatementMiseAJourOrdre = connection.prepareStatement(requeteMiseAJourOrdre);
        preparedStatementMiseAJourOrdre.setInt(1, id_ouvrage);
        preparedStatementMiseAJourOrdre.setInt(2, ordreAttenteActuel);
        preparedStatementMiseAJourOrdre.executeUpdate();
        preparedStatementMiseAJourOrdre.close();
        if (count ==1)
        {       
        String requeteMiseAJourEtat = "UPDATE ouvrages SET etat = 'non reserve' WHERE ouvrage_id = ?";
        PreparedStatement preparedStatementMiseAJourEtat = connection.prepareStatement(requeteMiseAJourEtat);
        preparedStatementMiseAJourEtat.setInt(1, id_ouvrage);
        preparedStatementMiseAJourEtat.executeUpdate();
        preparedStatementMiseAJourEtat.close();
         }
        // Supprimer la réservation de l'abonné actuel
        String requeteSuppression = "DELETE FROM ouvrage_reserve WHERE ouvrage_id = ? AND abonne_id = ?";
        PreparedStatement preparedStatementSuppression = connection.prepareStatement(requeteSuppression);
        preparedStatementSuppression.setInt(1, id_ouvrage);
        preparedStatementSuppression.setInt(2, id_abonne);
        int rowCount = preparedStatementSuppression.executeUpdate();
        preparedStatementSuppression.close();
        
        connection.close();
                    updatetable();

        return rowCount >= 1;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }

}

    @Override
    public Vector<Reservation> afficherReservationsUtilisateur(int abonne_id) {
              updatetable();
        Vector<Reservation> reservations = new Vector<>();
        PreparedStatement stmt = null;
              ResultSet rs = null;
        
        try {
             Connection conn = LIBRAIRIE.getConnection();
           
            String query = "SELECT * FROM ouvrage_reserve WHERE abonne_id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, abonne_id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int ouvrageId = rs.getInt("ouvrage_id");
                LocalDateTime dateReservation = rs.getTimestamp("date_reservation").toLocalDateTime();
                int ordreAttente = rs.getInt("ordre_attente");
                String etat = rs.getString("etat");
                // Créez un objet OuvrageReservation pour chaque ligne de résultat
                Reservation reservation = new Reservation(ouvrageId, abonne_id, dateReservation, ordreAttente, etat);
                reservations.add(reservation);
            }
        } catch (SQLException ex) {
        Logger.getLogger(GererActionabonne1.class.getName()).log(Level.SEVERE, null, ex);
    } 
        
        
        return reservations;
    }

      public Vector<Reservation> afficherReservationsUtilisateurPourAnnule(int abonne_id) {
              updatetable();
        Vector<Reservation> reservations = new Vector<>();
        PreparedStatement stmt = null;
              ResultSet rs = null;
        
        try {
             Connection conn = LIBRAIRIE.getConnection();
           
            String query = "SELECT * FROM ouvrage_reserve WHERE abonne_id = ? and etat!='atrribué' and etat!='annule'";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, abonne_id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int ouvrageId = rs.getInt("ouvrage_id");
                LocalDateTime dateReservation = rs.getTimestamp("date_reservation").toLocalDateTime();
                int ordreAttente = rs.getInt("ordre_attente");
                String etat = rs.getString("etat");
                // Créez un objet OuvrageReservation pour chaque ligne de résultat
                Reservation reservation = new Reservation(ouvrageId, abonne_id, dateReservation, ordreAttente, etat);
                reservations.add(reservation);
            }
        } catch (SQLException ex) {
        Logger.getLogger(GererActionabonne1.class.getName()).log(Level.SEVERE, null, ex);
    } 
        
        
        return reservations;
    }
 @Override
public Vector<Integer> NotificationReservationAnnulePourRetard(int id_abonne) {
    updatetable();
    Vector<Integer> ouvragesAnnules = new Vector<>();
    try (Connection connection = LIBRAIRIE.getConnection()) {
        String selectQuery = "SELECT ouvrage_id FROM ouvrage_reserve WHERE abonne_id = ? AND etat = 'annule'";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setInt(1, id_abonne);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int ouvrageId = resultSet.getInt("ouvrage_id");
                    ouvragesAnnules.add(ouvrageId);
                }
            }
        }
        String deleteQuery = "DELETE FROM ouvrage_reserve WHERE abonne_id = ? AND etat = 'annule'";
        try (PreparedStatement preparedStatement1 = connection.prepareStatement(deleteQuery)) {
            preparedStatement1.setInt(1, id_abonne);
            preparedStatement1.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
       
    }
    return ouvragesAnnules;
}
    public Vector<Integer> NotificationReservationRetardRes(int id_abonne ) 
    {
        //ken date reservation tfout el date lyoum et , retard>0 doc nkouloulou eli el kteb amel retard desole 
        Vector<Integer> retardouvrage = new Vector<>();
            try {
          String requete = "SELECT * FROM ouvrage_reserve WHERE abonne_id = ? ";
           Connection connection = LIBRAIRIE.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(requete);
            preparedStatement.setInt(1, id_abonne);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int ouvrageId = resultSet.getInt("ouvrage_id"); 
                String etat= resultSet.getString("etat"); 
                LocalDateTime date_res = resultSet.getTimestamp("date_reservation").toLocalDateTime();
                if (date_res.isAfter(LocalDateTime.now()) && !"annule".equals(etat)) 
                {
                       retardouvrage.add(ouvrageId);
                       String requete2 = "UPDATE ouvrage_reserve  set etat='retarde'  WHERE abonne_id = ? and ouvrage_id=? ";
                         PreparedStatement preparedStatement2 = connection.prepareStatement(requete2);
                         preparedStatement2.setInt(1, id_abonne);
                        preparedStatement2.setInt(2, ouvrageId);
                        int rowsAffected = preparedStatement2.executeUpdate();
                    //nbadlou etat iwali retarde +nzidou id lel liste 
                }
                    retardouvrage.add(ouvrageId);
              }
         }
          catch (SQLException e) {
             e.printStackTrace();
            // Gérer l'exception SQL
          }
                 return retardouvrage;
    }

    @Override
    public Vector<Reservation> AfficherToutesReservation() {
        Vector<Reservation> res = new Vector<>();
            try {
          String requete = "SELECT * FROM ouvrage_reserve";
           Connection connection = LIBRAIRIE.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(requete);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int ouvrageId = resultSet.getInt("ouvrage_id"); 
                int abonne_id = resultSet.getInt("abonne_id"); 
                LocalDateTime date_res = resultSet.getTimestamp("date_reservation").toLocalDateTime();
               int ordre = resultSet.getInt("ordre_attente"); 
               String etat = resultSet.getString("etat"); 
               Reservation rese=new Reservation(ouvrageId,abonne_id,date_res,ordre,etat);
                    res.add(rese);
              }
         }
          catch (SQLException e) {
             e.printStackTrace();
            // Gérer l'exception SQL
          }
                 return res;        
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.reservation;

import com.raven.main.LIBRAIRIE;
import java.time.LocalDate;
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
import java.time.temporal.Temporal;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Collections;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author USER
 */
public class Emprunts implements Emprunt{
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
                String updateReserve = "UPDATE ouvrage_reserve SET etat = 'annule' ,date_reservation=?" +
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
public boolean enregistrerEmprunt(int ouvrageId, int abonneId,  LocalDate datedeb) {
    updatetable();
    // Vérifier si l'ouvrage est disponible pour l'emprunt
    String queryCheckDispo = "SELECT disponibilite FROM ouvrages WHERE ouvrage_id = ?";
    // Préparer la requête pour enregistrer l'emprunt
String queryEmprunt = "INSERT INTO emprunt (ouvrage_id, abonne_id, date_fin_prevu, etat, date_fin_effective, date_debut) VALUES (?, ?, ?, ?, ?, ?)";
    try (Connection connection = LIBRAIRIE.getConnection();
         PreparedStatement checkDispoStmt = connection.prepareStatement(queryCheckDispo);
         PreparedStatement empruntStmt = connection.prepareStatement(queryEmprunt)) 
    {
        // Vérifier la disponibilité
        checkDispoStmt.setInt(1, ouvrageId);
        ResultSet rs = checkDispoStmt.executeQuery();
        if (rs.next() && rs.getBoolean("disponibilite")) {
            empruntStmt.setInt(1, ouvrageId);
            empruntStmt.setInt(2, abonneId);
            empruntStmt.setDate(3, java.sql.Date.valueOf(datedeb.plusDays(30)));
            empruntStmt.setString(4, "en cours");
            empruntStmt.setDate(5, java.sql.Date.valueOf(datedeb.plusDays(30)));
            empruntStmt.setDate(6, java.sql.Date.valueOf(datedeb));
            int affectedRows = empruntStmt.executeUpdate();
            if (affectedRows > 0) {
                String queryUpdateDispo = "UPDATE ouvrages SET disponibilite = ? WHERE ouvrage_id = ?";
                try (PreparedStatement updateDispoStmt = connection.prepareStatement(queryUpdateDispo)) {
                    updateDispoStmt.setInt(2, ouvrageId);
                     updateDispoStmt.setBoolean(1, false);

                    updateDispoStmt.executeUpdate();
                }
                return true; 
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

@Override
public boolean enregistrerRetour(int ouvrageId, int abonneId) {
        updatetable();

    LocalDate dateRetour = LocalDate.now();
    String queryFindEmprunt = "SELECT * FROM emprunt WHERE ouvrage_id = ? AND abonne_id = ? AND etat = 'en cours'";
    String queryUpdateEmprunt = "UPDATE emprunt SET date_fin_effective = ?, etat = 'retourne' WHERE ouvrage_id = ? AND abonne_id = ?";
    String queryCheckReservation = "SELECT * FROM ouvrage_reserve WHERE ouvrage_id = ? ORDER BY ordre_attente ASC";
    String queryUpdateDispo = "UPDATE ouvrages SET disponibilite = true WHERE ouvrage_id = ?";
    String queryDecrementOrdre = "UPDATE ouvrage_reserve SET ordre_attente = ordre_attente - 1 WHERE ouvrage_id = ?";
    String queryUpdateReservationStatus = "UPDATE ouvrage_reserve SET etat = 'attribué' WHERE ouvrage_id = ? AND ordre_attente = 0";
    try (Connection connection = LIBRAIRIE.getConnection();
         PreparedStatement findEmpruntStmt = connection.prepareStatement(queryFindEmprunt);
         PreparedStatement updateEmpruntStmt = connection.prepareStatement(queryUpdateEmprunt);
         PreparedStatement checkReservationStmt = connection.prepareStatement(queryCheckReservation);
         PreparedStatement updateDispoStmt = connection.prepareStatement(queryUpdateDispo);
         PreparedStatement decrementOrdreStmt = connection.prepareStatement(queryDecrementOrdre);
         PreparedStatement updateReservationStatusStmt = connection.prepareStatement(queryUpdateReservationStatus)) {
        findEmpruntStmt.setInt(1, ouvrageId);
        findEmpruntStmt.setInt(2, abonneId);
        ResultSet rsEmprunt = findEmpruntStmt.executeQuery();
        if (rsEmprunt.next()) {
            updateEmpruntStmt.setDate(1, java.sql.Date.valueOf(dateRetour));
            updateEmpruntStmt.setInt(2, ouvrageId);
            updateEmpruntStmt.setInt(3, abonneId);
            int affectedRowsEmprunt = updateEmpruntStmt.executeUpdate();
            if (affectedRowsEmprunt > 0) {
                checkReservationStmt.setInt(1, ouvrageId);
                ResultSet rsReservation = checkReservationStmt.executeQuery();
                if (rsReservation.next()) {
                    decrementOrdreStmt.setInt(1, ouvrageId);
                    decrementOrdreStmt.executeUpdate();
                    updateReservationStatusStmt.setInt(1, ouvrageId);
                    updateReservationStatusStmt.executeUpdate();
                } else {
                    // Aucune réservation, mettre à jour la disponibilité de l'ouvrage
                    updateDispoStmt.setInt(1, ouvrageId);
                    updateDispoStmt.executeUpdate();
                }
                return true; // Le retour et la gestion des réservations ont été traités avec succès
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false; 
}

    @Override
    public boolean prolongerEmprunt() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

@Override
public Vector<Integer> notifierRetard(int abonneId) {
        updatetable();

    Vector<Integer> livresEnRetard = new Vector<>();
    // Correction de la syntaxe dans la requête (enlève "frome" pour "FROM")
    String query = "SELECT ouvrage_id, date_fin_prevu FROM emprunts WHERE abonne_id = ? AND date_fin_prevu < ? AND etat != 'retourne'";
    
    String updateRetard = "UPDATE emprunts SET retard = ? WHERE ouvrage_id = ? AND abonne_id = ?";

    try (Connection connection = LIBRAIRIE.getConnection();
         PreparedStatement stmt = connection.prepareStatement(query);
         PreparedStatement updateStmt = connection.prepareStatement(updateRetard)) {

        stmt.setInt(1, abonneId);
        stmt.setDate(2, java.sql.Date.valueOf(LocalDate.now()));

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            int ouvrageId = rs.getInt("ouvrage_id");
            Date dateFinPrevu = rs.getDate("date_fin_prevu");
            long joursDeRetard = java.time.temporal.ChronoUnit.DAYS.between((Temporal) dateFinPrevu, LocalDate.now());
            updateStmt.setLong(1, joursDeRetard);
            updateStmt.setInt(2, ouvrageId);
            updateStmt.setInt(3, abonneId);
            updateStmt.executeUpdate();
            livresEnRetard.add(ouvrageId);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Gérer l'exception
    }
    return livresEnRetard;
}


    @Override
    public int calculerAmende() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean ajoutHistoriqueEmprunt() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
@Override
public boolean recupererLivreReserve(int ouvrageId, int abonneId) {
    updatetable();
    String queryCheckReserve = "SELECT ordre_attente FROM ouvrage_reserve WHERE ouvrage_id = ? AND abonne_id = ? AND etat = 'attribué'";
    String queryDeleteReserve = "DELETE FROM ouvrage_reserve WHERE ouvrage_id = ? AND abonne_id = ?";
    String inserer = "INSERT INTO emprunt (ouvrage_id, abonne_id, date_debut, date_fin_prevu,date_fin_effective, etat) VALUES (?, ?, ?,?,?, 'en cours')";
    try (Connection connection = LIBRAIRIE.getConnection();
         PreparedStatement checkReserveStmt = connection.prepareStatement(queryCheckReserve);
         PreparedStatement deleteReserveStmt = connection.prepareStatement(queryDeleteReserve);
         PreparedStatement insertionStmt = connection.prepareStatement(inserer)) {
        
        // Vérification de la réservation
        checkReserveStmt.setInt(1, ouvrageId);
        checkReserveStmt.setInt(2, abonneId);
        ResultSet rs = checkReserveStmt.executeQuery();
        if (rs.next()) {
            int ordreAttente = rs.getInt("ordre_attente");
            
            // Insertion dans emprunt
            LocalDate today = LocalDate.now();
            LocalDate dateFinPrevu = today.plusWeeks(4); // Exemple : 4 semaines plus tard
            insertionStmt.setInt(1, ouvrageId);
            insertionStmt.setInt(2, abonneId);
            insertionStmt.setDate(3, java.sql.Date.valueOf(today));
            insertionStmt.setDate(4, java.sql.Date.valueOf(dateFinPrevu));
            insertionStmt.setDate(5, java.sql.Date.valueOf(dateFinPrevu));
            insertionStmt.executeUpdate();
            // Suppression de la réservation
            deleteReserveStmt.setInt(1, ouvrageId);
            deleteReserveStmt.setInt(2, abonneId);
            int affectedRows = deleteReserveStmt.executeUpdate();
        }
    } catch (SQLException e)
    {
        e.printStackTrace();
        // Gérer l'exception
    }
    return false; // La récupération de la réservation a échoué
}

}

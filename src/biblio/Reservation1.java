/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblio;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author USER
 */
public class Reservation1 {
    private int ouvrage_id;
    private int abonne_id;
    private LocalDateTime date_reservation;
    private int ordre_attente;
    private String etat;

    public Reservation1(int ouvrage_id, int abonne_id, LocalDateTime date_reservation, int ordre_attente, String etat) {
        this.ouvrage_id = ouvrage_id;
        this.abonne_id = abonne_id;
        this.date_reservation = date_reservation;
        this.ordre_attente = ordre_attente;
        this.etat = etat;
    }

    public int getOuvrage_id() {
        return ouvrage_id;
    }

    public int getAbonne_id() {
        return abonne_id;
    }

    public LocalDateTime getDate_reservation() {
        return date_reservation;
    }

    public int getOrdre_attente() {
        return ordre_attente;
    }

    public String getEtat() {
        return etat;
    }

    public void setOuvrage_id(int ouvrage_id) {
        this.ouvrage_id = ouvrage_id;
    }

    public void setAbonne_id(int abonne_id) {
        this.abonne_id = abonne_id;
    }

    public void setDate_reservation(LocalDateTime date_reservation) {
        this.date_reservation = date_reservation;
    }

    public void setOrdre_attente(int ordre_attente) {
        this.ordre_attente = ordre_attente;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Livraison;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author USER
 */
public class Livraison {
    private int livraison_id;
    private int abonne_id;
    private int ouvrage_id;
    private Date date_reservation;
    private String adresse;
    private String intruction;
    private int num;

    public Livraison( int abonne_id , int ouvrage_id , Date date_reservation, String adresse, String intruction ,int num) {
        this.abonne_id = abonne_id;
        this.ouvrage_id = ouvrage_id;
        this.date_reservation = date_reservation;
        this.adresse = adresse;
        this.intruction = intruction;
            this.num = num;


    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public String getIntruction() {
        return intruction;
    }

    public void setIntruction(String intruction) {
        this.intruction = intruction;
    }

    

    public void setLivraison_id(int livraison_id) {
        this.livraison_id = livraison_id;
    }

    public void setAbonne_id(int abonne_id) {
        this.abonne_id = abonne_id;
    }

    public void setOuvrage_id(int ouvrage_id) {
        this.ouvrage_id = ouvrage_id;
    }

    public void setDate_reservation(Date date_reservation) {
        this.date_reservation = date_reservation;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getLivraison_id() {
        return livraison_id;
    }

    public int getAbonne_id() {
        return abonne_id;
    }

    public int getOuvrage_id() {
        return ouvrage_id;
    }

    public Date getDate_reservation() {
        return date_reservation;
    }

    public String getAdresse() {
        return adresse;
    }
    
    
}

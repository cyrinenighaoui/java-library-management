/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.projet_java_s2;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author USER
 */
public class Blacklist {
    private int abonne_id;
    private Date date;
    private int ouvrage_id ;

    public int getAbonne_id() {
        return abonne_id;
    }

    public void setAbonne_id(int abonne_id) {
        this.abonne_id = abonne_id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setOuvrage_id(int ouvrage_id) {
        this.ouvrage_id = ouvrage_id;
    }

    public Date getDate() {
        return date;
    }

    public int getOuvrage_id() {
        return ouvrage_id;
    }

    public Blacklist(int abonne_id, Date date, int ouvrage_id) {
        this.abonne_id = abonne_id;
        this.date = date;
        this.ouvrage_id = ouvrage_id;
    }

    
     
    
}

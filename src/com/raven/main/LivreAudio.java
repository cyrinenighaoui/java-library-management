/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.main;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author USER
 */
public class LivreAudio extends Ouvrage  {
    
    protected String format;
    protected Date duree;

    public LivreAudio(String format, Date duree, int id, String title, LocalDateTime date_publication, double prix, String genre, boolean disponibilite, String langue) {
        super(id, title, date_publication, prix, genre, disponibilite, langue);
        this.format = format;
        this.duree = duree;
    }
    
}

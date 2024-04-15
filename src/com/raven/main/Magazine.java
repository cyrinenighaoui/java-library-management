/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.main;

import java.time.LocalDateTime;

/**
 *
 * @author USER
 */
public class Magazine extends Ouvrage{
    protected int num_magazine;
    protected int nbre_page;

    public Magazine(int num_magazine, int nbre_page, int id, String title, LocalDateTime date_publication, double prix, String genre, boolean disponibilite, String langue) {
        super(id, title, date_publication, prix, genre, disponibilite, langue);
        this.num_magazine = num_magazine;
        this.nbre_page = nbre_page;
    }
    
    
}

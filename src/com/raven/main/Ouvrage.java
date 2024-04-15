/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.main;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author USER
 */

public abstract  class Ouvrage {
    private int id;
    private String title;
    private LocalDateTime date_publication;
    private double prix;
    private String genre;
    private boolean disponibilite;
    private String langue;
    
    public Ouvrage(int id, String title, LocalDateTime date_publication, double prix, String genre, boolean disponibilite, String langue) {
        this.id = id;
        this.title = title;
        this.date_publication = date_publication;
        this.prix = prix;
        this.genre = genre;
        this.disponibilite = disponibilite;
        this.langue = langue;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate_publication(LocalDateTime date_publication) {
        this.date_publication = date_publication;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDisponibilite(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getDate_publication() {
        return date_publication;
    }

    public double getPrix() {
        return prix;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isDisponibilite() {
        return disponibilite;
    }

    public String getLangue() {
        return langue;
    }
    
       
}

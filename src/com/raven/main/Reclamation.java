/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.main;

/**
 *
 * @author USER
 */
public class Reclamation {
    private int abonne_id;
        private boolean tel;
        private String autre;

    public Reclamation(int abonne_id, boolean tel, String autre) {
        this.abonne_id = abonne_id;
        this.tel = tel;
        this.autre = autre;
    }

    public void setAbonne_id(int abonne_id) {
        this.abonne_id = abonne_id;
    }

    public void setTel(boolean tel) {
        this.tel = tel;
    }

    public void setAutre(String autre) {
        this.autre = autre;
    }

    public int getAbonne_id() {
        return abonne_id;
    }

    public boolean isTel() {
        return tel;
    }

    public String getAutre() {
        return autre;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Livraison;

/**
 *
 * @author USER
 */
public class Declaration {
    private int id_declaration;
    private int abonne_id;
    private boolean repondre_tel;
    private String autre;

   
      public Declaration( int abonne_id, boolean repondre_tel, String autre) {
        this.abonne_id = abonne_id;
        this.repondre_tel = repondre_tel;
        this.autre = autre;
    }

    public void setId_declaration(int id_declaration) {
        this.id_declaration = id_declaration;
    }

    public void setAbonne_id(int abonne_id) {
        this.abonne_id = abonne_id;
    }

    public void setRepondre_tel(boolean repondre_tel) {
        this.repondre_tel = repondre_tel;
    }

    public void setAutre(String autre) {
        this.autre = autre;
    }

    public int getId_declaration() {
        return id_declaration;
    }

    public int getAbonne_id() {
        return abonne_id;
    }

    public boolean isRepondre_tel() {
        return repondre_tel;
    }

    public String getAutre() {
        return autre;
    }
    
    
}

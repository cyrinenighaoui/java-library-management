/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblio;

/**
 *
 * @author pc
 */
public abstract class Personne{
    protected int id;
    protected String nom;
    protected String prenom;
    public Personne(int id,String nom,String prenom){
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
    }
    public Personne(String nom,String prenom){
        this.nom=nom;
        this.prenom=prenom;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    @Override
    public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
    }
}

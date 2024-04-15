/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblio;

/**
 *
 * @author pc
 */
public class Auteur extends Personne implements Comparable<Auteur>{
	public Auteur(int id, String nom,String prenom) {
		super(id,nom,prenom);
	}
	public Auteur(String nom,String prenom) {
		super(nom,prenom);
	}
	@Override
	public String toString() {
		return "Auteur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

    @Override
    public int compareTo(Auteur o) {
        return this.nom.compareTo(o.nom);
}
	
}

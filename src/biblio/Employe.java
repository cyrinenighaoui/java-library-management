/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblio;

/**
 *
 * @author pc
 */
import java.time.LocalDate;

public class Employe extends Personne implements Comparable<Employe>{
	private float salaire;
	private int cin;
	private LocalDate date_naissance;
        private String num_tel;
	public Employe(int id, String nom, String prenom, float salaire, int cin, String a,String num_tel) {
		super(id, nom, prenom);
		this.salaire = salaire;
		this.cin = cin;
		this.date_naissance = LocalDate.parse(a);
                this.num_tel=num_tel;
	}
	public Employe( String nom, String prenom, float salaire, int cin, String a, String num_tel) {
		super(nom, prenom);
		this.salaire = salaire;
		this.cin = cin;
		this.date_naissance = LocalDate.parse(a);
                this.num_tel=num_tel;
	}
	public float getSalaire() {
		return salaire;
	}
	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}
	public int getCin() {
		return cin;
	}
	public void setCin(int cin) {
		this.cin = cin;
	}
	public LocalDate getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(String a) {
		this.date_naissance = LocalDate.parse(a);
	}
        public String getNum_tel() {
		return num_tel;
	}
	public void setNum_tel(String num_tel) {
		this.num_tel = num_tel;
	}
	@Override
	public String toString() {
		return "Employe [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", salaire=" + salaire + ", cin=" + cin
				+ ", date_naissance=" + date_naissance +", numéro de téléphone="+num_tel+ "]";
	}
        @Override
        public int compareTo(Employe o) {
            return this.nom.compareTo(o.nom);
}
}

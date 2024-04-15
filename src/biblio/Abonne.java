/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblio;

/**
 *
 * @author pc
 */
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Abonne extends Personne implements Comparable<Abonne>{
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
	private int cin;
	private LocalDateTime date_naissance;
	private LocalDateTime date_debut_abonnement;
	private LocalDateTime date_fin_abonnement;
	private String type_abonnement;
        private String num_tel;
	public Abonne(int id, String nom, String prenom, int cin, String a, String b, String c, String type_abonnement,String num_tel) {
		super(id, nom, prenom);
		this.cin = cin;
		this.date_naissance = LocalDateTime.parse(a,formatter);
		this.date_debut_abonnement = LocalDateTime.parse(b,formatter);
		this.date_fin_abonnement = LocalDateTime.parse(c,formatter);
		this.type_abonnement = type_abonnement;
                this.num_tel = num_tel;
	}
     
        
	public Abonne( int cin, String nom, String prenom, int parseInt, String b, String c, String type_abonnement, int parseInt1) {
		super(nom, prenom);
		this.cin = cin;
		this.date_debut_abonnement = LocalDateTime.parse(b,formatter);
		this.date_fin_abonnement = LocalDateTime.parse(c,formatter);
		this.type_abonnement = type_abonnement;
                this.num_tel = num_tel;
	}
	public int getCin() {
		return cin;
	}
	public void setCin(int cin) {
		this.cin = cin;
	}
	public LocalDateTime getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(String a) {
		this.date_naissance = LocalDateTime.parse(a,formatter);
	}
	public LocalDateTime getDate_debut_abonnement() {
		return date_debut_abonnement;
	}
	public void setDate_debut_abonnement(String a) {
		this.date_debut_abonnement = LocalDateTime.parse(a,formatter);
	}
	public LocalDateTime getDate_fin_abonnement() {
		return date_fin_abonnement;
	}
	public void setDate_fin_abonnement(String a) {
		this.date_fin_abonnement = LocalDateTime.parse(a,formatter);
	}
	public String getType_abonnement() {
		return type_abonnement;
	}
	public void setType_abonnement(String type_abonnement) {
		this.type_abonnement = type_abonnement;
	}
        public String getNum_tel() {
		return num_tel;
	}
	public void setNum_tel(String num_tel) {
		this.num_tel = num_tel;
	}
	@Override
	public String toString() {
		return "Abonne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", cin=" + cin + ", date_naissance="
				+ date_naissance + ", date_debut_abonnement=" + date_debut_abonnement + ", date_fin_abonnement="
				+ date_fin_abonnement + ", type_abonnement=" + type_abonnement +", numéro de téléphone="+num_tel+ "]";
	}
	@Override
        public int compareTo(Abonne o) {
            return this.nom.compareTo(o.nom);
}
}

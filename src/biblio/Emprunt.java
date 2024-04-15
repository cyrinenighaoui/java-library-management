/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblio;

/**
 *
 * @author pc
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Emprunt {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
	private int id;
	private Abonne abonne;
	private Ouvrage ouvrage;
	private LocalDateTime date_debut;
	private LocalDateTime date_fin_prevue;
	private LocalDateTime date_fin_effective;
	private String etat;
	private int retard;
	private double amende;
	
	public Emprunt(int id, Abonne abonne, Ouvrage ouvrage, String a,String b,String c, String etat, int retard, double amende) {
		super();
		this.id = id;
		this.abonne = abonne;
		this.ouvrage = ouvrage;
		this.date_debut = LocalDateTime.parse(a,formatter);
		this.date_fin_prevue = LocalDateTime.parse(b,formatter);
		this.date_fin_effective = LocalDateTime.parse(c,formatter);
		this.etat = etat;
		this.retard = retard;
		this.amende = amende;
	}
        public Emprunt(Abonne abonne, Ouvrage ouvrage, String a,String b,String c, String etat, int retard, double amende) {
		super();
		this.abonne = abonne;
		this.ouvrage = ouvrage;
		this.date_debut = LocalDateTime.parse(a,formatter);
		this.date_fin_prevue = LocalDateTime.parse(b,formatter);
		this.date_fin_effective = LocalDateTime.parse(c,formatter);
		this.etat = etat;
		this.retard = retard;
		this.amende = amende;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Abonne getAbonne() {
		return abonne;
	}
	public void setAbonne(Abonne abonne) {
		this.abonne = abonne;
	}
	public Ouvrage getOuvrage() {
		return ouvrage;
	}
	public void setOuvrage(Ouvrage ouvrage) {
		this.ouvrage = ouvrage;
	}
	public LocalDateTime getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(String a) {
		this.date_debut = LocalDateTime.parse(a,formatter);
	}
	public LocalDateTime getDate_fin_prevue() {
		return date_fin_prevue;
	}
	public void setDate_fin_prevue(String a) {
		this.date_fin_prevue = LocalDateTime.parse(a,formatter);
	}
	public LocalDateTime getDate_fin_effective() {
		return date_fin_effective;
	}
	public void setDate_fin_effective(String a) {
		this.date_fin_effective = LocalDateTime.parse(a,formatter);
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public int getRetard() {
		return retard;
	}
	public void setRetard(int retard) {
		this.retard = retard;
	}
	public double getAmende() {
		return amende;
	}
	public void setAmende(double amende) {
		this.amende = amende;
	}
	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", abonne=" + abonne.getNom()+" "+abonne.getPrenom()+", cin abonne="+abonne.getCin() + ", id ouvrage="+ouvrage.getId()+", ouvrage=" + ouvrage.getTitre() + ", date_debut=" + date_debut
				+ ", date_fin_prevue=" + date_fin_prevue + ", date_fin_effective=" + date_fin_effective + ", etat="
				+ etat + ", retard=" + retard + ", amende=" + amende + "]";
	}
	
}
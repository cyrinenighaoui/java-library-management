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

public class Commentaire {
	private int id;
	private Abonne abonne;
	private Ouvrage ouvrage;
	private int nbr_etoiles;
	private LocalDateTime date_commentaire;
	private String description;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
	public Commentaire(int id, Abonne abonne, Ouvrage ouvrage, int nbr_etoiles, String a, String description) {
		super();
		this.id=id;
		this.abonne = abonne;
		this.ouvrage = ouvrage;
		this.nbr_etoiles = nbr_etoiles;
		this.date_commentaire = LocalDateTime.parse(a,formatter);
		this.description = description;
	}
	public Commentaire(Abonne abonne, Ouvrage ouvrage, int nbr_etoiles, String a,String description) {
		super();
		this.abonne = abonne;
		this.ouvrage = ouvrage;
		this.nbr_etoiles = nbr_etoiles;
		this.date_commentaire = LocalDateTime.parse(a,formatter);
		this.description = description;
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
	public int getNbr_etoiles() {
		return nbr_etoiles;
	}
	public void setNbr_etoiles(int nbr_etoiles) {
		this.nbr_etoiles = nbr_etoiles;
	}
	public LocalDateTime getDate_commentaire() {
		return date_commentaire;
	}
	public void setDate_commentaire(String a) {
		this.date_commentaire = LocalDateTime.parse(a,formatter);
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Commentaire [id="+id+", abonne=" + abonne.getNom() + ", ouvrage=" + ouvrage.getTitre() + ", nbr_etoiles=" + nbr_etoiles
				+ ", date_commentaire=" + date_commentaire + ", description=" + description + "]";
	}
	
}



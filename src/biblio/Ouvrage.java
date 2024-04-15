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

public abstract class Ouvrage implements Comparable<Ouvrage>{
	protected int id;
        protected Auteur a; 
	protected String titre;
	protected LocalDateTime date_publication;
	protected float prix;
	protected String genre;
	protected String langue;
	protected String mots_cles;
        protected float rate;
        protected String etat;
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
	public Ouvrage(int id, String titre, String a, float prix, String genre,
			String langue, String mots_cles, float rate, String etat) {
		super();
		this.id = id;
		this.titre = titre;
		this.date_publication = LocalDateTime.parse(a,formatter);
		this.prix = prix;
		this.genre = genre;
		this.langue = langue;
		this.mots_cles = mots_cles;
                this.rate=rate;
                this.etat=etat;
	}
	public Ouvrage(String titre, String a, float prix, String genre,
			String langue, String mots_cles, float rate,String etat) {
		super();
		this.titre = titre;
		this.date_publication = LocalDateTime.parse(a,formatter);
		this.prix = prix;
		this.genre = genre;
		this.langue = langue;
		this.mots_cles = mots_cles;
                this.rate=rate;
                this.etat=etat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public LocalDateTime getDate_publication() {
		return date_publication;
	}
	public void setDate_publication(String a) {
		this.date_publication = LocalDateTime.parse(a,formatter);
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
        public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getLangue() {
		return langue;
	}
	public void setLangue(String langue) {
		this.langue = langue;
	}
	public String getMots_cles() {
		return mots_cles;
	}
	public void setMots_cles(String mots_cles) {
		this.mots_cles = mots_cles;
	}
        public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	@Override
	public String toString() {
		return "Ouvrage [id=" + id + ", titre=" + titre + ", date_publication=" + date_publication + ", prix=" + prix
				+ ", genre=" + genre + ", etat=" + etat + ", langue=" + langue + ", mots_cles=" + mots_cles + "]";
	}
        @Override
        public int compareTo(Ouvrage other) {
	// TODO Auto-generated method stub
	return Float.compare(this.rate, other.rate);
        }
}

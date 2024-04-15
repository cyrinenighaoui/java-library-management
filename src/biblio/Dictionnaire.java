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

public class Dictionnaire extends Ouvrage{
	private int nbr_mots;
	private int nbr_pages;
	
	public Dictionnaire(int id, String titre, String a, float prix, String genre,
			String langue, String mots_cles, int nbr_mots, int nbr_pages,float rate,String etat) {
		super(id, titre, a, prix, genre, langue, mots_cles,rate,etat);
		this.nbr_mots = nbr_mots;
		this.nbr_pages = nbr_pages;
	}
	public Dictionnaire(String titre,String a, float prix, String genre,
			String langue, String mots_cles, int nbr_mots, int nbr_pages,float rate,String etat) {
		super(titre, a, prix, genre, langue, mots_cles,rate,etat);
		this.nbr_mots = nbr_mots;
		this.nbr_pages = nbr_pages;
	}
	public int getNbr_mots() {
		return nbr_mots;
	}
	public void setNbr_mots(int nbr_mots) {
		this.nbr_mots = nbr_mots;
	}
	public int getNbr_pages() {
		return nbr_pages;
	}
	public void setNbr_pages(int nbr_pages) {
		this.nbr_pages = nbr_pages;
	}
	@Override
	public String toString() {
		return "Dictionnaire [id=" + id + ", titre=" + titre + ", date_publication=" + date_publication + ", prix="
				+ prix + ", genre=" + genre +", rate=" + rate + ", etat=" + etat + ", langue=" + langue + ", mots_cles=" + mots_cles
				+ ", nbr_mots=" + nbr_mots + ", nbr_pages=" + nbr_pages + "]";
	}
}

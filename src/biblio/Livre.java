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

public class Livre extends Ouvrage {
	private int nbr_pages;
	
	public Livre(int id, String titre, String a, float prix, String genre, 
			String langue, String mots_cles, int nbr_pages, float rate,String etat) {
		super(id, titre, a, prix, genre, langue, mots_cles,rate,etat);
		this.nbr_pages = nbr_pages;
	}
	public Livre(String titre, String a, float prix, String genre,
			String langue, String mots_cles, int nbr_pages,float rate,String etat) {
		super(titre, a, prix, genre, langue, mots_cles, rate,etat);
		this.nbr_pages = nbr_pages;
	}
	public int getNbr_pages() {
		return nbr_pages;
	}

	public void setNbr_pages(int nbr_pages) {
		this.nbr_pages = nbr_pages;
	}
	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", date_publication=" + date_publication + ", prix=" + prix
				+ ", genre=" + genre + ", rate=" + rate + ", etat=" + etat + ", langue=" + langue + ", mots_cles=" + mots_cles
				+ ", nbr_pages=" + nbr_pages + "]";
	}
}

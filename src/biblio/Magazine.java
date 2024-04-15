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

public class Magazine extends Ouvrage{
	private int num_magazine;
	private int nbr_pages;
	
	public Magazine(int id, String titre, String a, float prix, String genre,
			String langue, String mots_cles, int num_magazine, int nbr_pages, float rate,String etat) {
		super(id, titre, a, prix, genre,  langue, mots_cles,rate,etat);
		this.num_magazine = num_magazine;
		this.nbr_pages = nbr_pages;
	}
	public Magazine(String titre, String a, float prix, String genre, 
			String langue, String mots_cles, int num_magazine, int nbr_pages,float rate,String etat) {
		super(titre, a, prix, genre, langue, mots_cles,rate,etat);
		this.num_magazine = num_magazine;
		this.nbr_pages = nbr_pages;
	}
	public int getNum_magazine() {
		return num_magazine;
	}
	public void setNum_magazine(int num_magazine) {
		this.num_magazine = num_magazine;
	}
	public int getNbr_pages() {
		return nbr_pages;
	}
	public void setNbr_pages(int nbr_pages) {
		this.nbr_pages = nbr_pages;
	}
	@Override
	public String toString() {
		return "Magazine [id=" + id + ", titre=" + titre + ", date_publication=" + date_publication + ", prix=" + prix
				+ ", genre=" + genre +", rate=" + rate + ", etat=" + etat + ", langue=" + langue + ", mots_cles=" + mots_cles
				+ ", num_magazine=" + num_magazine + ", nbr_pages=" + nbr_pages + "]";
	}
	
}
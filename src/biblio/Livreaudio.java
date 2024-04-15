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
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Livreaudio extends Ouvrage{
	private String format;
	private LocalTime duree;
	DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH:mm:ss");
	public Livreaudio(int id, String titre, String a, float prix, String genre,
			String langue, String mots_cles, String format, String b, float rate,String etat) {
		super(id, titre, a, prix, genre, langue, mots_cles,rate,etat);
		this.format = format;
		this.duree = LocalTime.parse(b,formatter1);
	}
	public Livreaudio(String titre, String a, float prix, String genre, 
			String langue, String mots_cles, String format, String b,float rate,String etat) {
		super(titre, a, prix, genre, langue, mots_cles,rate,etat);
		this.format = format;
		this.duree = LocalTime.parse(b,formatter1);
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public LocalTime getDuree() {
		return duree;
	}
	public void setDuree(String a) {
		this.duree = LocalTime.parse(a,formatter1);
	}
	@Override
	public String toString() {
		return "Livreaudio [id=" + id + ", titre=" + titre + ", date_publication=" + date_publication + ", prix=" + prix
				+ ", genre=" + genre +", rate=" + rate + ", etat=" + etat + ", langue=" + langue + ", mots_cles=" + mots_cles
				+ ", format=" + format + ", duree=" + duree + "]";
	}
	
}

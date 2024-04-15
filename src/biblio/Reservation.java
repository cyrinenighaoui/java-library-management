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
public class Reservation {
    private int id;
    private Ouvrage o;
    private Abonne a;
    private LocalDateTime date_reservation;
    private int ordre_attente;
    private String etat;
    
	public Reservation(Ouvrage o, Abonne a, String date_reservation, int ordre_attente, String etat) {
		super();
		this.o = o;
		this.a = a;
		this.date_reservation = LocalDateTime.parse(date_reservation);
		this.ordre_attente = ordre_attente;
		this.etat = etat;
	}
	public Reservation(int id, Ouvrage o, Abonne a, String date_reservation, int ordre_attente, String etat) {
		super();
		this.id = id;
		this.o = o;
		this.a = a;
		this.date_reservation = LocalDateTime.parse(date_reservation);
		this.ordre_attente = ordre_attente;
		this.etat = etat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Ouvrage getOuvrage() {
		return o;
	}
	public void setOuvrage(Ouvrage o) {
		this.o = o;
	}
	public Abonne getAbonne() {
		return a;
	}
	public void setAbonne(Abonne a) {
		this.a = a;
	}
	public LocalDateTime getDate_reservation() {
		return date_reservation;
	}
	public void setDate_reservation(String date_reservation) {
		this.date_reservation = LocalDateTime.parse(date_reservation);
	}
	public int getOrdre_attente() {
		return ordre_attente;
	}
	public void setOrdre_attente(int ordre_attente) {
		this.ordre_attente = ordre_attente;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", o=" + o.toString() + ", a=" + a.toString() + ", date_reservation=" + date_reservation
				+ ", ordre_attente=" + ordre_attente + ", etat=" + etat + "]";
	}
}

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

public class Historique {
	private int id;
	private Employe employe;
	private Abonne abonne;
	private LocalDateTime date_action;
	private String action;
	
	public Historique(int id, Employe employe, Abonne abonne, String a, String action) {
		super();
		this.id = id;
		this.employe = employe;
		this.abonne = abonne;
		this.date_action = LocalDateTime.parse(a);
		this.action = action;
	}
	public Historique(Employe employe, Abonne abonne, String a, String action) {
		super();
		this.employe = employe;
		this.abonne = abonne;
		this.date_action = LocalDateTime.parse(a);
		this.action = action;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Abonne getAbonne() {
		return abonne;
	}
	public void setAbonne(Abonne abonne) {
		this.abonne = abonne;
	}
	public LocalDateTime getDate_action() {
		return date_action;
	}
	public void setDate_action(String a) {
		this.date_action = LocalDateTime.parse(a);
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	@Override
	public String toString() {
		return "Historique [id=" + id + ", employe=" + employe + ", abonne=" + abonne + ", date_action=" + date_action
				+ ", action=" + action + "]";
	}
}

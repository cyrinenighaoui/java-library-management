/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package biblio;

/**
 *
 * @author pc
 */
import java.util.Vector;

/**
 *
 * @author pc
 */
public interface EmployeDAOInterface {
    Abonne getAbonne(int id);
    Vector<Abonne> getAllAbonnes();
    Vector<Abonne> getAbonneByFullName(String nom,String prenom);
    boolean insertAbonne(Abonne a);
    boolean updateAbonneTypeAbonnement(Abonne a);
    boolean renouvellerAbonnement(Abonne a);
    boolean deleteAbonne(int id);
    boolean insertLivre(Livre l);
    boolean insertLivreaudio(Livreaudio lo);
    boolean insertMagazine(Magazine m);
    boolean insertDictionnaire(Dictionnaire d);
    boolean updateOuvragePrix(Ouvrage o);
    boolean updateOuvrageMotsCles(Ouvrage o);
    boolean deleteOuvrage(int id);
}

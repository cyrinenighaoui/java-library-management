/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package biblio;

import java.util.Vector;

/**
 *
 * @author pc
 */
public interface CommunInterface {
    Ouvrage getOuvrage(int id);
    Vector<Ouvrage> getAllOuvrages();
    Vector<Ouvrage> getAllOuvragesByDispo();
    Vector<Ouvrage> getAllOuvragesByType(String type);
    Vector<Ouvrage> getAllOuvragesByGenre(String genre);
    Vector<Ouvrage> getOuvrageByTitle(String titre);
    boolean updateAbonnePhone(Abonne a);
    boolean changermdp(String nouveau_mdp,Personne p);
}

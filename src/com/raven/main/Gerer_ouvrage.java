/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.main;
import java.sql.Connection;
import java.util.Date;
import java.util.Vector;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
/**
 *
 * @author USER
 */
public class Gerer_ouvrage implements Ouvrage_interface {
@Override
    public Boolean ajouter_livre(String titre, LocalDate date_pub, String genre, String langue, double prix, int nbr_page)
    {
        String requete = "INSERT INTO ouvrages (type_ouvrage, titre_ouvrage, date_publication, genre, langue, prix, disponibilite, nbre_page,etat) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
        int rowCount = 0;
        try {
            Connection connection ;
            connection=	LIBRAIRIE.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(requete);            
            preparedStatement.setString(1, "Livre");
            preparedStatement.setString(2, titre);
            preparedStatement.setObject(3,date_pub); // Convertir LocalDateTime en java.sql.Timestamp
            preparedStatement.setString(4, genre);
            preparedStatement.setString(5, langue);
            preparedStatement.setDouble(6, prix);
            preparedStatement.setBoolean(7, true);
            preparedStatement.setInt(8, nbr_page);
            preparedStatement.setString(9, "disponible");

            rowCount = preparedStatement.executeUpdate();
            System.out.println("Nombre de lignes affectées : " + rowCount);
            preparedStatement.close();
            connection.close();
            return rowCount >= 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    
    @Override
    public Boolean ajouter_livreAudio(String titre, LocalDate date_pub, String genre, String langue, double prix, String format, LocalTime duree) {
    String requete = "INSERT INTO ouvrages (type_ouvrage, titre_ouvrage, date_publication, genre, langue, prix, disponibilite, format, duree) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try {
        Connection connection = LIBRAIRIE.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        preparedStatement.setString(1, "LivreAudio");
        preparedStatement.setString(2, titre);
            preparedStatement.setObject(3,date_pub);
        preparedStatement.setString(4, genre);
        preparedStatement.setString(5, langue);
        preparedStatement.setDouble(6, prix);
        preparedStatement.setBoolean(7, true); 
        preparedStatement.setString(8, format);
preparedStatement.setObject(9, Time.valueOf(duree));
        int rowCount = preparedStatement.executeUpdate();
        System.out.println("Nombre de lignes affectées : " + rowCount);
        preparedStatement.close();
        connection.close();
        return rowCount >= 1;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}


    @Override
public Boolean ajouter_dictionnaire(String titre, LocalDate date_pub, String genre, String langue, double prix, int nbr_page, int nbr_mot) {
    String requete = "INSERT INTO ouvrages (type_ouvrage, titre_ouvrage, date_publication, genre, langue, prix, disponibilite, nbre_page, nbre_mots) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try {
        Connection connection = LIBRAIRIE.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        preparedStatement.setString(1, "Dictionnaire");
        preparedStatement.setString(2, titre);
            preparedStatement.setObject(3,date_pub); // Convertir LocalDateTime en java.sql.Timestamp
        preparedStatement.setString(4, genre);
        preparedStatement.setString(5, langue);
        preparedStatement.setDouble(6, prix);
        preparedStatement.setBoolean(7, true);
        preparedStatement.setInt(8, nbr_page);
        preparedStatement.setInt(9, nbr_mot);
        int rowCount = preparedStatement.executeUpdate();
        System.out.println("Nombre de lignes affectées : " + rowCount);
        preparedStatement.close();
        connection.close();
        return rowCount >= 1;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

    @Override
public Boolean ajouter_magazine(String titre, LocalDate date_pub, String genre, String langue, double prix, int num_magazine, int nbre_page) {
    String requete = "INSERT INTO ouvrages (type_ouvrage, titre_ouvrage, date_publication, genre, langue, prix, disponibilite, num_magazine, nbre_page) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try {
        Connection connection = LIBRAIRIE.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        preparedStatement.setString(1, "Magazine");
        preparedStatement.setString(2, titre);
        preparedStatement.setObject(3,date_pub); 
        preparedStatement.setString(4, genre);
        preparedStatement.setString(5, langue);
        preparedStatement.setDouble(6, prix);
        preparedStatement.setBoolean(7, true);
        preparedStatement.setInt(8, num_magazine);
        preparedStatement.setInt(9, nbre_page);
        int rowCount = preparedStatement.executeUpdate();
        System.out.println("Nombre de lignes affectées : " + rowCount);
        preparedStatement.close();
        connection.close();
        return rowCount >= 1;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

    @Override
    public Boolean supprimer_ouvrage(int id) {
        String requete = "DELETE FROM ouvrages WHERE ouvrage_id = ?";
        try {
            Connection connection = LIBRAIRIE.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(requete);
            preparedStatement.setInt(1, id); 
            int rowCount = preparedStatement.executeUpdate();
            System.out.println("Nombre de lignes affectées : " + rowCount);
            preparedStatement.close();
            connection.close();
            return rowCount >= 1; 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; 
    }
    
   @Override
    public Boolean modifier_prix_ouvrage(int id, int nouveauPrix) {
    String requete = "UPDATE ouvrages SET prix = ? WHERE ouvrage_id = ?";
    try {
        Connection connection = LIBRAIRIE.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        preparedStatement.setInt(1, nouveauPrix); 
        preparedStatement.setInt(2, id);
        int rowCount = preparedStatement.executeUpdate(); 
        System.out.println("Nombre de lignes affectées : " + rowCount);
        preparedStatement.close();
        connection.close();
        return rowCount >= 1; 
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false; 
    }

        @Override
        public  Ouvrage obtenir_ouvrage_par_id(int id) {
            String requete = "SELECT * FROM ouvrages WHERE ouvrage_id = ?";
            Ouvrage ouvrage = null;
            try {
                Connection connection = LIBRAIRIE.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(requete);
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String typeOuvrage = resultSet.getString("type_ouvrage");
                    int ouvrageId = resultSet.getInt("ouvrage_id");
                    int auteur_id = resultSet.getInt("auteur_id");
                    String titre = resultSet.getString("titre_ouvrage");
                    LocalDateTime datePublication = resultSet.getTimestamp("date_publication").toLocalDateTime();
                    double prix = resultSet.getDouble("prix");
                    String genre = resultSet.getString("genre");
                    boolean disponibilite = resultSet.getBoolean("disponibilite");
                    String langue = resultSet.getString("langue");                 
                    switch (typeOuvrage) {
                        case "Livre":
                             int nbrePageLivre = resultSet.getInt("nbre_page");
                            ouvrage = new Livre(nbrePageLivre, ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        case "Magazine":
                            int num_magazine = resultSet.getInt("num_magazine");
                             int nbrePageMagazine = resultSet.getInt("nbre_page");
                             ouvrage = new Magazine(num_magazine, nbrePageMagazine,ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        case "Dictionnaire":
                            int nbrePageDictionnaire = resultSet.getInt("nbre_page");
                            int nbre_mots = resultSet.getInt("nbre_mots");
                             ouvrage = new Dictionnaire(nbre_mots,nbrePageDictionnaire,ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        case "LivreAudio":
                             String format = resultSet.getString("format");
                             Date duree = resultSet.getDate("duree");
                            ouvrage = new LivreAudio(format,duree,ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        default:
                            throw new IllegalArgumentException("Type d'ouvrage inconnu: " + typeOuvrage);
                    }

                }

                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException | IllegalArgumentException e) {
                e.printStackTrace();
            }

            return ouvrage;
        }

        
    @Override
    public Ouvrage obtenir_ouvrage_par_titre(String titre) {
        String requete = "SELECT * FROM ouvrages WHERE titre_ouvrage = ?";
            Ouvrage ouvrage = null;
            try {
                Connection connection = LIBRAIRIE.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(requete);
                preparedStatement.setString(1, titre);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String typeOuvrage = resultSet.getString("type_ouvrage");
                    int ouvrageId = resultSet.getInt("ouvrage_id");
                    int auteur_id = resultSet.getInt("auteur_id");
                    LocalDateTime datePublication = resultSet.getTimestamp("date_publication").toLocalDateTime();
                    double prix = resultSet.getDouble("prix");
                    String genre = resultSet.getString("genre");
                    boolean disponibilite = resultSet.getBoolean("disponibilite");
                    String langue = resultSet.getString("langue");                 
                    switch (typeOuvrage) {
                        case "Livre":
                             int nbrePageLivre = resultSet.getInt("nbre_page");
                            ouvrage = new Livre(nbrePageLivre, ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        case "Magazine":
                            int num_magazine = resultSet.getInt("num_magazine");
                             int nbrePageMagazine = resultSet.getInt("nbre_page");
                             ouvrage = new Magazine(num_magazine, nbrePageMagazine,ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        case "Dictionnaire":
                            int nbrePageDictionnaire = resultSet.getInt("nbre_page");
                            int nbre_mots = resultSet.getInt("nbre_mots");
                             ouvrage = new Dictionnaire(nbre_mots,nbrePageDictionnaire,ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        case "LivreAudio":
                             String format = resultSet.getString("format");
                             Date duree = resultSet.getDate("duree");
                            ouvrage = new LivreAudio(format,duree,ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        default:
                            throw new IllegalArgumentException("Type d'ouvrage inconnu: " + typeOuvrage);
                    }

                }
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException | IllegalArgumentException e) {
                e.printStackTrace();
            }

            return ouvrage;
    }
    @Override
    public Vector<Ouvrage> lister_tous_les_ouvrages() {
        Vector<Ouvrage> ouvrages = new Vector<>();
    String requete = "SELECT * FROM ouvrages";
    try {
        Connection connection = LIBRAIRIE.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
         ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
                    String typeOuvrage = resultSet.getString("type_ouvrage");
                    int ouvrageId = resultSet.getInt("ouvrage_id");
                    String titre = resultSet.getString("titre_ouvrage");
                    int auteur_id = resultSet.getInt("auteur_id");
                    LocalDateTime datePublication = resultSet.getTimestamp("date_publication").toLocalDateTime();
                    double prix = resultSet.getDouble("prix");
                    String genre = resultSet.getString("genre");
                    boolean disponibilite = resultSet.getBoolean("disponibilite");
                    String langue = resultSet.getString("langue");   
                    Ouvrage ouvrage = null;
                    switch (typeOuvrage) {
                        case "Livre":
                             int nbrePageLivre = resultSet.getInt("nbre_page");
                             ouvrage = new Livre(nbrePageLivre, ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        case "Magazine":
                            int num_magazine = resultSet.getInt("num_magazine");
                             int nbrePageMagazine = resultSet.getInt("nbre_page");
                              ouvrage = new Magazine(num_magazine, nbrePageMagazine,ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        case "Dictionnaire":
                            int nbrePageDictionnaire = resultSet.getInt("nbre_page");
                            int nbre_mots = resultSet.getInt("nbre_mots");
                             ouvrage = new Dictionnaire(nbre_mots,nbrePageDictionnaire,ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        case "LivreAudio":
                             String format = resultSet.getString("format");
                             Date duree = resultSet.getDate("duree");
                            ouvrage = new LivreAudio(format,duree,ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        default:
                            throw new IllegalArgumentException("Type d'ouvrage inconnu: " + typeOuvrage);
                    }
            if (ouvrage != null) {
                ouvrages.add(ouvrage);
            }
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return ouvrages;
        
    }

    @Override
    public Vector<Ouvrage> obtenir_ouvrages_par_auteur(String auteur) {
    Vector<Ouvrage> ouvrages = new Vector<>();
    String requete = "SELECT * FROM ouvrages JOIN auteurs ON ouvrages.auteur_id = auteurs.auteur_id WHERE auteurs.nom = ?";
    try {
        Connection connection = LIBRAIRIE.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        preparedStatement.setString(1, auteur);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            
                    String typeOuvrage = resultSet.getString("type_ouvrage");
                    int ouvrageId = resultSet.getInt("ouvrage_id");
                    String titre = resultSet.getString("titre_ouvrage");
                    int auteur_id = resultSet.getInt("auteur_id");
                    LocalDateTime datePublication = resultSet.getTimestamp("date_publication").toLocalDateTime();
                    double prix = resultSet.getDouble("prix");
                    String genre = resultSet.getString("genre");
                    boolean disponibilite = resultSet.getBoolean("disponibilite");
                    String langue = resultSet.getString("langue");   
                    Ouvrage ouvrage = null;
                    switch (typeOuvrage) {
                        case "Livre":
                             int nbrePageLivre = resultSet.getInt("nbre_page");
                             ouvrage = new Livre(nbrePageLivre, ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        case "Magazine":
                            int num_magazine = resultSet.getInt("num_magazine");
                             int nbrePageMagazine = resultSet.getInt("nbre_page");
                              ouvrage = new Magazine(num_magazine, nbrePageMagazine,ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        case "Dictionnaire":
                            int nbrePageDictionnaire = resultSet.getInt("nbre_page");
                            int nbre_mots = resultSet.getInt("nbre_mots");
                             ouvrage = new Dictionnaire(nbre_mots,nbrePageDictionnaire,ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        case "LivreAudio":
                             String format = resultSet.getString("format");
                             Date duree = resultSet.getDate("duree");
                            ouvrage = new LivreAudio(format,duree,ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        default:
                            throw new IllegalArgumentException("Type d'ouvrage inconnu: " + typeOuvrage);
                    }
            if (ouvrage != null) {
                ouvrages.add(ouvrage);
            }
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return ouvrages;
}


    @Override
    public Vector<Ouvrage> obtenir_ouvrages_par_annee(int annee) {
            Vector<Ouvrage> ouvrages = new Vector<>();
            String requete = "SELECT * FROM ouvrages WHERE YEAR(date_publication) = ?";
            try {
                Connection connection = LIBRAIRIE.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(requete);
                preparedStatement.setInt(1, annee);
                ResultSet resultSet = preparedStatement.executeQuery();
                 while (resultSet.next()) {
                    String typeOuvrage = resultSet.getString("type_ouvrage");
                    int ouvrageId = resultSet.getInt("ouvrage_id");
                    String titre = resultSet.getString("titre_ouvrage");
                    int auteur_id = resultSet.getInt("auteur_id");
                    LocalDateTime datePublication = resultSet.getTimestamp("date_publication").toLocalDateTime();
                    double prix = resultSet.getDouble("prix");
                    String genre = resultSet.getString("genre");
                    boolean disponibilite = resultSet.getBoolean("disponibilite");
                    String langue = resultSet.getString("langue");   
                    Ouvrage ouvrage = null;
                    switch (typeOuvrage) {
                        case "Livre":
                             int nbrePageLivre = resultSet.getInt("nbre_page");
                             ouvrage = new Livre(nbrePageLivre, ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        case "Magazine":
                            int num_magazine = resultSet.getInt("num_magazine");
                             int nbrePageMagazine = resultSet.getInt("nbre_page");
                              ouvrage = new Magazine(num_magazine, nbrePageMagazine,ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        case "Dictionnaire":
                            int nbrePageDictionnaire = resultSet.getInt("nbre_page");
                            int nbre_mots = resultSet.getInt("nbre_mots");
                             ouvrage = new Dictionnaire(nbre_mots,nbrePageDictionnaire,ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        case "LivreAudio":
                             String format = resultSet.getString("format");
                             Date duree = resultSet.getDate("duree");
                            ouvrage = new LivreAudio(format,duree,ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        default:
                            throw new IllegalArgumentException("Type d'ouvrage inconnu: " + typeOuvrage);
                    }
            if (ouvrage != null) {
                ouvrages.add(ouvrage);
            }
                }
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return ouvrages;
}


    @Override
public Vector<Ouvrage> obtenir_ouvrage_par_type(String type) {
    Vector<Ouvrage> ouvrages = new Vector<>();
    String requete = "SELECT * FROM ouvrages WHERE type_ouvrage = ?";
    try {
        Connection connection = LIBRAIRIE.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        preparedStatement.setString(1, type);
        ResultSet resultSet = preparedStatement.executeQuery();
         while (resultSet.next()) {
                    String typeOuvrage = resultSet.getString("type_ouvrage");
                    int ouvrageId = resultSet.getInt("ouvrage_id");
                    String titre = resultSet.getString("titre_ouvrage");
                    int auteur_id = resultSet.getInt("auteur_id");
                    LocalDateTime datePublication = resultSet.getTimestamp("date_publication").toLocalDateTime();
                    double prix = resultSet.getDouble("prix");
                    String genre = resultSet.getString("genre");
                    boolean disponibilite = resultSet.getBoolean("disponibilite");
                    String langue = resultSet.getString("langue");   
                    Ouvrage ouvrage = null;
                    switch (typeOuvrage) {
                        case "Livre":
                             int nbrePageLivre = resultSet.getInt("nbre_page");
                             ouvrage = new Livre(nbrePageLivre, ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        case "Magazine":
                            int num_magazine = resultSet.getInt("num_magazine");
                             int nbrePageMagazine = resultSet.getInt("nbre_page");
                              ouvrage = new Magazine(num_magazine, nbrePageMagazine,ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        case "Dictionnaire":
                            int nbrePageDictionnaire = resultSet.getInt("nbre_page");
                            int nbre_mots = resultSet.getInt("nbre_mots");
                             ouvrage = new Dictionnaire(nbre_mots,nbrePageDictionnaire,ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        case "LivreAudio":
                             String format = resultSet.getString("format");
                             Date duree = resultSet.getDate("duree");
                            ouvrage = new LivreAudio(format,duree,ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        default:
                            throw new IllegalArgumentException("Type d'ouvrage inconnu: " + typeOuvrage);
                    }
            if (ouvrage != null) {
                ouvrages.add(ouvrage);
            }}
        resultSet.close();
        preparedStatement.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return ouvrages;
}


@Override
public Vector<Ouvrage> obtenir_ouvrage_premiere_lettre(String lettre) {
    Vector<Ouvrage> ouvrages = new Vector<>();
    String requete = "SELECT * FROM ouvrages WHERE titre_ouvrage LIKE ?";
    try {
        Connection connection = LIBRAIRIE.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        preparedStatement.setString(1, lettre + "%");
        ResultSet resultSet = preparedStatement.executeQuery();
       while (resultSet.next()) {
                    String typeOuvrage = resultSet.getString("type_ouvrage");
                    int ouvrageId = resultSet.getInt("ouvrage_id");
                    String titre = resultSet.getString("titre_ouvrage");
                    int auteur_id = resultSet.getInt("auteur_id");
                    LocalDateTime datePublication = resultSet.getTimestamp("date_publication").toLocalDateTime();
                    double prix = resultSet.getDouble("prix");
                    String genre = resultSet.getString("genre");
                    boolean disponibilite = resultSet.getBoolean("disponibilite");
                    String langue = resultSet.getString("langue");   
                    Ouvrage ouvrage = null;
                    switch (typeOuvrage) {
                        case "Livre":
                             int nbrePageLivre = resultSet.getInt("nbre_page");
                             ouvrage = new Livre(nbrePageLivre, ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        case "Magazine":
                            int num_magazine = resultSet.getInt("num_magazine");
                             int nbrePageMagazine = resultSet.getInt("nbre_page");
                              ouvrage = new Magazine(num_magazine, nbrePageMagazine,ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        case "Dictionnaire":
                            int nbrePageDictionnaire = resultSet.getInt("nbre_page");
                            int nbre_mots = resultSet.getInt("nbre_mots");
                             ouvrage = new Dictionnaire(nbre_mots,nbrePageDictionnaire,ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        case "LivreAudio":
                             String format = resultSet.getString("format");
                             Date duree = resultSet.getDate("duree");
                            ouvrage = new LivreAudio(format,duree,ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        default:
                            throw new IllegalArgumentException("Type d'ouvrage inconnu: " + typeOuvrage);
                    }
            if (ouvrage != null) {
                ouvrages.add(ouvrage);
            }}
        resultSet.close();
        preparedStatement.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return ouvrages;
}

   @Override
public Vector<Ouvrage> obtenir_ouvrage_disponible() {
    Vector<Ouvrage> ouvrages = new Vector<>();
    String requete = "SELECT * FROM ouvrages WHERE disponibilite = TRUE";
    try {
        Connection connection = LIBRAIRIE.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
                    String typeOuvrage = resultSet.getString("type_ouvrage");
                    int ouvrageId = resultSet.getInt("ouvrage_id");
                    String titre = resultSet.getString("titre_ouvrage");
                    int auteur_id = resultSet.getInt("auteur_id");
                    LocalDateTime datePublication = resultSet.getTimestamp("date_publication").toLocalDateTime();
                    double prix = resultSet.getDouble("prix");
                    String genre = resultSet.getString("genre");
                    boolean disponibilite = resultSet.getBoolean("disponibilite");
                    String langue = resultSet.getString("langue");   
                    Ouvrage ouvrage = null;
                    switch (typeOuvrage) {
                        case "Livre":
                             int nbrePageLivre = resultSet.getInt("nbre_page");
                             ouvrage = new Livre(nbrePageLivre, ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        case "Magazine":
                            int num_magazine = resultSet.getInt("num_magazine");
                             int nbrePageMagazine = resultSet.getInt("nbre_page");
                              ouvrage = new Magazine(num_magazine, nbrePageMagazine,ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        case "Dictionnaire":
                            int nbrePageDictionnaire = resultSet.getInt("nbre_page");
                            int nbre_mots = resultSet.getInt("nbre_mots");
                             ouvrage = new Dictionnaire(nbre_mots,nbrePageDictionnaire,ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        case "LivreAudio":
                             String format = resultSet.getString("format");
                             Date duree = resultSet.getDate("duree");
                            ouvrage = new LivreAudio(format,duree,ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        default:
                            throw new IllegalArgumentException("Type d'ouvrage inconnu: " + typeOuvrage);
                    }
            if (ouvrage != null) {
                ouvrages.add(ouvrage);
            }}
        resultSet.close();
        preparedStatement.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return ouvrages;
}



    @Override
public Vector<Ouvrage> obtenir_ouvrage_par_langue(String langue) {
    Vector<Ouvrage> ouvrages = new Vector<>();
    String requete = "SELECT * FROM ouvrages WHERE langue = ?";
    try {
        Connection connection = LIBRAIRIE.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        preparedStatement.setString(1, langue);
        ResultSet resultSet = preparedStatement.executeQuery();
          while (resultSet.next()) {
                    String typeOuvrage = resultSet.getString("type_ouvrage");
                    int ouvrageId = resultSet.getInt("ouvrage_id");
                    String titre = resultSet.getString("titre_ouvrage");
                    int auteur_id = resultSet.getInt("auteur_id");
                    LocalDateTime datePublication = resultSet.getTimestamp("date_publication").toLocalDateTime();
                    double prix = resultSet.getDouble("prix");
                    String genre = resultSet.getString("genre");
                    boolean disponibilite = resultSet.getBoolean("disponibilite");
                    langue = resultSet.getString("langue");   
                    Ouvrage ouvrage = null;
                    switch (typeOuvrage) {
                        case "Livre":
                             int nbrePageLivre = resultSet.getInt("nbre_page");
                             ouvrage = new Livre(nbrePageLivre, ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        case "Magazine":
                            int num_magazine = resultSet.getInt("num_magazine");
                             int nbrePageMagazine = resultSet.getInt("nbre_page");
                              ouvrage = new Magazine(num_magazine, nbrePageMagazine,ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        case "Dictionnaire":
                            int nbrePageDictionnaire = resultSet.getInt("nbre_page");
                            int nbre_mots = resultSet.getInt("nbre_mots");
                             ouvrage = new Dictionnaire(nbre_mots,nbrePageDictionnaire,ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        case "LivreAudio":
                             String format = resultSet.getString("format");
                             Date duree = resultSet.getDate("duree");
                            ouvrage = new LivreAudio(format,duree,ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        default:
                            throw new IllegalArgumentException("Type d'ouvrage inconnu: " + typeOuvrage);
                    }
            if (ouvrage != null) {
                ouvrages.add(ouvrage);
            }}
        resultSet.close();
        preparedStatement.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return ouvrages;
}

         @Override
public Vector<Ouvrage> obtenir_ouvrage_par_genre(String genre) {
    Vector<Ouvrage> ouvrages = new Vector<>();
    String requete = "SELECT * FROM ouvrages WHERE genre = ?";
    try {
        Connection connection = LIBRAIRIE.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        preparedStatement.setString(1, genre);
        ResultSet resultSet = preparedStatement.executeQuery();
          while (resultSet.next()) {
                    String typeOuvrage = resultSet.getString("type_ouvrage");
                    int ouvrageId = resultSet.getInt("ouvrage_id");
                    String titre = resultSet.getString("titre_ouvrage");
                    int auteur_id = resultSet.getInt("auteur_id");
                    LocalDateTime datePublication = resultSet.getTimestamp("date_publication").toLocalDateTime();
                    double prix = resultSet.getDouble("prix");
                     genre = resultSet.getString("genre");
                    boolean disponibilite = resultSet.getBoolean("disponibilite");
                    String langue = resultSet.getString("langue");   
                    Ouvrage ouvrage = null;
                    switch (typeOuvrage) {
                        case "Livre":
                             int nbrePageLivre = resultSet.getInt("nbre_page");
                             ouvrage = new Livre(nbrePageLivre, ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        case "Magazine":
                            int num_magazine = resultSet.getInt("num_magazine");
                             int nbrePageMagazine = resultSet.getInt("nbre_page");
                              ouvrage = new Magazine(num_magazine, nbrePageMagazine,ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        case "Dictionnaire":
                            int nbrePageDictionnaire = resultSet.getInt("nbre_page");
                            int nbre_mots = resultSet.getInt("nbre_mots");
                             ouvrage = new Dictionnaire(nbre_mots,nbrePageDictionnaire,ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        case "LivreAudio":
                             String format = resultSet.getString("format");
                             Date duree = resultSet.getDate("duree");
                            ouvrage = new LivreAudio(format,duree,ouvrageId, titre, datePublication, prix, genre, disponibilite, langue);
                            break;
                        default:
                            throw new IllegalArgumentException("Type d'ouvrage inconnu: " + typeOuvrage);
                    }
            if (ouvrage != null) {
                ouvrages.add(ouvrage);
            }}
        resultSet.close();
        preparedStatement.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return ouvrages;
}

    @Override
    public Vector<Ouvrage> obtenir_ouvrage_recommander(String genre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
    }

    @Override
    public Boolean Signaler_vol(int ouvrage_id) {
    PreparedStatement stmt = null;
            Connection connection = LIBRAIRIE.getConnection();
    try {
        String sqlEmprunt = "SELECT abonne_id FROM emprunt WHERE ouvrage_id = ?";
        stmt = connection.prepareStatement(sqlEmprunt);
        stmt.setInt(1, ouvrage_id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            int id_abonne = rs.getInt("abonne_id");
            // Étape 2: Ajouter l'id_abonne à la table blacklist
            String sqlBlacklist = "INSERT INTO blacklist (abonne_id,date_blacklisted,nbr_ouvrage) VALUES (?,?,?)";
            stmt = connection.prepareStatement(sqlBlacklist);
            stmt.setInt(1, id_abonne);
           stmt.setDate(2, new java.sql.Date(System.currentTimeMillis()));
            stmt.setInt(3, 1);
            stmt.executeUpdate();
            
            // Étape 2: Modifier l'état de l'emprunt à 'volé'
            String sqlUpdateEmprunt = "UPDATE emprunt SET etat = 'volé' WHERE ouvrage_id = ? and etat='en cours'";
            stmt = connection.prepareStatement(sqlUpdateEmprunt);
            stmt.setInt(1, ouvrage_id);
            stmt.executeUpdate();
            stmt.close(); // Fermer le PreparedStatement précédent
            
            // Étape 3: Mettre à jour l'état de l'ouvrage dans la table ouvrages
            String sqlOuvrages = "UPDATE ouvrages SET etat = 'volé', disponibilite = 0 WHERE ouvrage_id = ?";
            stmt = connection.prepareStatement(sqlOuvrages);
            stmt.setInt(1, ouvrage_id);
            stmt.executeUpdate();

            // Étape 4: Mettre à jour l'état de la réservation si l'ouvrage est réservé
            String sqlReserve = "UPDATE ouvrage_reserve SET etat = 'annulé pour vol' WHERE ouvrage_id = ? AND etat = 'RESERVE'";
            stmt = connection.prepareStatement(sqlReserve);
            stmt.setInt(1, ouvrage_id);
            stmt.executeUpdate();
        }
        return true;
    } catch (SQLException e) {
       
        e.printStackTrace();
        return false;
    } finally {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    }


    

}

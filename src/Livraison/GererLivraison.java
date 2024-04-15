/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Livraison;

import com.raven.main.LIBRAIRIE;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Vector;

/**
 *
 * @author USER
 */
public class GererLivraison implements LivraisonInterface{
    
    
    public boolean passer_livraison(int abonne_id, int ouvrage_id, String adresse, String instruction,int num) {
        Connection connection = LIBRAIRIE.getConnection();
          String query = "INSERT INTO livraisonn (abonne_id, ouvrage_id, adresse, instruction, date_livraison,num_tel) VALUES (?, ?, ?, ?, ?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
               preparedStatement.setInt(1, abonne_id);
            preparedStatement.setInt(2, ouvrage_id);
            preparedStatement.setString(3, adresse);
            preparedStatement.setString(4, instruction);
            Date date_livraison = Date.valueOf(LocalDate.now());
            preparedStatement.setDate(5, date_livraison);
              preparedStatement.setInt(6, num);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Vector<Livraison> obtenir_livraisons() {
        Connection connection = LIBRAIRIE.getConnection();
        String query = "SELECT * FROM livraisonn";
        Vector<Livraison> livraisons = new Vector<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                // Récupération des données de chaque livraison
                int abonne_id = resultSet.getInt("abonne_id");
                int ouvrage_id = resultSet.getInt("ouvrage_id");
                String adresse = resultSet.getString("adresse");
                String instruction = resultSet.getString("instruction");
                Date date_livraison = resultSet.getDate("date_livraison");
                 int num = resultSet.getInt("num_tel");

                Livraison livraison = new Livraison(abonne_id, ouvrage_id, date_livraison,adresse, instruction,num);
                livraisons.add(livraison);
            }

            // Fermeture des ressources
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return livraisons;
    }

    @Override
    public boolean supprimer_livraison_livree(int id_livraison) {
    Connection connection = LIBRAIRIE.getConnection();
    String query = "DELETE FROM livraisonn WHERE id = ?";
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id_livraison);
        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
        }

   @Override
public int obtenir_id_livraison(int abonne_id, int ouvrage_id) {
    Connection connection = LIBRAIRIE.getConnection();
    String query = "SELECT id FROM livraisonn WHERE abonne_id = ? AND ouvrage_id = ?";
    
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, abonne_id);
        preparedStatement.setInt(2, ouvrage_id);
        
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("id");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    // Retourner -1 si aucune livraison correspondante n'a été trouvée
    return -1;
}

       @Override
    public boolean ajouter_declaration(Declaration d) {
  Connection connection = LIBRAIRIE.getConnection();
          String query = "INSERT INTO reclamation (abonne_id, repondre_tel, autre) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
               preparedStatement.setInt(1,d.getAbonne_id());
            preparedStatement.setBoolean(2, d.isRepondre_tel());
            preparedStatement.setString(3, d.getAutre());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }    }

    @Override
    public boolean id_abonne_existe(int abonne_id) {
 Connection connection = LIBRAIRIE.getConnection();
 boolean test=false;
        String query = "SELECT * FROM livraisonn where abonne_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1,abonne_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
               test=true;
            }
            // Fermeture des ressources
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return test;
    }

    @Override
    public int calculer_nbre_reservation() {
         Connection connection = LIBRAIRIE.getConnection();
        boolean test=false;
        int s=0;
        String query = "SELECT * FROM livraisonn ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               s++;
            }
            // Fermeture des ressources
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return s;
    }


 
}

package com.raven.service;

import com.raven.connection.DatabaseConnection;
import com.raven.model.ModelLogin;
import com.raven.model.ModelUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Random;
import org.mindrot.jbcrypt.BCrypt;

public class ServiceUser {
  public static int userID;
    public static int nbre_de_fois;
    public static String role;
    private final Connection con;
// Méthode pour hacher le mot de passe avec BCrypt
    private static String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    // Méthode pour vérifier le mot de passe avec BCrypt
    private static boolean checkPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
    
    
    public ServiceUser() {
        con = DatabaseConnection.getInstance().getConnection();
    }
    public ModelUser login(ModelLogin login) throws SQLException {
        role=getUserRoleByEmail(login.getEmail());
        ModelUser data = null ;

        if (role==null)
        {
            data = null;
        }
        else if (role.equals("abonne"))
        {          
        PreparedStatement p = con.prepareStatement("select id, UserName, email,mdp from `connexion_abonne` where BINARY(email)=? and `Status`='Verified' limit 1");
        p.setString(1, login.getEmail());
        ResultSet r = p.executeQuery();
        if (r.next()) {
            userID = r.getInt(1);
            String userName = r.getString(2);
            String email = r.getString(3);
            String password=r.getString(4);
            System.out.println(userID + " lignes insérées.");
    
              data = new ModelUser(userID, userName, email, "");
              incrementLoginCount(userID);
              nbre_de_fois=getLoginCount(userID) ;
        }
        r.close();
        p.close();
              
        }
        else 
        {
       PreparedStatement p = con.prepareStatement("select id, UserName, email,mdp from `connexion_employee` where BINARY(email)=?  limit 1");
        p.setString(1, login.getEmail());
        ResultSet r = p.executeQuery();
        if (r.next()) {
            userID = r.getInt(1);
            String userName = r.getString(2);
            String email = r.getString(3);
            String password=r.getString(4);
            System.out.println(userID + " lignes insérées.");
             data = new ModelUser(userID, userName, email, "");
             incrementLoginCount(userID);
            nbre_de_fois=getLoginCount(userID) ;
        }
        r.close();
        p.close();
             
            
            
        }
                   return data;


    }
    public String getUserRoleByEmail(String email) throws SQLException {
    String role = null;
    String query = "SELECT role FROM user WHERE email = ?";
    PreparedStatement statement = con.prepareStatement(query);
    statement.setString(1, email);
    ResultSet resultSet = statement.executeQuery();
    if (resultSet.next()) {
        role = resultSet.getString("role");
    }
    resultSet.close();
    statement.close();

    return role;
}

public void incrementLoginCount(int userId) throws SQLException {
    String query = "UPDATE connexion_abonne SET nbre_de_fois = nbre_de_fois + 1 WHERE id = ?";
    PreparedStatement statement = con.prepareStatement(query);
    statement.setInt(1, userId);
    int rowCount = statement.executeUpdate();
    System.out.println(rowCount + " lignes mises à jour.");
    statement.close();
}
public int getLoginCount(int userId) throws SQLException {
     nbre_de_fois = -1; 
    String query = "SELECT nbre_de_fois FROM connexion_abonne WHERE id = ?";
    PreparedStatement statement = con.prepareStatement(query);
    statement.setInt(1, userId);
    ResultSet resultSet = statement.executeQuery();
    if (resultSet.next()) {
        nbre_de_fois = resultSet.getInt("nbre_de_fois");
    }
    resultSet.close();
    statement.close();
    return nbre_de_fois;
}

  public void insertUser(ModelUser user) throws SQLException {
      System.out.println("kkkk");
      String mdp=user.getPassword();
      String mail=user.getEmail();
     String hashedPassword = hashPassword(mdp);
    PreparedStatement p = con.prepareStatement(
        "INSERT INTO connexion_abonne (UserName, email, mdp) VALUES (?, ?, ?)"
    );
    p.setString(1, user.getUserName());
    p.setString(2, user.getEmail());
    p.setString(3, hashedPassword);
    System.out.println("avant");
    int rowCount = p.executeUpdate();
    System.out.println(rowCount + " lignes insérées.");
    userID=getUserIdByEmail( user.getEmail());
    System.out.println(userID + " lignes insérées.");
     addUserRole( user.getEmail(),  "abonne");
}
  private void addUserRole(String email, String role) throws SQLException {
    PreparedStatement statement = con.prepareStatement(
        "INSERT INTO user (email, role) VALUES (?, ?)"
    );
    statement.setString(1, email);
    statement.setString(2, role);
    int rowCount = statement.executeUpdate();
    System.out.println(rowCount + " lignes insérées dans la table user_role.");
    statement.close();
}
  
public int getUserIdByEmail(String email) throws SQLException {
    int userId = -1; 
    String query = "SELECT id FROM connexion_abonne WHERE email = ?";
    PreparedStatement statement = con.prepareStatement(query);
    statement.setString(1, email);
    ResultSet resultSet = statement.executeQuery();
    if (resultSet.next()) {
        userId = resultSet.getInt("id");
    }
    resultSet.close();
    statement.close();
    return userId;
}

 

    public boolean checkDuplicateUser(String user) throws SQLException {
        boolean duplicate = false;
        PreparedStatement p = con.prepareStatement("select id from `connexion_abonne` where UserName=? and `Status`='Verified'");
        p.setString(1, user);
        ResultSet r = p.executeQuery();
       if (r.next()) {
            duplicate=true;
        }
        r.close();
        p.close();
        return duplicate;
    }

    public boolean checkDuplicateEmail(String user) throws SQLException {
        boolean duplicate = false;
        PreparedStatement p = con.prepareStatement("select id from `user` where email=?  ");
        p.setString(1, user);
        ResultSet r = p.executeQuery();
        if (r.next()) {
            duplicate=true;
        }
        r.close();
        p.close();
        return duplicate;
    }


    
}


package com.raven.projet_java_s2;
import  com.raven.go_db.tools_db;
import  com.raven.go.Tools;
import static com.raven.go_db.tools_db.con;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import static java.time.Clock.system;
import java.time.LocalDate;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class employee_service {
    public static abonne get_abonne(int id)
    {
        abonne a = new abonne(0);
        try {
            com.raven.go_db.tools_db.SetConnection("librairie");
            String query="select * from abonne where abonne_id= "+id;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if(rs.next()){
            a.setAbonne_id(rs.getInt("abonne_id"));
            a.setCin(rs.getInt("cin"));
            a.setDate_debut_abonnement(rs.getDate("date_debut_abonnement").toLocalDate());
            a.setDate_fin_abonnement(rs.getDate("date_fin_abonnement").toLocalDate());
            a.setDate_naissance(rs.getDate("date_naissance").toLocalDate());
            a.setNom(rs.getString("nom"));
            a.setPrenom(rs.getString("prenom"));
            a.setType_abonnement(rs.getString("type_abonnement"));
            /*System.out.println(e.getCin());
            System.out.println(e.toString());*/
            }
            /*else{
                System.out.println("Nothing is found");
            }*/
        } catch (SQLException ex) {
            System.out.println(ex);
            //Logger.getLogger(employee_service.class.getName()).log(Level.SEVERE, null, ex);
            a=null;
        }
      return a;
    }
    static Vector<abonne> vu = new Vector<>();
    public static Vector<abonne> get_all_abonne()
    {

        try{
                            com.raven.go_db.tools_db.SetConnection("librairie");

            String query = "Select * from abonne";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                abonne a = new abonne(0);
                a.setAbonne_id(rs.getInt("abonne_id"));
                a.setCin(rs.getInt("cin"));
                a.setDate_debut_abonnement(rs.getDate("date_debut_abonnement").toLocalDate());
                a.setDate_fin_abonnement(rs.getDate("date_fin_abonnement").toLocalDate());
                a.setDate_naissance(rs.getDate("date_naissance").toLocalDate());
                a.setNom(rs.getString("nom"));
                a.setPrenom(rs.getString("prenom"));
                a.setType_abonnement(rs.getString("type_abonnement"));
                vu.add(a);
                
            }
            
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        return vu;
        
    }
    public static Vector<abonne> get_all_abonne(int len,String name)
    {

        try{
                            com.raven.go_db.tools_db.SetConnection("librairie");

            String query = "Select * from abonne where LEFT(nom,"+len+")="+"'"+name+"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                abonne a = new abonne(0);
                a.setAbonne_id(rs.getInt("abonne_id"));
                a.setCin(rs.getInt("cin"));
                a.setDate_debut_abonnement(rs.getDate("date_debut_abonnement").toLocalDate());
                a.setDate_fin_abonnement(rs.getDate("date_fin_abonnement").toLocalDate());
                a.setDate_naissance(rs.getDate("date_naissance").toLocalDate());
                a.setNom(rs.getString("nom"));
                a.setPrenom(rs.getString("prenom"));
                a.setType_abonnement(rs.getString("type_abonnement"));
                vu.add(a);
                
            }
            
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        return vu;
        
    }
     
    public static abonne get_abonne_by_name(String nom)
    {
        abonne u = new abonne(0); 
        try {
                            com.raven.go_db.tools_db.SetConnection("librairie");

            String query = "select * from abonne where nom ='"+nom+"';";        
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            abonne a = new abonne(0);
            if(rs.next()){
                a.setAbonne_id(rs.getInt("abonne_id"));
                a.setCin(rs.getInt("cin"));
                a.setDate_debut_abonnement(rs.getDate("date_debut_abonnement").toLocalDate());
                a.setDate_fin_abonnement(rs.getDate("date_dfin_abonnement").toLocalDate());
                a.setDate_naissance(rs.getDate("date_naissnace").toLocalDate());
                a.setNom(rs.getString("nom"));
                a.setPrenom(rs.getString("prenom"));
                a.setType_abonnement(rs.getString("type_abonnement"));
            }
            else{
                System.out.println("no user found with this name");
            }              
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        return u; 
    }
    public static int dernier_id;
    public static int insert_abonne(abonne a) {
        int rowcount = 0;
        int insertedAbonneId = -1; // Valeur par défaut si aucun abonné n'a été inséré
        
        try {
             com.raven.go_db.tools_db.SetConnection("librairie");            
            int cin = a.getCin();
            String prenom = a.getPrenom();
            String nom = a.getNom();
            LocalDate date_naissance = a.getDate_naissance();
            String type_abonnement = a.getType_abonnement();
            LocalDate date_debut_abonnement = a.getDate_debut_abonnement();
            LocalDate date_fin_abonnement = a.getDate_fin_abonnement();
            
            String query = "INSERT INTO abonne (cin, prenom, nom, date_naissance, type_abonnement, date_debut_abonnement, date_fin_abonnement) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cin);
            ps.setString(2, prenom);
            ps.setString(3, nom);
            ps.setDate(4, java.sql.Date.valueOf(date_naissance));
            ps.setString(5, type_abonnement);
            ps.setDate(6, java.sql.Date.valueOf(date_debut_abonnement));
            ps.setDate(7, java.sql.Date.valueOf(date_fin_abonnement));
            
            rowcount = ps.executeUpdate();
            
            if (rowcount > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    dernier_id = generatedKeys.getInt(1);
                }
                System.out.println(dernier_id);
            }
            
            con.close(); // Fermer la connexion
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return insertedAbonneId;
    }


    
    public static boolean update_abonne(abonne a)
    {
        int rowcount=0;
        try{
             com.raven.go_db.tools_db.SetConnection("librairie");
            String query="update abonne set abonne_id=?,cin=?,prenom=?,nom=?,date_naissance=?,type_abonnement=?,date_debut_abonnement=?,date_fin_abonnement=? where abonne_id =? ";
            PreparedStatement pstm= con.prepareStatement(query);
            pstm.setInt(1,a.getAbonne_id());
            pstm.setInt(2,a.getCin());
            pstm.setString(3,a.getPrenom());
            pstm.setString(4,a.getNom());
            pstm.setDate(5,java.sql.Date.valueOf(a.getDate_naissance()));
            pstm.setString(6,a.getType_abonnement());
            pstm.setDate(7,java.sql.Date.valueOf(a.getDate_debut_abonnement()));
            pstm.setDate(8,java.sql.Date.valueOf(a.getDate_debut_abonnement()));
            pstm.setInt(9,a.getAbonne_id());
            rowcount = pstm.executeUpdate();
            insert_action("Update",a.getAbonne_id(),1);
   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        return (rowcount>0);
    }
    
   public static boolean delete_abonne(int abonne_id) {
    int rowcount = 0;
    try {
        com.raven.go_db.tools_db.SetConnection("librairie");
        String queryAbonne = "DELETE FROM abonne WHERE abonne_id = ?";
        PreparedStatement psAbonne = con.prepareStatement(queryAbonne);
        psAbonne.setInt(1, abonne_id);
        rowcount = psAbonne.executeUpdate();
        String queryConnexionAbonne = "DELETE FROM connexion_abonne WHERE id = ?";
        PreparedStatement psConnexionAbonne = con.prepareStatement(queryConnexionAbonne);
        psConnexionAbonne.setInt(1, abonne_id);
        rowcount += psConnexionAbonne.executeUpdate();
        insert_action("Delete", abonne_id, 1);
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
    }
    return (rowcount > 0);
}

    public static boolean insert_action(String action,int abonne_id,int employee_id)
    {
                        com.raven.go_db.tools_db.SetConnection("librairie");

        LocalDate date = LocalDate.now();
        int rowcount=0;
        try{
            String query = "insert into history (action,date_action,employee_id,abonne_id) values('"+action+"','"+date+"','"+employee_id+"','"+abonne_id+"');";
            Statement st = con.createStatement();
            rowcount = st.executeUpdate(query);
            System.out.println(rowcount);
        }
         catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        return(rowcount>0);
    }
    }


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.projet_java_s2;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Date;
import java.util.Vector;

import static com.raven.go_db.tools_db.con;

import static com.raven.go_db.tools_db.con;
import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author saif
 */
public class abonne_service {
    public static boolean modifierEmail(String who, String nouv_adresse, int id) {
        int row_affected = 0;
        try {
            com.raven.go_db.tools_db.SetConnection("librairie");
            String queryGetOldEmail ;
              if (who.equals("abonne"))
             {
                queryGetOldEmail = "SELECT email FROM connexion_abonne WHERE id = ?";
            }
             else
             {
                queryGetOldEmail = "SELECT email FROM connexion_employee  WHERE id = ?";

             }
            PreparedStatement psGetOldEmail = con.prepareStatement(queryGetOldEmail);
            psGetOldEmail.setInt(1, id);
            ResultSet rs = psGetOldEmail.executeQuery();
            String old_email = null;
            if (rs.next()) {
                old_email = rs.getString("email");
            }
            String queryUpdateUserEmail = "UPDATE user SET email = ? WHERE email = ?";
            PreparedStatement psUpdateUserEmail = con.prepareStatement(queryUpdateUserEmail);
            psUpdateUserEmail.setString(1, nouv_adresse);
            psUpdateUserEmail.setString(2, old_email);
            row_affected += psUpdateUserEmail.executeUpdate();
            String queryUpdateConnexionTable = "";
            if (who.equals("employee")) {
                queryUpdateConnexionTable = "UPDATE connexion_employee  SET email = ? WHERE id = ?";
            } else if (who.equals("abonne")) {
                queryUpdateConnexionTable = "UPDATE connexion_abonne SET email = ? WHERE id = ?";
            }
            PreparedStatement psUpdateConnexionTable = con.prepareStatement(queryUpdateConnexionTable);
            psUpdateConnexionTable.setString(1, nouv_adresse);
            psUpdateConnexionTable.setInt(2, id);
            row_affected += psUpdateConnexionTable.executeUpdate();
            if (row_affected > 0) {
                JOptionPane.showMessageDialog(null, "L'email a été modifié avec succès.", "", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }

        return (row_affected > 0);
    }


    public static boolean modifierAdresse(String who,String nouv_Adr, int id) {
                      com.raven.go_db.tools_db.SetConnection("librairie");
        int row_affected = 0;
        String query="";
        try{
            if(who.equals("employee")){
                query = "UPDATE connexion_employee set adresse = ? where id=?";
            }else if(who.equals("abonne")){
                query = "UPDATE connexion_abonne set adresse = ? where id=?";
            }
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1,nouv_Adr);
            st.setInt(2, id);
            row_affected = st.executeUpdate();
            
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
        
    return (row_affected>0);
    }
    public static boolean modifierMdp(String who,String nouv_Mdp, int id)
    {
        int row_affected = 0;
        String query="";
        try{
            com.raven.go_db.tools_db.SetConnection("librairie");
            if(who.equals("employee")){
                query = "UPDATE connexion_employee set mdp = ? where id=?";
            }else if(who.equals("abonne")){
                query = "UPDATE connexion_abonne set mdp = ? where id=?";
            }
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1,nouv_Mdp);
            st.setInt(2, id);
            row_affected = st.executeUpdate();
            
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
        
    return (row_affected>0);
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
    
    static Vector<history> vh = new Vector<>();
    
    public static Vector get_all_history()
    {
        try{
                                  com.raven.go_db.tools_db.SetConnection("librairie");

            String query="select * from history";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                history h = new history(0);
                h.setAction_id(rs.getInt("action_id"));
                h.setAction(rs.getString("action"));
                h.setDate_action(rs.getDate("date_action").toLocalDate());
                h.setEmployee_id(rs.getInt("employee_id"));
                h.setAbonne_id(rs.getInt("abonne_id"));
                vh.add(h);
                
            }
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        return vh;  
    }
    public static Vector get_all_history(int IdEmp,int IdAbonn)
    {
        try{
                                  com.raven.go_db.tools_db.SetConnection("librairie");

            String query="select * from history where employee_id="+IdEmp+" and abonne_id="+IdAbonn;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                history h = new history(0);
                h.setAction_id(rs.getInt("action_id"));
                h.setAction(rs.getString("action"));
                h.setDate_action(rs.getDate("date_action").toLocalDate());
                h.setEmployee_id(rs.getInt("employee_id"));
                h.setAbonne_id(rs.getInt("abonne_id"));
                vh.add(h);
                
            }
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        return vh;  
    }
    public static Vector get_all_history(int IdEmp)
    {
        try{
                                  com.raven.go_db.tools_db.SetConnection("librairie");

            String query="select * from history where employee_id = "+IdEmp;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                history h = new history(0);
                h.setAction_id(rs.getInt("action_id"));
                h.setAction(rs.getString("action"));
                h.setDate_action(rs.getDate("date_action").toLocalDate());
                h.setEmployee_id(rs.getInt("employee_id"));
                h.setAbonne_id(rs.getInt("abonne_id"));
                vh.add(h);
                
            }
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        return vh;  
    }
    public static Vector get_all_history(int IdAbonn,String ha)
    {
        try{
                                  com.raven.go_db.tools_db.SetConnection("librairie");

            String query="select * from history where abonne_id = "+IdAbonn;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                history h = new history(0);
                h.setAction_id(rs.getInt("action_id"));
                h.setAction(rs.getString("action"));
                h.setDate_action(rs.getDate("date_action").toLocalDate());
                h.setEmployee_id(rs.getInt("employee_id"));
                h.setAbonne_id(rs.getInt("abonne_id"));
                vh.add(h);
                
            }
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        return vh;  
    }
    public static int check_abonne(int id)
    {
        int rows=0;
        LocalDate date1 = LocalDate.now();
        Date sqldate = Date.valueOf(date1);
        try{
                                  com.raven.go_db.tools_db.SetConnection("librairie");

            
            String query="select * from emprunt where id="+id+" AND date_fin_effective<'"+date1+"' AND etat<>'retourner'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next())
            {
                rows++;
            }
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            //return false;
        }
        JOptionPane.showMessageDialog(null,rows+" "+date1);
        return rows;
    }
    public static boolean insert_black_listed(int id,int id_ouvrage)
    {   
        int affected_rows=0;
        LocalDate date1 = LocalDate.now();
        Date sqlDate = Date.valueOf(date1);
        try{
            com.raven.go_db.tools_db.SetConnection("librairie");
            String query="insert into blacklist values("+id+",'"+date1+"',"+id_ouvrage+");";
            Statement st = con.createStatement();
            affected_rows = st.executeUpdate(query);
            
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
        return (affected_rows>0);
    }
    
    public static Vector<Blacklist> getBlacklistData(int abonne_id) {
        Vector<Blacklist> blacklistEntries = new Vector<>();
        Statement st = null;
        ResultSet rs = null;

        try {
            com.raven.go_db.tools_db.SetConnection("librairie");
        String query = "SELECT * FROM blacklist WHERE id=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, abonne_id);

            rs = pst.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id");
                Date date = rs.getDate("date_blacklisted");
                int idOuvrage = rs.getInt("ouvrage_id");
                Blacklist entry;
                entry = new Blacklist(id, date, idOuvrage);
                blacklistEntries.add(entry);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return blacklistEntries;
    }
    
    
    public static boolean chercher_black_listed(int id)
    {
        int rows=0;
        LocalDate date1 = LocalDate.now();
        try{
                                  com.raven.go_db.tools_db.SetConnection("librairie");

            String query="select * from blacklist where id="+id;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next())
            {
                rows++;
            }
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
        JOptionPane.showMessageDialog(null,rows+" "+date1);
        return (rows >0);
    }
    
    public static boolean delete_black_listed(int id)
    {
        int rowcount = 0;
        try{
                                  com.raven.go_db.tools_db.SetConnection("librairie");

            String query = "delete from blacklist where abonne_id="+id;
            Statement st = con.createStatement();
            rowcount = st.executeUpdate(query);
            System.out.println(rowcount);
            
        }
         catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        return (rowcount>0);
        
    }
}

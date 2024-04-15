/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.raven.main;


import java.sql.*;
/**
 *
 * @author USER
 */
public class LIBRAIRIE {

    /**
     * @param args the command line arguments
     */

     public static final String url="jdbc:mysql://localhost/librairie";
	public static final String login="root";
	public static final  String mdp="";
   public static  Connection getConnection() //static : unique dans tout le projet , on peut pas la redefinir
	{
		Connection connection=null;
		try {
			connection=DriverManager.getConnection(url,login,mdp);
			System.out.println("Connection réussie...");
			} catch (SQLException e) {
			System.out.println("Connexion échouée....");
			e.printStackTrace();
			}
		return connection;	
	}
    public static void main(String[] args) {

        // TODO code application logic here
        Connection connection = LIBRAIRIE.getConnection();
        /*Acces a=new Acces();
        a.setVisible(true);*/
        
    }
    
}

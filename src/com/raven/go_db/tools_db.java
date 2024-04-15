package com.raven.go_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author saif
 */
public class tools_db {
    protected static String url="";
    public static Connection con;
    public static void setUrl(String DBname)
    {
        url="jdbc:mysql://localhost:3306/" + DBname + "?useUnicode=true&characterEncoding=UTF-8";
    }
    public static void SetConnection(String DBname)
    {
        try {
            setUrl(DBname);
            con = DriverManager.getConnection(url, "root", "");
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        
    }
}

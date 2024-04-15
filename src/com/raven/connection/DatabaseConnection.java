package com.raven.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    private DatabaseConnection() {

    }
        public static final String url="jdbc:mysql://localhost/librairie";
	public static final String login="root";
	public static final  String mdp="";
    public void connectToDatabase() throws SQLException {
        
        Connection connection = getConnection();
    }

    public Connection getConnection() {
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

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}

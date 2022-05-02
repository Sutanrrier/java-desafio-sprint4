package br.com.sutanrrier.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	private static Connection conn = null;
	
	public static Connection getConnection() {
		try {
			if(conn == null) {
				String url = "jdbc:postgresql://localhost:5432/desafiosprint";
				String user = "postgres";
				String senha = "senh@";
				
				conn = DriverManager.getConnection(url, user, senha);
			}
		}
		catch(SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return conn;
	}
}

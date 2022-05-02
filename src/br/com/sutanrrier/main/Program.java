package br.com.sutanrrier.main;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.sutanrrier.db.DB;

public class Program {
	public static void main(String[] args) {
		try {
			Connection conn = DB.getConnection();
			
			conn.close();
		}
		catch(SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}

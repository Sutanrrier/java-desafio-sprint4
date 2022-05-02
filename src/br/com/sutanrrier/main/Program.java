package br.com.sutanrrier.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import br.com.sutanrrier.db.DB;
import br.com.sutanrrier.model.entities.Estacionamento;
import br.com.sutanrrier.model.jdbc.CarroJDBC;
import br.com.sutanrrier.model.jdbc.EstacionamentoJDBC;

public class Program {
	public static void main(String[] args) {
		try {
			Connection conn = DB.getConnection();
			
			CarroJDBC carroJDBC = new CarroJDBC(conn);
			EstacionamentoJDBC estacionamentoJDBC = new EstacionamentoJDBC(conn);
			
			//Inserindo Estacionamento
			estacionamentoJDBC.insert(new Estacionamento(1, "Estacionamento Rio Mar", Date.valueOf(LocalDate.now())));
			
			conn.close();
		}
		catch(SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}

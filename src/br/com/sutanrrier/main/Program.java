package br.com.sutanrrier.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import br.com.sutanrrier.db.DB;
import br.com.sutanrrier.model.entities.Carro;
import br.com.sutanrrier.model.entities.Estacionamento;
import br.com.sutanrrier.model.jdbc.CarroJDBC;
import br.com.sutanrrier.model.jdbc.EstacionamentoJDBC;

public class Program {
	public static void main(String[] args) {
		
		Estacionamento estacionamento1 = new Estacionamento(1, "Estacionamento Rio Mar", Date.valueOf(LocalDate.now()));
		Carro carro1 = new Carro(1, "Branco", "HYS-1816", 300.0, Date.valueOf(LocalDate.now()), 1);
		Carro carro2 = new Carro(2, "Azul", "HUY-0038", 320.0, Date.valueOf(LocalDate.now()), 1);
		
		try {
			Connection conn = DB.getConnection();
			
			CarroJDBC carroJDBC = new CarroJDBC(conn);
			EstacionamentoJDBC estacionamentoJDBC = new EstacionamentoJDBC(conn);
			
			// Inserindo elementos
			estacionamentoJDBC.insert(estacionamento1);
			carroJDBC.insert(carro1);
			carroJDBC.insert(carro2);
			
			// Atualizando elementos
			//estacionamentoJDBC.update(estacionamento1);
			//carroJDBC.update(carro1);
			
			// Listar Elementos
			List<Carro> listaCarros = carroJDBC.selectAll();
			for(Carro carro : listaCarros) {
				System.out.println(carro);
			}
			
			List<Estacionamento> listaEstacionamentos = estacionamentoJDBC.selectAll();
			for(Estacionamento estacionamento : listaEstacionamentos) {
				System.out.println(estacionamento);
			}
			//Fechando conexão
			conn.close();
		}
		catch(SQLException e) {
			System.out.println("Erro! -> " + e.getMessage());
		}
	}
}

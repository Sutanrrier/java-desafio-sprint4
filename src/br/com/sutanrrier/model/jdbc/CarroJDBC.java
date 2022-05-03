package br.com.sutanrrier.model.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.sutanrrier.model.entities.Carro;
import br.com.sutanrrier.model.jdbc.interfaces.CarroSQLMethods;

public class CarroJDBC implements CarroSQLMethods {

	private Connection conn;
	
	//Construtor
	public CarroJDBC(Connection conn) {
		this.conn = conn;
	}
	
	//Métodos
	@Override
	public void insert(Carro obj) {
		try {
			PreparedStatement statement = conn.prepareStatement(""
					+ "insert into carro (id, cor, placa, velocidademax, datacriacao, estacionamento_id)"
					+ "values (?, ?, ?, ?, ?, ?)");
			statement.setInt(1, obj.getId());
			statement.setString(2, obj.getCor());
			statement.setString(3, obj.getPlaca());
			statement.setDouble(4, obj.getVelocidademax());
			statement.setDate(5, obj.getDataCriacao());
			statement.setInt(6, obj.getIdEstacionamento());
			int linhas = statement.executeUpdate();
			
			System.out.println(linhas + " linhas alteradas!");
		}
		catch(SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	@Override
	public void update(Carro obj) {
		
	}

	@Override
	public void deleteById(Integer id) {
		
	}

	@Override
	public List<Carro> selectAll() {
		
		return null;
	}
	
}

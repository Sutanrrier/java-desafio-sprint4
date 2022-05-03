package br.com.sutanrrier.model.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
			
			statement.close();
		}
		catch(SQLException e) {
			System.out.println("Erro! -> " + e.getMessage());
		}
	}

	@Override
	public void update(Carro obj) {
		try {
			PreparedStatement statement = conn.prepareStatement("UPDATE carro "
					+ "SET placa = 'SEM PLACA'"
					+ "WHERE id = ?");
			statement.setInt(1, obj.getId());
			int linhas = statement.executeUpdate();
			
			System.out.println(linhas + " linhas alteradas!");

			statement.close();
		}
		catch(SQLException e) {
			System.out.println("Erro! -> " + e.getMessage());
		}
	}

	@Override
	public void deleteById(Integer id) {
		try {
			PreparedStatement statement = conn.prepareStatement("DELETE FROM carro "
					+ "WHERE id = ?");
			statement.setInt(1, id);
			int linhas = statement.executeUpdate();
			
			System.out.println(linhas + " linhas alteradas!");
			
			statement.close();
		}
		catch(SQLException e) {
			System.out.println("Erro! -> " + e.getMessage());
		}
	}

	@Override
	public List<Carro> selectAll() {
		List<Carro> listaCarros = new ArrayList<>();
		
		try {
			Statement statement = conn.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT * FROM carro");
			
			while(resultado.next()) {
				Carro carro = new Carro(
						resultado.getInt("id"),
						resultado.getString("cor"),
						resultado.getString("placa"),
						resultado.getDouble("velocidademax"),
						resultado.getDate("datacriacao"),
						resultado.getInt("estacionamento_id"));
				
				listaCarros.add(carro);
			}
			
			resultado.close();
			statement.close();
		} 
		catch (SQLException e) {
			System.out.println("Erro! -> " + e.getMessage());;
		}
		return listaCarros;
	}
	
}

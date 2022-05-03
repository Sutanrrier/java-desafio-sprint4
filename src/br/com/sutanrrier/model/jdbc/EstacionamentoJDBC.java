package br.com.sutanrrier.model.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.sutanrrier.model.entities.Estacionamento;
import br.com.sutanrrier.model.jdbc.interfaces.EstacionamentoSQLMethods;

public class EstacionamentoJDBC implements EstacionamentoSQLMethods{
	
	private Connection conn;
	
	//Construtor
	public EstacionamentoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	//Métodos
	@Override
	public void insert(Estacionamento obj) {
		try {
			PreparedStatement statement = conn.prepareStatement(""
					+ "insert into estacionamento (id, nome, datacriacao)"
					+ "values (?, ?, ?)");
			statement.setInt(1, obj.getId());
			statement.setString(2, obj.getNome());
			statement.setDate(3, obj.getDataCriacao());
			int linhas = statement.executeUpdate();
			
			System.out.println(linhas + " linhas alteradas!");
		}
		catch(SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	@Override
	public void update(Estacionamento obj) {
		try {
			PreparedStatement statement = conn.prepareStatement("UPDATE estacionamento "
					+ "SET nome = 'Estacionamento Zé Graça'"
					+ "WHERE id = ?");
			statement.setInt(1, obj.getId());
			int linhas = statement.executeUpdate();
			
			System.out.println(linhas + " linhas alteradas!");
		}
		catch(SQLException e) {
			System.out.println("Erro! -> " + e.getMessage());
		}
	}

	@Override
	public void deleteById(Integer id) {
		try {
			PreparedStatement statement = conn.prepareStatement("DELETE FROM estacionamento "
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
	public List<Estacionamento> selectAll() {
		List<Estacionamento> listaEstacionamento = new ArrayList<>();
		
		try {
			Statement statement = conn.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT * FROM estacionamento");
			
			while(resultado.next()) {
				Estacionamento estacionamento = new Estacionamento(
						resultado.getInt("id"),
						resultado.getString("nome"),
						resultado.getDate("datacriacao"));	
						
				listaEstacionamento.add(estacionamento);
			}
			
			resultado.close();
			statement.close();
		} 
		catch (SQLException e) {
			System.out.println("Erro! -> " + e.getMessage());;
		}
		return listaEstacionamento;
	}

}

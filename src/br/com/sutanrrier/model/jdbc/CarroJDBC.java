package br.com.sutanrrier.model.jdbc;

import java.sql.Connection;
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

package br.com.sutanrrier.model.jdbc;

import java.sql.Connection;
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
		
	}

	@Override
	public void update(Estacionamento obj) {
		
	}

	@Override
	public void deleteById(Integer id) {
		
	}

	@Override
	public List<Estacionamento> selectAll() {

		return null;
	}

}

package br.com.sutanrrier.model.jdbc.interfaces;

import java.util.List;

import br.com.sutanrrier.model.entities.Carro;

public interface CarroSQLMethods {
	public void insert(Carro obj);
	public void update(Carro obj);
	public void deleteById(Integer id);
	public List<Carro> selectAll();
}

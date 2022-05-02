package br.com.sutanrrier.model.jdbc.interfaces;

import java.util.List;

import br.com.sutanrrier.model.entities.Estacionamento;

public interface EstacionamentoSQLMethods {
	public void insert(Estacionamento obj);
	public void update(Estacionamento obj);
	public void deleteById(Integer id);
	public List<Estacionamento> selectAll();
}

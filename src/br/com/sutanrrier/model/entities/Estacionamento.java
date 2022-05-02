package br.com.sutanrrier.model.entities;

import java.sql.Date;
import java.util.Objects;

public class Estacionamento {
	private Integer id;
	private String nome;
	private Date dataCriacao;
	
	//Construtores
	public Estacionamento(Integer id, String nome, Date dataCriacao) {
		this.id = id;
		this.nome = nome;
		this.dataCriacao = dataCriacao;
	}

	public Estacionamento() {
		
	}
	
	//Getters e Setters
	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	//HashCode e equals
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estacionamento other = (Estacionamento) obj;
		return Objects.equals(id, other.id);
	}
	
}

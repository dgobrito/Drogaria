package br.pro.delfino.drogaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Cidade extends GenericDomain {
	@Column(length = 50, nullable = false)
	private String nome;

	/*
	 * 1 Estado pode ter muitas cidades 1 Cidade tem 1 estado Muitas cidades
	 * pertence a 1 estado, ou seja, Many To One (Muitos pra 1)
	 */
	@ManyToOne
	@JoinColumn(nullable = false) // Anotação para chave estrangeira
	private Estado estado;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}

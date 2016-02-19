package br.pro.delfino.drogaria.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("serial") // Ignora warnings do tipo serial nessa classe
@MappedSuperclass // Identifica que essa classe não terá uma tabela no banco e sim servirá apenas de base  
public class GenericDomain implements Serializable {
	@Id // Identifica que é chave primária
	@GeneratedValue(strategy = GenerationType.AUTO) // Auto incremento do campo, informa que o banco deve controlar o código
	private Long codigo;
	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
}

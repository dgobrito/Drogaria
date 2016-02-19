package br.pro.delfino.drogaria.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Produto extends GenericDomain {
	@Column(length = 80, nullable = false)
	private String descricao;

	/*
	 * Sempre usar o nome da classe dos tipos, pois caso utilize os tipos
	 * primitivos short, int ou outros, o campo será criado com valor zero e não
	 * como null, dificultando na view e controller.
	 */
	@Column(nullable = false)
	private Short quantidade;

	/*
	 * precision: como precisa de 4 digitos antes da virgula e 2 depois da
	 * virgula, será 6. scale: Quantos digitos na vírgula
	 */
	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal preco;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Fabricante fabricante;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Short getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Short quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
}

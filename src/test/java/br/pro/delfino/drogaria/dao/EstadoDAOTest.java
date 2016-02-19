package br.pro.delfino.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drogaria.domain.Estado;

public class EstadoDAOTest {
	@Test
	@Ignore // Não roda o teste
	public void salvar() {
		Estado estado = new Estado();
		estado.setNome("São Paulo");
		estado.setSigla("SP");

		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
	}

	@Test
	@Ignore
	public void listar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.listar();
		
		System.out.println("Total de Registros Encontrados: " + resultado.size());
		
		for (Estado estado : resultado) {
			System.out.println(estado.getCodigo() + " - " + estado.getNome() + " - " + estado.getSigla());
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 10L;		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if (estado == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out.println("Registro Encontrado:");
			System.out.println(estado.getCodigo() + " - " + estado.getNome() + " - " + estado.getSigla());			
		}		
	}
	
	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if (estado == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			estadoDAO.excluir(estado);
			System.out.println("Registro removido:");
			System.out.println(estado.getCodigo() + " - " + estado.getNome() + " - " + estado.getSigla());			
		}	
	}
	
	@Test
	@Ignore
	public void editar() {
		Long codigo = 6L;		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if (estado == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro editado - Antes:");
			System.out.println(estado.getCodigo() + " - " + estado.getNome() + " - " + estado.getSigla());
			
			estado.setNome("Paraíba");
			estado.setSigla("PB");
			estadoDAO.editar(estado);
			
			System.out.println("Registro editado - Depois:");
			System.out.println(estado.getCodigo() + " - " + estado.getNome() + " - " + estado.getSigla());
		}
	}
}

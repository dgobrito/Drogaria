package br.pro.delfino.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drogaria.domain.Fabricante;

public class FabricanteDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("Biolab");

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.salvar(fabricante);
	}

	@Test
	@Ignore
	public void listar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		List<Fabricante> resultado = fabricanteDAO.listar();

		System.out.println("Total de Registros Encontrados: " + resultado.size());

		for (Fabricante fabricante : resultado) {
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		if (fabricante == null) {
			System.out.println("Nenhum fabricante encontrado.");
		} else {
			System.out.println("Registro Encontrado:");
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		}
	}
	
	@Test
	@Ignore
	public void excluir() {
		Long codigo = 4L;		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		if (fabricante == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			fabricanteDAO.excluir(fabricante);
			System.out.println("Registro Removido:");
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		}
	}
	
	@Test
	@Ignore
	public void editar() {
		Long codigo = 3L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		if (fabricante == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out.println("Registro editado - Antes:");
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
			
			fabricante.setDescricao("Ultrafarma");
			fabricanteDAO.editar(fabricante);
			
			System.out.println("Registro editado - Depois:");
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		}		
	}
	
	@Test
	public void merge() {
		/*
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("Aché");
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.merge(fabricante);
		*/
		
		/*
		 * Se a chave primária estiver vazia inclui, senão busca no banco e edita
		 */
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(3L);
		fabricante.setDescricao("Fabricante C");
		fabricanteDAO.merge(fabricante);
	}
}

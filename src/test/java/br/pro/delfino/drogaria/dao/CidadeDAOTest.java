package br.pro.delfino.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drogaria.domain.Cidade;
import br.pro.delfino.drogaria.domain.Estado;

public class CidadeDAOTest {
	@Test
	@Ignore
	public void salvar() {
		/*
		 * Antes de gravar dados em uma entidade que possui chave estrangeira, a
		 * entidade Pai deve ser pesquisada antes, para depois gravar na
		 * entidade Filha
		 */

		EstadoDAO estadoDAO = new EstadoDAO();

		Long codigoEstado = 1L;
		Estado estado = estadoDAO.buscar(codigoEstado);

		if (estado != null) {
			Cidade cidade = new Cidade();
			cidade.setNome("Campinas");
			cidade.setEstado(estado);

			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.salvar(cidade);
		} else {
			System.out.println("Nenhum estado encontrado.");
		}
	}

	@Test
	@Ignore
	public void listar() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.listar();

		for (Cidade cidade : resultado) {
			System.out.println("Código da Cidade: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNome());
			System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
			System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
			System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
			System.out.println();
		}
	}

	@Test
	//@Ignore
	public void buscar() {
		CidadeDAO cidadeDAO = new CidadeDAO();

		Long codigoCidade = 1L;
		Cidade cidade = cidadeDAO.buscar(codigoCidade);

		if (cidade != null) {
			System.out.println("Código da Cidade: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNome());
			System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
			System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
			System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
		} else {
			System.out.println("Nenhuma registro encontrado.");
		}
	}
	
	@Test
	@Ignore
	public void excluir() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		
		Long codigoCidade = 3L;
		Cidade cidade = cidadeDAO.buscar(codigoCidade);
		
		if (cidade != null) {
			cidadeDAO.excluir(cidade);
			
			System.out.println("Cidade removida:");
			System.out.println("Código da Cidade: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNome());
			System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
			System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
			System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());		
		} else {
			System.out.println("Nenhuma cidade encontrada.");
		}
	}
	
	@Test
	@Ignore
	public void editar() {		
		EstadoDAO estadoDAO = new EstadoDAO();
		Long codigoEstado = 7L;
		Estado estado = estadoDAO.buscar(codigoEstado);		
		
		CidadeDAO cidadeDAO = new CidadeDAO();		
		Long codigoCidade = 5L;
		Cidade cidade = cidadeDAO.buscar(codigoCidade);
		
		if (estado == null) {
			System.out.println("Nenhum estado encontrado.");
		} else if (cidade == null) {
			System.out.println("Nenhuma cidade encontrada.");			
		} else {			
			System.out.println("Cidade a ser editada:");
			System.out.println("Código da Cidade: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNome());
			System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
			System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
			System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
			System.out.println();
			
			cidade.setNome("Guarapuava");
			cidade.setEstado(estado);			
			cidadeDAO.editar(cidade);
			
			System.out.println("Cidade editada:");
			System.out.println("Código da Cidade: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNome());
			System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
			System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
			System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());		
		}
	}
}
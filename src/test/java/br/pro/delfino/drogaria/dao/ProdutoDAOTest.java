package br.pro.delfino.drogaria.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drogaria.domain.Fabricante;
import br.pro.delfino.drogaria.domain.Produto;

public class ProdutoDAOTest {

	@Test
	@Ignore
	public void salvar() {
		
		/*
		 * Comentário para teste do Git
		 */

		Long codigoFabricante = 1L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigoFabricante);

		if (fabricante != null) {
			Produto produto = new Produto();
			produto.setDescricao("Dipirona");
			produto.setFabricante(fabricante);
			produto.setQuantidade(new Short("10"));
			produto.setPreco(new BigDecimal("7.42"));

			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.salvar(produto);
		} else {
			System.out.println("Nenhum fabricante encontrado.");
		}
	}

	@Test
	@Ignore
	public void listar() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> resultado = produtoDAO.listar();

		for (Produto produto : resultado) {
			System.out.println("Código do Produto: " + produto.getCodigo());
			System.out.println("Descrição do Produto: " + produto.getDescricao());
			System.out.println("Código do Fabricante: " + produto.getFabricante().getCodigo());
			System.out.println("Descrição do Fabricante: " + produto.getFabricante().getDescricao());
			System.out.println("Quantidade do Produto: " + produto.getQuantidade());
			System.out.println("Preço do Produto: " + produto.getPreco());
			System.out.println("------------------------------------------------------------------");
		}

	}

	@Test
	@Ignore
	public void buscar() {
		Long codigoProduto = 1L;
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		Produto produto = produtoDAO.buscar(codigoProduto);
		
		if (produto != null) {
			System.out.println("Código do Produto: " + produto.getCodigo());
			System.out.println("Descrição do Produto: " + produto.getDescricao());
			System.out.println("Código do Fabricante: " + produto.getFabricante().getCodigo());
			System.out.println("Descrição do Fabricante: " + produto.getFabricante().getDescricao());
			System.out.println("Quantidade do Produto: " + produto.getQuantidade());
			System.out.println("Preço do Produto: " + produto.getPreco());					
		} else {
			
		}
	}

	@Test
	@Ignore
	public void excluir() {
		
		Long codigoProduto = 3L; 
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		Produto produto = produtoDAO.buscar(codigoProduto);
		
		if (produto != null) {
			produtoDAO.excluir(produto);
			
			System.out.println("Produto removido com sucesso:");
			System.out.println("Código do Produto: " + produto.getCodigo());
			System.out.println("Descrição do Produto: " + produto.getDescricao());
			System.out.println("Código do Fabricante: " + produto.getFabricante().getCodigo());
			System.out.println("Descrição do Fabricante: " + produto.getFabricante().getDescricao());
			System.out.println("Quantidade do Produto: " + produto.getQuantidade());
			System.out.println("Preço do Produto: " + produto.getPreco());		
		} else {
			System.out.println("Nenhum produto para exclusão encontrado.");
		}
	}

	@Test
	@Ignore
	public void editar() {
		
		Long codigoFabricante = 2L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigoFabricante);	
		
		Long codigoProduto = 1L; 
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		Produto produto = produtoDAO.buscar(codigoProduto);
		
		if (produto == null) {
			System.out.println("Produto não encontrado para edição.");						
		} else if (fabricante == null) {
			System.out.println("Fabricante não encontrado para edição.");
		} else {
			System.out.println("Produto a ser editado:");
			System.out.println("Código do Produto: " + produto.getCodigo());
			System.out.println("Descrição do Produto: " + produto.getDescricao());
			System.out.println("Código do Fabricante: " + produto.getFabricante().getCodigo());
			System.out.println("Descrição do Fabricante: " + produto.getFabricante().getDescricao());
			System.out.println("Quantidade do Produto: " + produto.getQuantidade());
			System.out.println("Preço do Produto: " + produto.getPreco());
			System.out.println();
			
			produto.setDescricao("Cataflan");
			produto.setFabricante(fabricante);
			produto.setPreco(new BigDecimal("16.42"));
			produto.setQuantidade(new Short("42"));
			
			produtoDAO.editar(produto);
			
			System.out.println("Produto editado:");
			System.out.println("Código do Produto: " + produto.getCodigo());
			System.out.println("Descrição do Produto: " + produto.getDescricao());
			System.out.println("Código do Fabricante: " + produto.getFabricante().getCodigo());
			System.out.println("Descrição do Fabricante: " + produto.getFabricante().getDescricao());
			System.out.println("Quantidade do Produto: " + produto.getQuantidade());
			System.out.println("Preço do Produto: " + produto.getPreco());
			System.out.println();				
		}
	}
}

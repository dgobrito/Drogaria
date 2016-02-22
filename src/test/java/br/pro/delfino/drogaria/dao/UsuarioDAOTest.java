package br.pro.delfino.drogaria.dao;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drogaria.domain.Pessoa;
import br.pro.delfino.drogaria.domain.Usuario;

public class UsuarioDAOTest {
	
	@Test
	@Ignore
	public void salvar() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		Long codigoPessoa = 1L;
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);
		
		Usuario usuario = new Usuario();
		usuario.setSenha("123456");
		usuario.setTipo('A');
		usuario.setAtivo(true);
		usuario.setPessoa(pessoa);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);
		
		System.out.println("Usuário salvo com sucesso.");
	}

}

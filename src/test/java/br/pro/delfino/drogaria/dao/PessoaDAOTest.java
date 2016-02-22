package br.pro.delfino.drogaria.dao;

import org.junit.Test;

import br.pro.delfino.drogaria.domain.Cidade;
import br.pro.delfino.drogaria.domain.Pessoa;

public class PessoaDAOTest {
	
	@Test
	public void salvar() {
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Long codigoCidade = 1L;
		Cidade cidade = cidadeDAO.buscar(codigoCidade);
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Renan Caio Vinicius Mendes");
		pessoa.setCpf("887.234.389-59");
		pessoa.setRg("15.422.334-7");
		pessoa.setRua("Rua Raimundo de França");
		pessoa.setNumero(new Short("283"));
		pessoa.setBairro("Quintas");
		pessoa.setCep("59035-160");
		//pessoa.setComplemento(complemento);
		pessoa.setTelefone("84 3609-7011");
		pessoa.setCelular("84 99169-7516");
		pessoa.setEmail("renan.caio.mendes@gsw.com.br");
		pessoa.setCidade(cidade);
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.salvar(pessoa);
		
		System.out.println("Pessoa gravada com sucesso.");		
	}
}

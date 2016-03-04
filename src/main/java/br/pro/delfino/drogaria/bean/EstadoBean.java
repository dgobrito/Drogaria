package br.pro.delfino.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.pro.delfino.drogaria.dao.EstadoDAO;
import br.pro.delfino.drogaria.domain.Estado;

/*
 * Bean é o controle e modelo
 * Existe 2 tipos para fazer o Bean (Se está usando container (Tomcat) ou
 * Application Server (WildFly)
 * Expression Language (ligar visão com o modelo / controle)
 * FacesMessage (Exibir mensagens)
 * Controle não manipula visão
 */

/*
 * Tempos de vida dos objetos:
 * Request: Vive por apenas um click
 * View: Existe enquanto está na tela
 * Session: Objetos vivos durante todo o tempo de sessão da aplicação (Não recomendado)
 */

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {
	
	private Estado estado;
	private List<Estado> estados;
	
	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public List<Estado> getEstados() {
		return estados;
	}
	
	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	
	@PostConstruct //Chamado logo após o construtor da classe
	public void listar() {
		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os estados");
			e.printStackTrace();			
		}
	}
	
	public void novo() {
		estado = new Estado();
	}

	public void salvar() {

		/*
		 * 1º Parâmetro: Tipo do erro 2º Mensagem resumida 3º Mensagem detalhada
		 */

		/*
		 * String texto = "Programação Web com Java"; FacesMessage mensagem =
		 * new FacesMessage(FacesMessage.SEVERITY_INFO, texto, texto);
		 * 
		 * FacesContext contexto = FacesContext.getCurrentInstance(); // Captura
		 * o contexto contexto.addMessage(null, mensagem);
		 */

		//Messages.addGlobalInfo("Nome: " + estado.getNome() + " Sigla: " + estado.getSigla());
		
		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.salvar(estado);
			
			novo();
			
			estados = estadoDAO.listar();
			
			Messages.addGlobalInfo("Estado salvo com sucesso");
		//} catch (RuntimeException | ExceptionInInitializerError e) {
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o estado");
			e.printStackTrace();
		}		
	}
	
	public void excluir(ActionEvent evento) {
		estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
		
		Messages.addGlobalInfo("Codigo: " + estado.getCodigo() + " Nome: " + estado.getNome() + " Sigla: " + estado.getSigla());
	}
}

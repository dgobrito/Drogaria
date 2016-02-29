package br.pro.delfino.drogaria.bean;

import javax.faces.bean.ManagedBean;

import org.omnifaces.util.Messages;

import br.pro.delfino.drogaria.domain.Estado;

/*
 * Bean é o controle e modelo
 * Existe 2 tipos para fazer o Bean (Se está usando container (Tomcat) ou
 * Application Server (WildFly)
 * Expression Language (ligar visão com o modelo / controle)
 * FacesMessage (Exibir mensagens)
 * Controle não manipula visão
 */

@ManagedBean
public class EstadoBean {
	
	private Estado estado;
	
	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
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

		Messages.addGlobalInfo("Programação Web com Java");
		//Messages.addGlobalError("Programação Web com Java");
	}
}

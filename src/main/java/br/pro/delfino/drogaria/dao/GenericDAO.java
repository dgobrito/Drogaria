package br.pro.delfino.drogaria.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.pro.delfino.drogaria.util.HibernateUtil;

/*
 * <> = Diamante, Diamonds, uma espécie de Type (Tipo)
 */
public class GenericDAO<Entidade> {
	private Class<Entidade> classe;

	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public void salvar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			/*
			 * Se a transação foi aberta, ou seja, diferente de null e durante o
			 * try da algum erro, verifica se realmente foi aberta (<> null) e
			 * executa o rollback.
			 */
			if (transacao != null) {
				transacao.rollback();
			}

			throw erro;
		} finally {
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Entidade> listar() {
		/*
		 * No Hibernate é possivel utilizar 4 formas de consulta:
		 * SQL Nativo;
		 * HQL;
		 * Named Query
		 * Criteria
		 */		
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try {
			Criteria consulta = sessao.createCriteria(classe);
			List<Entidade> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;			
		} finally {
			sessao.close();			
		}
	}
	
	@SuppressWarnings("unchecked")
	public Entidade buscar(Long codigo) {		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try {
			Criteria consulta = sessao.createCriteria(classe);
			consulta.add(Restrictions.idEq(codigo)); // Clausula where
			Entidade resultado = (Entidade) consulta.uniqueResult();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;			
		} finally {
			sessao.close();			
		}
	}
	
	public void excluir(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			/*
			 * Se a transação foi aberta, ou seja, diferente de null e durante o
			 * try da algum erro, verifica se realmente foi aberta (<> null) e
			 * executa o rollback.
			 */
			if (transacao != null) {
				transacao.rollback();
			}

			throw erro;
		} finally {
			sessao.close();
		}
	}
	
	public void editar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(entidade);
			transacao.commit();
		} catch (RuntimeException erro) {
			/*
			 * Se a transação foi aberta, ou seja, diferente de null e durante o
			 * try da algum erro, verifica se realmente foi aberta (<> null) e
			 * executa o rollback.
			 */
			if (transacao != null) {
				transacao.rollback();
			}

			throw erro;
		} finally {
			sessao.close();
		}
	}	
}

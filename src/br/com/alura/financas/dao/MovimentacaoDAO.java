package br.com.alura.financas.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.TipoMovimentacao;

public class MovimentacaoDAO {

	private EntityManager em;

	public MovimentacaoDAO (EntityManager em) {
		this.em = em;
	}

	public Double mediaDaConta(Conta conta, TipoMovimentacao tipo) {
		TypedQuery<Double> query = em.createQuery("select avg(m.valor) from Movimentacao m where m.conta = :pConta and m.tipo = :pTipo", Double.class);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", tipo);
		return query.getSingleResult();
	}
	
	public Long totalDeMovimentacoes(Conta conta) {
		TypedQuery<Long> query = em.createNamedQuery("totalDeMovimentacoes", Long.class);
		query.setParameter("pConta", conta);
		return query.getSingleResult();
	}
	
}

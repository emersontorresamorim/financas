package br.com.alura.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TesteConsultaFuncaoCount {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		Conta conta = em.find(Conta.class, 2);
		
		TypedQuery<Long> query = em.createQuery("select count(m) from Movimentacao m where m.conta = :pConta", Long.class);
		query.setParameter("pConta", conta);
		Long qtde = query.getSingleResult();
		
		System.out.println("Quantidade: " + qtde);
	}
}

package br.com.alura.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TesteConsultaFuncaoMax {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		Conta conta = em.find(Conta.class, 2);
		
		TypedQuery<BigDecimal> query = em.createQuery("select max(m.valor) from Movimentacao m where m.conta = :pConta", BigDecimal.class);
		query.setParameter("pConta", conta);
		BigDecimal valor = query.getSingleResult();
		
		System.out.println("Maior valor: " + valor);
	}
}

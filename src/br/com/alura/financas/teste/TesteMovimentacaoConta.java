package br.com.alura.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		Query query = em.createQuery("select distinct c from Conta c join fetch c.movimentacoes");
		List<Conta> contas = query.getResultList();
		
		for (Conta c : contas) {
			System.out.println("Número de movimentações por conta: " + c.getMovimentacoes().size());
		}
	}
}

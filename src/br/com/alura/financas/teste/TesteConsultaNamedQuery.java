package br.com.alura.financas.teste;

import javax.persistence.EntityManager;

import br.com.alura.financas.dao.MovimentacaoDAO;
import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TesteConsultaNamedQuery {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		Conta conta = em.find(Conta.class, 3);
		
		MovimentacaoDAO dao = new MovimentacaoDAO(em);
		Long totalDeMovimentacoes = dao.totalDeMovimentacoes(conta);
		
		System.out.println("Total de Movimentações: " + totalDeMovimentacoes);
	}
}

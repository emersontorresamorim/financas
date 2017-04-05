package br.com.alura.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TesteConsultaEntidade {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();

		Conta conta = new Conta();
		conta.setId(3);

		TypedQuery<Double> query = em.createNamedQuery("mediaDaContaPeloTipoMovimentacao", Double.class);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.ENTRADA);
		Double media = query.getSingleResult();
		
		System.out.println("Média: " + media);
		
	}
}

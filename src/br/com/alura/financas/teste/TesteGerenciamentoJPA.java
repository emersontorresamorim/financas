package br.com.alura.financas.teste;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TesteGerenciamentoJPA {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Conta conta = em.find(Conta.class, 11);

        em.getTransaction().commit();

        conta.setTitular("Maria da Silva");

        em.getTransaction().begin();
        em.merge(conta);
        em.getTransaction().commit();
        
        em.close();
	}
}

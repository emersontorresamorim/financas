package br.com.alura.financas.teste;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TesteJPA {

	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setTitular("Joao da Silva");
		conta.setBanco("HSBC");
		conta.setAgencia("123-4");
		conta.setNumero("5566-7");
		
		double inicio = System.currentTimeMillis();
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		
		em.close();
		
		double fim = System.currentTimeMillis();
        System.out.println("Executado em: " + (fim - inicio)/1000 + " segundos");
	}
}

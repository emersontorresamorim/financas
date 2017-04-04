package br.com.alura.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TesteRelacionamentoJPA {

	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setTitular("Joao das Cruzes");
		conta.setBanco("HSBC");
		conta.setAgencia("123-4");
		conta.setNumero("5566-7");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Conta de Luz");
		movimentacao.setTipo(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal(123.9));
		movimentacao.setConta(conta);
		
		double inicio = System.currentTimeMillis();
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);
		em.persist(movimentacao);
		em.getTransaction().commit();
		
		em.close();
		
		double fim = System.currentTimeMillis();
        System.out.println("Executado em: " + (fim - inicio)/1000 + " segundos");
	}
}

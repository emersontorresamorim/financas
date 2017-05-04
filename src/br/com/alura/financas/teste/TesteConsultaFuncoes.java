package br.com.alura.financas.teste;

import javax.persistence.EntityManager;

import br.com.alura.financas.dao.MovimentacaoDAO;
import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TesteConsultaFuncoes {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		Conta conta = new Conta();
		conta.setId(3);
		
		MovimentacaoDAO dao = new MovimentacaoDAO(em);
		Double media = dao.mediaDaConta(conta, TipoMovimentacao.ENTRADA);
		
		System.out.println("Média: " + media);
	}
}

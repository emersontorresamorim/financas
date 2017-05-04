package br.com.alura.financas.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.financas.util.JPAUtil;

public class TesteConsultaMediaMovimentacoes {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();

		Query query = em.createQuery("select avg(m.valor), m.data from Movimentacao m group by m.data");
		List<Object[]> resultado = query.getResultList();

		SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
		for (Object[] obj : resultado) {
			System.out.println("Media Mov: R$" + obj[0]);
			String data = dt.format(((Calendar) obj[1]).getTime());
			System.out.println("Data: " + data);
		}
	}
}

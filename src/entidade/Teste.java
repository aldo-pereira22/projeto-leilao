package entidade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.LanceDao;
import dao.LeilaoDao;
import dao.ParticipanteDao;
import jpa.JPAUtil;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Participante p = new Participante();
//		p.setNome("Aldo");
//		p.setCpf("11111");
//		p.setDataNascimento("22051990");
//		
//		EntityManager em = new JPAUtil().getConecction();
//		
//		em.getTransaction().begin();
//		em.persist(p);
//		em.getTransaction().commit();
//		em.close();
		
		Lance lance = new Lance();
		LanceDao lanceDao = new LanceDao();
		
//		Participante participante = new Participante();
//		ParticipanteDao pdao = new ParticipanteDao();
//		
		Leilao leilao = new Leilao();
//		LeilaoDao leilaoDao = new LeilaoDao();
//		
//		leilao = leilaoDao.getLeilao((long) 73);
//		
//		participante = pdao.getParticipante("111112");
		
//		lance.setParticipante(participante);
//		lance.setLeilao(leilao);
//		lance.setValor(350.00);
//		lanceDao.salvar(lance);
//		System.out.println("Nome PARTICIPANTE- "+ participante.getNome());
//		System.out.println("Data de Nascimento PARTICIPANTE- "+participante.getDataNascimento());
//		System.out.println("CPF PARTIIPANTE- "+ participante.getCpf());
		
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Descrição do LEILAO- "+ leilao.getDescricao());
		System.out.println("VALOR INICIAL LEILAO- "+leilao.getValorInicial());
		System.out.println("SITUAÇÃO LEILAO- "+leilao.getSituacao());
		System.out.println("-----------------------------------------------------------------------------------");
		double maiorLance = leilao.retornaMaiorLance(leilao);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("O maior lance é: "+maiorLance);
		
		
	}

}

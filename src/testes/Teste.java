package testes;

import dao.LanceDao;
import dao.LeilaoDao;
import dao.ParticipanteDao;
import entidade.Lance;
import entidade.Leilao;
import entidade.Participante;

public class Teste {

	public static void main(String[] args) {

		LanceDao ldao = new LanceDao();
		Lance lance = new Lance();
	
		
		Participante p = new Participante();
		ParticipanteDao pdao = new ParticipanteDao();
		
		p = pdao.getParticipante("1");
		lance.setValor(300.00);
		lance.setParticipante(p);
		lance.setId(1);
		//ldao.salvar(lance);
		
		Leilao leilao = new Leilao();
		LeilaoDao leilaoDao = new LeilaoDao();
		
//		leilao.setDataCriacao("22222");
//		leilao.setDescricao("PlayStation");
//		leilao.setSituacao("Aberto");
//		leilao.setValorArremate(900.00);
//		leilao.setValorInicial(1000.00);
//		leilao.setLance(lance);
//		leilaoDao.salvar(leilao);
			
		
		leilao = leilaoDao.getLeilao((long) 6);
		System.out.println("Descrição:"+ leilao.getDescricao());
		leilaoDao.deleta(leilao);
		
		System.out.println();
		//leilaoDao.deleta(leilao);
	}

}

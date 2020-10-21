package testes;

import dao.LanceDao;
import dao.ParticipanteDao;
import entidade.Lance;
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
		ldao.salvar(lance);
		
		
		
		
	}

}

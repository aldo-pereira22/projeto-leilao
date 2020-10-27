package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LanceDao;
import dao.LeilaoDao;
import dao.ParticipanteDao;
import entidade.Lance;
import entidade.Leilao;
import entidade.Participante;
@WebServlet(urlPatterns = "/lance")
public class LanceServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Participante participante = new Participante();
		ParticipanteDao participanteDao = new ParticipanteDao();
		
		Leilao leilao = new Leilao();
		LeilaoDao leilaoDao = new LeilaoDao();
		
		Lance lance = new Lance();
		LanceDao lanceDao = new LanceDao();
		
		String valor = req.getParameter("lance");
		String idParticipante = req.getParameter("participante");		
		String idLeilao = req.getParameter("leilao");
		
		System.out.println("ID PARTICIPANTE: "+idParticipante);
		System.out.println("ID LEILAO: "+idLeilao);
		System.out.println("VALOR LANCE: "+valor);

		leilao = leilaoDao.getLeilao(Long.parseLong(idLeilao));
		participante = participanteDao.getParticipante(idParticipante);
		
		leilaoDao.salvar(leilao);
		participanteDao.salvaParticipante(participante);
		lance.setLeilao(leilao);
		lance.setParticipante(participante);
		lance.setValor(Double.parseDouble(valor));
		lanceDao.salvar(lance);
		
	}

}

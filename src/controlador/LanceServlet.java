package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import javax.servlet.*;
import java.net.*;
import java.io.*;

import dao.LanceDao;
import dao.LeilaoDao;
import dao.ParticipanteDao;
import entidade.Lance;
import entidade.Leilao;
import entidade.Participante;
import okhttp3.Response;

@WebServlet(urlPatterns = "/lance")
public class LanceServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Participante participante = new Participante();
		ParticipanteDao participanteDao = new ParticipanteDao();

		Leilao leilao = new Leilao();
		LeilaoDao leilaoDao = new LeilaoDao();

		Lance lance = new Lance();
		LanceDao lanceDao = new LanceDao();

		PrintWriter out = resp.getWriter();


		String valor = req.getParameter("lance");

		String idParticipante = req.getParameter("participante");
		String idLeilao = req.getParameter("leilao");

		System.out.println("ID PARTICIPANTE: " + idParticipante);
		System.out.println("ID LEILAO: " + idLeilao);
		System.out.println("VALOR LANCE: " + valor);

		leilao = leilaoDao.getLeilao(Long.parseLong(idLeilao));
		participante = participanteDao.getParticipante(idParticipante);

		if (Double.parseDouble(valor) < leilao.getValorInicial()) {
			out.println("<h1>");
			out.println("O valor deve ser maior que o valor inicial de "+leilao.getValorInicial());
			out.println("</h1>");
			out.println("<button>");
			out.println("<a href='lance.html'>");
			out.println("voltar");
			out.println("</a>");
			out.println("</button>");
		} else {
			leilaoDao.salvar(leilao);
			participanteDao.salvaParticipante(participante);
			lance.setLeilao(leilao);
			lance.setParticipante(participante);
			lance.setValor(Double.parseDouble(valor));
			lanceDao.salvar(lance);
			resp.sendRedirect("leiloes.html");

		}
	}

}

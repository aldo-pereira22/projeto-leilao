package controlador;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import dao.ParticipanteDao;
import entidade.Participante;

@WebServlet(urlPatterns = "/participante")
public class ParticipanteServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ParticipanteDao pdao = new ParticipanteDao();

		Participante p = new Participante();
		String nome = req.getParameter("input-nome");
		String cpf = req.getParameter("input-cpf");
		String dataNascimento = req.getParameter("input-data-nascimento");

		p.setNome(nome);
		p.setCpf(cpf);
		p.setDataNascimento(dataNascimento);
		
		pdao.salvaParticipante(p);
		System.out.println("Cadastrado com sucesso!");
		resp.sendRedirect("cadastro-leilao.html");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Participante pdao = new Participante();
		
		Gson gson = new Gson();
		JsonElement json = gson.toJsonTree(dao.lista());
		resp.setContentType("aplication/json");
		resp.getWriter().print(json.toString());
		
		// TODO Auto-generated method stub
		
	}

}

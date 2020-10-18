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
		resp.sendRedirect("participantes.html");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ParticipanteDao pdao = new ParticipanteDao();
		Gson gson = new Gson();

		String cpf = req.getParameter("cpf");
		if(cpf == null) {
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(gson.toJson(pdao.lista()));
			
		}else {
			String operacao = req.getParameter("operacao");
			if(operacao != null && operacao.equals("excluir")) {
				
				Participante p = new Participante();
				p.setCpf(cpf);
				pdao.deleta(p);
				resp.sendRedirect("participantes.html");
			}else {
				
				if(req.getParameter("origem") != null && req.getParameter("origem").equals("cadastro-participante") ) {
					
					String jsonParticipante = gson.toJson(pdao.getParticipante(cpf));
					resp.setContentType("aplication/json");
					resp.getWriter().print(jsonParticipante.toString());
				}else {
					resp.sendRedirect("cadastro-participante.html?cpf="+req.getParameter("cpf"));
				}
			}
		}
		
		
	}

}


















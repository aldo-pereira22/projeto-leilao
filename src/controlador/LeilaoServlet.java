package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LeilaoDao;
import entidade.Leilao;

@WebServlet(urlPatterns = "/leilao")
public class LeilaoServlet extends HttpServlet{
		
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		LeilaoDao ldao = new LeilaoDao();		
		Leilao leilao = new Leilao();
		
		leilao.setDescricao(req.getParameter("input-descricao") );
		leilao.setValorInicial(Double.parseDouble(req.getParameter("input-valor-inicial")));
		leilao.setValorArremate(Double.parseDouble(req.getParameter("input-valor-arremate")));
		leilao.setSituacao(req.getParameter("situacao"));
		leilao.setDataCriacao(req.getParameter("input-data-criacao"));
		
		ldao.salvar(leilao);
		
		
		
	}
	
}

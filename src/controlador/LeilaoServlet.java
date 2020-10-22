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
		
		String descricao = req.getParameter("input-descricao");		
		String valorInicial = req.getParameter("input-valor-inicial");
		String valorArremate = req.getParameter("input-valor-arremate");
		String dataCriacao = req.getParameter("input-data-criacao");
		String situacao = req.getParameter("situacao");
		
		System.out.println("Descrição - "+ descricao);
		System.out.println("VALOR INICIAL - " + valorInicial );
		System.out.println("VALOR ARREMATE - "+ valorArremate);
		System.out.println("DATA CRIACAO - "+ dataCriacao);
		System.out.println("SITUACAO -  "+ situacao);
		
	
		
		leilao.setDescricao(descricao);
		leilao.setDataCriacao(dataCriacao);
		leilao.setValorArremate(Double.parseDouble(valorArremate));
		leilao.setValorInicial( Double.parseDouble(valorInicial));
		leilao.setSituacao(situacao);
		ldao.salvar(leilao);		
		resp.sendRedirect("leiloes.html");
		
	}
	
}

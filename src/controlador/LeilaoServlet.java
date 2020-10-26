package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.LeilaoDao;
import entidade.Leilao;
import util.Utilitarios;

@WebServlet(urlPatterns = "/leilao")
public class LeilaoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LeilaoDao ldao = new LeilaoDao();
		Leilao leilao = new Leilao();
		Utilitarios util = new Utilitarios();

		String id = null;
		id = req.getParameter("id");

		if (util.isNumeric(id)) {
			leilao.setId(Long.parseLong(id));
		}

		String valorInicial = req.getParameter("input-valor-inicial");
		String dataCriacao = req.getParameter("input-data-criacao");
		String descricao = req.getParameter("input-descricao");
		String situacao = req.getParameter("situacao");

		leilao.setDescricao(descricao);
		leilao.setDataCriacao(dataCriacao);
		leilao.setValorInicial(Double.parseDouble(valorInicial));
		leilao.setSituacao(situacao);

		ldao.salvar(leilao);

		resp.sendRedirect("leiloes.html");

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		LeilaoDao ldao = new LeilaoDao();
		Gson gson = new Gson();

		String descricao = req.getParameter("descricao");
		if (descricao == null) {
			resp.setContentType("aplication/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(gson.toJson(ldao.lista()));
		} else {

			String operacao = req.getParameter("operacao");
			if (operacao != null && operacao.equals("excluir")) {
				Leilao leilao = new Leilao();
				List<Leilao> listaLeilao = ldao.lista();

				for (Leilao l : listaLeilao) {
					if (l.getDescricao().equals(descricao)) {
						System.out.println("DESCRICÂO: -------" + l.getDescricao());
						leilao = l;
					}
				}
				ldao.deleta(leilao);
				resp.sendRedirect("leiloes.html");
			} else {

				if (req.getParameter("origem") != null && req.getParameter("origem").equals("cadastro-leilao")) {
					Leilao leilao = new Leilao();
					List<Leilao> listaLeilao = ldao.lista();

					for (Leilao l : listaLeilao) {
						if (l.getDescricao().equals(descricao)) {
							leilao = l;
						}
					}
					String jsonLeilao = gson.toJson(leilao);
					resp.setContentType("aplication/json");
					resp.getWriter().print(jsonLeilao.toString());
				} else {
					resp.sendRedirect("cadastro-leilao.html?descricao=" + req.getParameter("descricao"));
					// resp.sendRedirect("cadastro-leilao.html");
				}

			}

		}

	}
}

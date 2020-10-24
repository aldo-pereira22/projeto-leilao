package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entidade.Leilao;
import jpa.JPAUtil;

public class LeilaoDao {
	EntityManager em = new JPAUtil().getConecction();

	public List<Leilao> lista() {
		TypedQuery<Leilao> qry = em.createQuery("from Leilao", Leilao.class);
		return qry.getResultList();
	}

	public void deleta(Leilao leilao) {
		em.getTransaction().begin();
		leilao = em.find(Leilao.class, leilao.getId());
		em.remove(leilao);
		em.getTransaction().commit();
		em.close();
	}

	public void salvar(Leilao leilao) {
		em.getTransaction().begin();
		Leilao existente = getLeilao(leilao.getId());

		if (existente == null) {
			em.persist(leilao);
		} else {

			existente.setDataCriacao(leilao.getDataCriacao());
			existente.setDescricao(leilao.getDescricao());
			existente.setSituacao(leilao.getSituacao());
			existente.setValorArremate(leilao.getValorArremate());
			existente.setValorInicial(leilao.getValorInicial());
		}
		em.getTransaction().commit();
		em.close();

	}

	public Leilao getLeilao(Long id) {
		return em.find(Leilao.class, id);
	}

}











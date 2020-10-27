package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entidade.Lance;
import entidade.Leilao;
import entidade.Participante;
import jpa.JPAUtil;

public class LanceDao {

	EntityManager em = new JPAUtil().getConecction();
	
	public List<Lance> lista() {
		TypedQuery<Lance> qry = em.createNamedQuery("from Lance", Lance.class);
		return qry.getResultList();
	}
	
	public void deleta(Lance lance) {		
		em.getTransaction().begin();
		lance = em.find(Lance.class, lance.getId());
		em.remove(lance);
		em.getTransaction().commit();
		em.close();
		
	}

	public void salvar(Lance lance) {
		

		
		em.getTransaction().begin();
		Lance existente = getLance(lance.getId());

		if (existente == null) {
			em.persist(lance);
		} else {
			existente.setParticipante(lance.getParticipante());
			existente.setValor(lance.getValor());

		}

		em.getTransaction().commit();
		em.close();
	}

	public Lance getLance(Long id) {
		return em.find(Lance.class, id);
	}

}

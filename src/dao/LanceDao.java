package dao;

import javax.persistence.EntityManager;

import entidade.Lance;
import jpa.JPAUtil;

public class LanceDao {

	
	EntityManager em = new JPAUtil().getConecction();
	
	public void salvar(Lance lance) {
		em.getTransaction().begin();
		Lance existente = getLance(lance.getId());
		
		if(existente == null) {
			em.persist(lance);
		}else {
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

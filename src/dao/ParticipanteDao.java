package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entidade.Participante;
import jpa.JPAUtil;

public class ParticipanteDao {

	EntityManager em = new JPAUtil().getConecction();
	
	public void salvaParticipante(Participante p ) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Participante>lista() {
		TypedQuery<Participante> qry = em.createQuery("from Paarticipante", Participante.class);
		return qry.getResultList();
	}
	
//	public void salvaParticipante(Participante p ) {
//		em.getTransaction().begin();
//		Participante existente = getParticipante(p.getCpf());
//		
//		if(existente == null) {
//			em.persist(p);
//		}else {
//			existente.setCpf(p.getCpf());
//			existente.setNome(p.getNome());
//			existente.setDataNascimento(p.getDataNascimento());
//		}
//		
//		em.getTransaction().commit();
//		em.close();
//	}
//	
//	public Participante getParticipante(String cpf) {
//		return em.find(Participante.class, cpf);
//	}
	
}

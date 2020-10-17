package entidade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.JPAUtil;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Participante p = new Participante();
		p.setNome("Aldo");
		p.setCpf("11111");
		p.setDataNascimento("22051990");
		
		EntityManager em = new JPAUtil().getConecction();
		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
		
	}

}

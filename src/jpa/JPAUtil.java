package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ifg");
	
	public EntityManager getConecction() {
		//emf.close();
		return emf.createEntityManager();
		
	}
}

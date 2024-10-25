package utils;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryProvider {
	private static EntityManagerFactory factory;
	
	public static EntityManagerFactory getFactory() {
		if(factory == null) {
			factory = Persistence.createEntityManagerFactory("truongchinghiem21126241");
		}
		return factory;
	}
}

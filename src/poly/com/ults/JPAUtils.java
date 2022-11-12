package poly.com.ults;

import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
	private static EntityManagerFactory factory;
	static public EntityManager getEntityManager() {
		HashMap<String, String> properties = new HashMap<String, String>();
		properties.put("ConnectionDriverName", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
		if(factory == null || !factory.isOpen()) {
			factory = Persistence.createEntityManagerFactory("ASMJAVA4");
		}
		return factory.createEntityManager();
	}
	static public void shutdown() {
		if(factory != null && factory.isOpen()) {
			factory.close();
		}
		factory = null;
	}
}

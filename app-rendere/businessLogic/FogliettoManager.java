package businessLogic;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import project.FogliettoIllustrativo;
import utility.JPAutility;

public class FogliettoManager {
	private static Logger log = Logger.getLogger("app-rendere");
	
	public static void aggiungiFoglietto(FogliettoIllustrativo fi) {
		EntityManager em = JPAutility.getEm();
		
		FogliettoIllustrativo fiDb = em.find(FogliettoIllustrativo.class, fi.getFarmaco());
		if (fiDb == null) {
			em.getTransaction().begin();
			em.persist(fi); // aggiungo a DB
			em.getTransaction().commit();
			log.log(Level.INFO, "aggiunto foglietto");
		} else {
			log.log(Level.WARNING, "foglietto esiste già");
		}
	}
	
}

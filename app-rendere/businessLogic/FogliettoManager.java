package businessLogic;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import project.FogliettoIllustrativo;
import utility.JPAutility;

public class FogliettoManager {
	private static Logger log = Logger.getLogger("app-rendere");
	
	public static void aggiungiFoglietto(FogliettoIllustrativo b) {
		EntityManager em = JPAutility.getEm();
		
		FogliettoIllustrativo bDb = em.find(FogliettoIllustrativo.class, b.getFarmaco());
		if (bDb == null) {
			em.getTransaction().begin();
			em.persist(b); // aggiungo a DB
			em.getTransaction().commit();
			log.log(Level.INFO, "aggiunto foglietto");
		} else {
			log.log(Level.WARNING, "foglietto esiste già");
		}
	}
	public static List<FogliettoIllustrativo> elencoFoglietti() {
		EntityManager em = JPAutility.getEm();
		return em.createQuery("select b from FogliettoIllustrativo b", FogliettoIllustrativo.class).getResultList();
}
}

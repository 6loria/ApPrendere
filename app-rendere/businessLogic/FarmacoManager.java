package businessLogic;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import project.Farmaco;

import utility.JPAutility;


public class FarmacoManager {
	private static Logger log = Logger.getLogger("app-rendere");
	
	public static void aggiungiRegistro(Farmaco f) {
		EntityManager em = JPAutility.getEm();
		
		Farmaco fDb = em.find(Farmaco.class, f.getAic());
		if (fDb == null) {
			em.getTransaction().begin();
			em.persist(f); 
			em.getTransaction().commit();
			log.log(Level.INFO, "aggiunto farmaco");
		} else {
			log.log(Level.WARNING, "farmaco esiste già");
		}
	}
	public static List<Farmaco> elencoFarmaco() {
		EntityManager em = JPAutility.getEm();
		return em.createQuery("select f from Farmaco f", Farmaco.class).getResultList();
	}

}

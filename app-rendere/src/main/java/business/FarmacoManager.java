package business;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import project.Farmaco;
import utility.JPAutility;

public class FarmacoManager {
private static Logger log = Logger.getLogger("app-rendere");
	
	public static void aggiungiFarmaco(Farmaco f) {
		EntityManager em = JPAutility.getEm();
		
		Farmaco fDb = em.find(Farmaco.class, f.getAic());
		if (fDb == null) {
			em.getTransaction().begin();
			em.persist(f); 
			em.getTransaction().commit();
			log.log(Level.INFO, "aggiunto farmaco");
		} else {
			log.log(Level.WARNING, "questo farmaco esiste già");
		}
	}
	public static void modificaFarmaco(Farmaco f) {
		EntityManager em = JPAutility.getEm();
		
		Farmaco fDb = em.find(Farmaco.class, f.getAic());
		if (fDb == null) {
			em.getTransaction().begin();
			f.setFogliettoIllustrativo(f.getFogliettoIllustrativo());
			f.setPrezzo(f.getPrezzo());
			em.getTransaction().commit();
			log.log(Level.INFO, "farmaco modificato");
		}
	}
		
		
		
		
	public static List<Farmaco> elencoFarmaci() {
		EntityManager em = JPAutility.getEm();
		return em.createQuery("select f from Farmaco f", Farmaco.class).getResultList();
	}

}


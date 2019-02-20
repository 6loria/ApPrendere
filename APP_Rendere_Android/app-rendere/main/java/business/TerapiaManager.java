package business;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import project.Farmaco;
import project.Terapia;
import project.Utente;
import utility.JPAutility;

public class TerapiaManager {
	private static Logger log = Logger.getLogger("app-rendere");
	
	public static void aggiungiTerapia(Terapia t) {
		EntityManager em = JPAutility.getEm();
		
		Terapia tDb = em.find(Terapia.class, t.getId());
	    if (tDb == null) {
		em.getTransaction().begin();
		em.persist(t); 
		em.getTransaction().commit();
		log.log(Level.INFO, "Terapia aggiunta");
	} else {
		log.log(Level.WARNING, "Terapia già impostata");
	}
	}

	public static void modificaTerapia(Terapia t) {
		EntityManager em = JPAutility.getEm();
		Terapia tDb = em.find(Terapia.class, t.getId());
		if (tDb != null) {
			em.getTransaction().begin();
			tDb.setFarmaci(t.getFarmaci());
			tDb.setAllarmi(t.getAllarmi());
			em.getTransaction().commit();
			log.log(Level.INFO, "Terapia modificata");

}
	}

	public void rimuoviTerapia(Terapia t) {
		EntityManager em = JPAutility.getEm();
		Terapia tDb = em.find(Terapia.class, t.getId());
		if (tDb != null) {
		em.getTransaction().begin();
	    em.remove(t);
		em.getTransaction().commit();
		log.log(Level.INFO, "Terapia rimossa");
	}
}
}
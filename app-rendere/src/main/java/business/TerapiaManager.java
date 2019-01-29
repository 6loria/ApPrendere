package business;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import project.Terapia;
import project.Utente;
import utility.JPAutility;

public class TerapiaManager {
	private static Logger log = Logger.getLogger("app-rendere");
	
	public static void aggiungiTerapia (Terapia t) {
		EntityManager em = JPAutility.getEm(); 
		Terapia tDb= null;
		if(t.getFarmaci() != null) {
			tDb = em.find(Terapia.class, t.getId());
	}

}

	public static void modificaTerapia(Terapia t) {
		EntityManager em = JPAutility.getEm();
		Terapia tDb = em.find(Terapia.class, t.getId());
		if (tDb != null) {
			em.getTransaction().begin();
			tDb.setFarmaci(t.getFarmaci());
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
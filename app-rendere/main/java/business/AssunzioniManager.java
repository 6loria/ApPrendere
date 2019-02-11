package business;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import project.Assunzioni;
import utility.JPAutility;

public class AssunzioniManager {
	
private static Logger log = Logger.getLogger("app-rendere");
	
	public static void aggiungiUtente(Assunzioni ass) {
		EntityManager em = JPAutility.getEm();
		
		Assunzioni assDb = em.find(Assunzioni.class, ass.getId());
		if (assDb == null) {
			em.getTransaction().begin();
			em.persist(ass); 
			em.getTransaction().commit();
			log.log(Level.INFO, "Assunzione aggiunta");
		} else {
			log.log(Level.WARNING, "Asssunzione esiste già");
		}
	}
	
	
	public static void modificaUtente(Assunzioni ass) {
		EntityManager em = JPAutility.getEm();
		Assunzioni assDb = em.find(Assunzioni.class, ass.getId());
		if (assDb != null) {
			em.getTransaction().begin();
			//assDb.setAssunzioni(ass.getAssunzioni());
			em.getTransaction().commit();
			log.log(Level.INFO, "Assunzione modificata");

}
	}

	public void rimuoviTerapia(Assunzioni ass) {
		EntityManager em = JPAutility.getEm();
		Assunzioni assDb = em.find(Assunzioni.class, ass.getId());
		if (assDb != null) {
		em.getTransaction().begin();
	    em.remove(ass);
		em.getTransaction().commit();
		log.log(Level.INFO, "Assunzione rimossa");
	}
}
	
	
	public static List<Assunzioni> elencoAssunzioni() {
		EntityManager em = JPAutility.getEm();
		return em.createQuery("select ass from Assunzioni ass ", Assunzioni.class).getResultList();
	}
	

}

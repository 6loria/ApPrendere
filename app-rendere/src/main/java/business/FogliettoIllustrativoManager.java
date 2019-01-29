package business;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import project.Allarme;
import project.FogliettoIllustrativo;
import utility.JPAutility;

public class FogliettoIllustrativoManager {
private static Logger log = Logger.getLogger("app-rendere");
	
	public static void aggiungiUtente(FogliettoIllustrativo fo) {
		EntityManager em = JPAutility.getEm();
		
		Allarme foDb = em.find(FogliettoIllustrativo.class, fo.getId());
		if (foDb == null) {
			em.getTransaction().begin();
			em.persist(fo); 
			em.getTransaction().commit();
			log.log(Level.INFO, "Foglietto illustrativo allarme");
		} else {
			log.log(Level.WARNING, "Foglietto illustrativo esiste già");
		}
	}
	
	
	public static void modificaUtente(FogliettoIllustrativo fo ) {
		EntityManager em = JPAutility.getEm();
		FogliettoIllustrativo foDb = em.find(FogliettoIllustrativo.class, fo.getId());
		if (foDb != null) {
			em.getTransaction().begin();
			foDb.setFogliettoIllustartivo(fo.getFogliettoIllustrativo());
			em.getTransaction().commit();
			log.log(Level.INFO, "Foglietto illustrativo modificato");

}
	}

	public void rimuoviTerapia(FogliettoIllustrativo fo) {
		EntityManager em = JPAutility.getEm();
		Allarme foDb = em.find(FogliettoIllustrativo.class, fo.getId());
		if (foDb != null) {
		em.getTransaction().begin();
	    em.remove(fo);
		em.getTransaction().commit();
		log.log(Level.INFO, "Foglietto Illustrativo rimosso");
	}
}
	
	
	public static List<FogliettoIllustrativo> elencoFogliettollustrativo() {
		EntityManager em = JPAutility.getEm();
		return em.createQuery("select fo from Foglietto Illustrativo fo ", FogliettoIllustrativo.class).getResultList();
	}
	
	
}

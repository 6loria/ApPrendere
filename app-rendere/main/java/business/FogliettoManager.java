package business;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import project.Farmaco;
import project.FogliettoIllustrativo;
import utility.JPAutility;

public class FogliettoManager {
	private static Logger log = Logger.getLogger ("app-rendere");
	
	public static void aggiungiFoglietto (FogliettoIllustrativo foglietto) {
       EntityManager em = JPAutility.getEm();
		
		FogliettoIllustrativo fogliettoDb = em.find(FogliettoIllustrativo.class, foglietto.getId());
		if (fogliettoDb == null) {
			em.getTransaction().begin();
			em.persist(foglietto); 
			em.getTransaction().commit();
			log.log(Level.INFO, "nuovo foglietto aggiunto");
		} else {
			log.log(Level.WARNING, "foglietto già presente");
		}
	}
	public static void modificaFoglietto(FogliettoIllustrativo foglietto) {
		EntityManager em = JPAutility.getEm();
		
		FogliettoIllustrativo fogliettoDb = em.find(FogliettoIllustrativo.class, foglietto.getId());
		if (fogliettoDb == null) {
			em.getTransaction().begin();
			foglietto.setIndicazioni(foglietto.getIndicazioni());
			foglietto.setControindicazioni(foglietto.getControindicazioni());
			foglietto.setAvvertenze(foglietto.getAvvertenze());
			foglietto.setComposizione(foglietto.getComposizione());
			foglietto.setEffettiIndesiderati(foglietto.getEffettiIndesiderati());
			foglietto.setInterazioni(foglietto.getInterazioni());
			foglietto.setModiDuso(foglietto.getModiDuso());
			foglietto.setPrecauzioni(foglietto.getPrecauzioni());
			foglietto.setPrincipioAttivo(foglietto.getPrincipioAttivo());
			foglietto.setSovradosaggio(foglietto.getSovradosaggio());
			foglietto.setScadenzaConservazione(foglietto.getScadenzaConservazione());
			em.getTransaction().commit();
			log.log(Level.INFO, "modifica del foglietto");
		}
	}
		public static void eliminaFoglietto(FogliettoIllustrativo foglietto) {
			EntityManager em = JPAutility.getEm();
			
			FogliettoIllustrativo fogliettoDb = em.find(FogliettoIllustrativo.class, foglietto.getId());
			if (fogliettoDb != null) {
				em.getTransaction().begin();
				em.remove(fogliettoDb);
				em.getTransaction().commit();	
				log.log(Level.INFO, "foglietto eliminato");
			
			}
			

}
	
	}

 
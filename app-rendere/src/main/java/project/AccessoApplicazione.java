package project;

import java.util.logging.Logger;

import javax.persistence.EntityManager;

import project.Utente;
import utility.JPAutility;

public class AccessoApplicazione {
private static Logger log = Logger.getLogger("project");
	
	public static Boolean login(String email, String password) {
		Boolean result = false;
		EntityManager em = JPAutility.getUtenteManager();
		Utente u = em.find(Utente.class, email);
		if (u != null) {
			if (!u.getAttivo()) {
				log.warning("accesso con utente non attivo");
			}
			if (!u.getPassword().equals(password)) {
				log.warning("accesso con password errata");
			}
			result = u.getAttivo() && u.getPassword().equals(password);
		} else {
			log.warning("l'utente " + email + " non esiste");
		}
		log.info("accesso di " + email + ": " + result);
		return result;
	}

}

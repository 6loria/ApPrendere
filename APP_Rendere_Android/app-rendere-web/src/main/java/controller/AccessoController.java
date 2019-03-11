package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import business.AccessoApplicazione;
import business.UtenteManager;
import project.Utente;
import viewmodel.LoginForm;

@Controller
public class AccessoController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody Utente accedi(LoginForm login) {
		return AccessoApplicazione.login(login.getEmail(), login.getPassword());
	}

	@RequestMapping(value = "/registra", method = RequestMethod.POST)
	public @ResponseBody Utente registra(Utente u) {
		u.setAttivo(true);
		if (UtenteManager.aggiungiUtente(u)) {
			LoginForm lf = new LoginForm();
			lf.setEmail(u.getEmail());
			lf.setPassword(u.getPassword());
			return accedi(lf);
		} else {
			return null;
		}
	}

}

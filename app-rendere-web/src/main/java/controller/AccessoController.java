package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import business.AccessoApplicazione;
import project.Utente;
import viewmodel.LoginForm;

@Controller
public class AccessoController {

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public @ResponseBody Utente accedi(LoginForm login) {
		return AccessoApplicazione.login(login.getEmail(), login.getPassword());
	}
	
}

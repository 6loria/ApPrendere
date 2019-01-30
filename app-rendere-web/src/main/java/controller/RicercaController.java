package controller;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import business.FarmacoManager;
import project.Farmaco;

@Controller
public class RicercaController {
	@RequestMapping(value = "/ricercaFarmaco", method = RequestMethod.GET)
	public @ResponseBody List<Farmaco> ricerca(@QueryParam("nomeFarmaco") String nomeFarmaco) {
		 return FarmacoManager.ricercaFarmaci(nomeFarmaco);
				
		
	}

}

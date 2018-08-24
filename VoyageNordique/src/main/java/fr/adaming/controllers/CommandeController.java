package fr.adaming.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.adaming.service.ICommandeService;

@Controller
@RequestMapping("/commande")
@Scope("session")
public class CommandeController {

	// transformation de l'association UML en JAVA
	@Autowired
	private ICommandeService coService;

	// declaration du setter obligatoire pour l'injection-dependance
	/**
	 * Le setter est obligatoire pour l'injection de dépendance
	 * 
	 * @param l'interface
	 *            ICommandeService
	 */
	public void setCoService(ICommandeService coService) {
		this.coService = coService;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		formatDate.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(formatDate, false));
	}
}

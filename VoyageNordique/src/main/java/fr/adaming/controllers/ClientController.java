package fr.adaming.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Client;
import fr.adaming.service.IClientService;

@Controller
@RequestMapping("/client")
@Scope("session")
public class ClientController {

	// **********************************************************************************************
	/** Transformation de l'asso UML en JAVA */
	@Autowired
	private IClientService clientService;

	// ** Declaration du setter pour l'injection dependance*/
	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	// ***********************************************************************************************
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		formatDate.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(formatDate, false));
	}

	// ************************************************************************************************
	// ******$$$$$$$$$$$$$$$**********
	/**
	 * Methode recuperation de la liste des clients. On utilise la methode
	 * ModelAndView
	 */

	@RequestMapping(value = "/ClientsListe", method = RequestMethod.GET)
	public ModelAndView affichageListeClients() {

		/** Recuperation de la liste des offres */
		List<Client> listeClients = clientService.getAllClientService();
		return new ModelAndView("listeClients", "LesClients", listeClients);
	}

	// ***********************************************************************************************
	// ******$$$$$$$$$$$$$$$**********
	/** Le formulaire AjoutClient */
	@RequestMapping(value = "/ajouterClient", method = RequestMethod.GET)
	public String affichageFormulaireAddClient(Model modele) {
		modele.addAttribute("clientAdd", new Client());
		return "ajoutClient";
	}

	// ******$$$$$$$$$$$$$$$**********
	/**
	 * Methode ajout de clients. On utilise la methode String qui accepte des
	 * args en entr�e
	 */
	@RequestMapping(value = "/soumettreAddClient", method = RequestMethod.POST)
	public String soumettreAddFormulaire(@ModelAttribute("clAdd") Client clIn, RedirectAttributes rda) {

		/** Instancier un nouveau client */
		Client clOut = clientService.addClientService(clIn);
		if (clOut.getIdClient() != 0) {
			return "rediracte:listeClient";
		} else {
			rda.addAttribute("msg", "L'ajout du client � �chouer");
			return "redirect:ajouterClient";
		}
	}
}
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

	@RequestMapping(value = "/ListeClients", method = RequestMethod.GET)
	public ModelAndView afficheListeClients() {

		/** Recuperation de la liste des offres */
		List<Client> LaListeClients = clientService.getAllClientService();
		return new ModelAndView("Clientsliste", "LesClients", LaListeClients);
	}

	// ***********************************************************************************************
	// ******$$$$$$$$$$$$$$$**********
	/** Le formulaire AjoutClient */
	@RequestMapping(value = "/ajouterClient", method = RequestMethod.GET)
	public String afficheFormulaireAddClient(Model modele) {
		modele.addAttribute("AjoutClient", new Client());
		return "ClientAjout";
	}

	// ******$$$$$$$$$$$$$$$**********
	/**
	 * Methode ajout de clients. On utilise la methode String qui accepte des
	 * args en entrée
	 */
	@RequestMapping(value = "/soumettreAjoutClient", method = RequestMethod.POST)
	public String soumettreAjoutFormulaire(@ModelAttribute("clientAjout") Client clAjout, RedirectAttributes rda) {

		/** Instancier un nouveau client */
		Client clOut = clientService.addClientService(clAjout);
		
		if (clOut.getIdClient() != 0) {
			return "redirect:ListeClients";
		} else {
			rda.addAttribute("msg", "L'ajout du client à échouer");
			return "redirect:ajouterClient";
		}
	}
	
	// ***********************************************************************************************
	// ******$$$$$$$$$$$$$$$**********
	
	//methode Modifier un Client
	@RequestMapping(value="/modifier" , method=RequestMethod.GET)
	public String afficheFormModifClient(Model modele){
		modele.addAttribute("clientModif", new Client());
	
		return "ClientModif";
	}
	@RequestMapping(value = "/soumettreModifClient", method = RequestMethod.POST)
	public String soumettreModifFrom(@ModelAttribute("clientModif") Client clModif, RedirectAttributes rda) {
		
		/** Instancier un nouveau client */
		int clOut = clientService.updateClient(clModif);
		
		if (clOut!=0){
			
			return "redirect:ListeClients";
		}else{
			rda.addAttribute("msg", "La modif a echoué!");
			return "redirect:modifier";
		}
	}
	
	// ***********************************************************************************************
	// ******$$$$$$$$$$$$$$$**********
	
	//methode Supprimer un Client
	@RequestMapping(value="/supprimer" , method=RequestMethod.GET)
	public String afficheFormSupprimeClient(Model modele){
		modele.addAttribute("clientSupprime", new Client());
	
		return "ClientSupprime";
	}
	@RequestMapping(value = "/soumettreSupprimeClient", method = RequestMethod.POST)
	public String soumettreSupprimeFrom(@ModelAttribute("clientSupprime") Client clSuppr, RedirectAttributes rda) {
		
		/** Instancier un nouveau client */
		int clOut = clientService.deleteClient(clSuppr);
		
		if (clOut!=0){
			
			return "redirect:ListeClients";
		}else{
			rda.addAttribute("msg", "La suppession a echoué!");
			return "redirect:supprimer";
		}
	}
}

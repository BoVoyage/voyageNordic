package fr.adaming.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Client;
import fr.adaming.model.Hebergement;
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

	private Client cl = new Client();

	@PostConstruct
	public void init() {
		// récupérer le context Spring MVC (la partie qui nous intéresse)
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		// Récupérer l'identifiant du client connecté
		String mail = auth.getName();
		Client clIn = new Client();
		clIn.setMail(mail);
		this.cl = clientService.getClientByMail(clIn);

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

	@RequestMapping(value = "/admin/ListeClients", method = RequestMethod.GET)
	public ModelAndView afficheListeClients() {

		/** Recuperation de la liste des offres */
		List<Client> LaListeClients = clientService.getAllClientService();
		return new ModelAndView("Clientsliste", "LesClients", LaListeClients);
	}

	// ************************************************************************************************
	// ******$$$$$$$$$$$$$$$**********
	/**
	 * Methode recuperation du client connecté
	 */

	@RequestMapping(value = "/clientLoggedIn/monCompte", method = RequestMethod.GET)
	public String afficheMonCompte(Model modele) {

		modele.addAttribute("clientIn", this.cl);

		return "monCompte";
	}

	// ***********************************************************************************************
	// ******$$$$$$$$$$$$$$$**********
	/** Le formulaire AjoutClient */
	@RequestMapping(value = "/ajouterClient", method = RequestMethod.GET)
	public String afficheFormulaireAddClient(Model modele,
			@RequestParam(value = "error", required = false) String error) {
		if (error != null) {
			modele.addAttribute("error", error);
		}
		modele.addAttribute("AjoutClient", new Client());
		return "ClientAjout";
	}

	// ******$$$$$$$$$$$$$$$**********
	/**
	 * Methode ajout de clients. On utilise la methode String qui accepte des
	 * args en entrée
	 */
	@RequestMapping(value = "/soumettreAjoutClient", method = RequestMethod.POST)
	public String soumettreAjoutFormulaire(@Valid @ModelAttribute("clientAjout") Client clAjout,
			RedirectAttributes rda) {

		/** Instancier un nouveau client */
		Client clOut = clientService.addClientService(clAjout);

		if (clOut.getIdClient() != 0) {
			clientService.sendMail(clOut);
			return "accueil";
		} else {
			rda.addAttribute("msg", true);
			return "redirect:ajouterClient";
		}
	}

	// ***********************************************************************************************
	// ******$$$$$$$$$$$$$$$**********

	// methode Modifier un Client
	@RequestMapping(value = "/clientLoggedIn/modifier", method = RequestMethod.GET)
	public String afficheFormModifClient(Model modele, @RequestParam(value = "error", required = false) String error) {
		if (error != null) {
			modele.addAttribute("error", error);
		}
		modele.addAttribute("clientModif", new Client());

		return "ClientModif";
	}

	@RequestMapping(value = "/clientLoggedIn/soumettreModifClient", method = RequestMethod.POST)
	public String soumettreModifFrom(@Valid @ModelAttribute("clientModif") Client clModif, RedirectAttributes rda) {

		/** Instancier un nouveau client */
		int clOut = clientService.updateClient(clModif);

		if (clOut != 0) {

			return "redirect:ListeClients";
		} else {
			rda.addAttribute("msg", true);
			return "redirect:modifier";
		}
	}
	
	@RequestMapping(value = "/modifLinkClient", method = RequestMethod.GET)
	public String modifLien(Model modele, @RequestParam("pMail") String mailCl) {
		Client clIn = new Client();
		clIn.setMail(mailCl);
		Client clOut = clientService.getClientByMail(clIn);
		modele.addAttribute("clientModif", clOut);
		return "ClientModif";
	}
	// ***********************************************************************************************
	// ******$$$$$$$$$$$$$$$**********

	// methode Supprimer un Client
	@RequestMapping(value = "/clientLoggedIn/supprimer", method = RequestMethod.GET)
	public String afficheFormSupprimeClient(Model modele,
			@RequestParam(value = "error", required = false) String error) {
		if (error != null) {
			modele.addAttribute("error", error);
		}
		modele.addAttribute("clientSupprime", this.cl);

		return "ClientSupprime";
	}

	@RequestMapping(value = "/clientLoggedIn/soumettreSupprimeClient", method = RequestMethod.POST)
	public String soumettreSupprimeFrom(@ModelAttribute("clientSupprime") Client clSuppr, RedirectAttributes rda) {

		/** Instancier un nouveau client */
		int clOut = clientService.deleteClient(clSuppr);

		if (clOut != 0) {

			return "redirect:ListeClients";
		} else {
			rda.addAttribute("msg", true);
			return "redirect:supprimer";
		}
	}

	@RequestMapping(value = "/supprClientLink/{pMail}")
	public String supprLien(ModelMap model, @PathVariable("pMail") String mailCl) {
		Client clIn = new Client();
		clIn.setMail(mailCl);
		clientService.deleteClient(clIn);
		return "accueil";
	}

	// ***********************************************************************************************
	// ******$$$$$$$$$$$$$$$**********

	// methode rechercher un Client
	@RequestMapping(value = "/admin/rechercher", method = RequestMethod.GET)
	public String afficheFormRechercheClient(Model modele,
			@RequestParam(value = "error", required = false) String error) {
		if (error != null) {
			modele.addAttribute("error", error);
		}
		modele.addAttribute("clientRecherche", new Client());
		return "ClientRecherche";
	}

	@RequestMapping(value = "/admin/soumettreRechercheClient", method = RequestMethod.POST)
	public String soumettreRechercheFrom(@ModelAttribute("clientRecherche") Client clRech, RedirectAttributes rda,
			Model modele) {

		/** Instancier un nouveau client */
		List<Client> clOut = clientService.getClientByNomOrNoClient(clRech);

		if (clOut != null) {
			modele.addAttribute("clientListe", clOut);
			return "ClientRecherche";
		} else {
			rda.addAttribute("msg", true);
			return "redirect:rechercher";
		}
	}
}

package fr.adaming.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.service.IClientService;
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
	 * Le setter est obligatoire pour l'injection de d�pendance
	 * 
	 * @param l'interface
	 *            ICommandeService
	 */
	public void setCoService(ICommandeService coService) {
		this.coService = coService;
	}

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
		//r�cup�rer le context Spring MVC (la partie qui nous int�resse)
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		
		//R�cup�rer l'identifiant du client connect�
		String mail = auth.getName();
		Client clIn = new Client();
		clIn.setMail(mail);
		this.cl=clientService.getClientByMail(clIn);
		
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		formatDate.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(formatDate, false));
	}

	// ******************* recup de la liste des commandes
	/**
	 * M�thode d'affichage de la liste des commandes
	 * 
	 * @return la page o� s'affichera la liste ainsi que la liste r�cup�r�e en
	 *         base de donn�es
	 */
	@RequestMapping(value = "/clientLoggedIn/listeCommandes", method = RequestMethod.GET)
	public String displayListeCommandes(Model modele) {

		// R�cup�rer la liste de service
		List<Commande> listeCo = coService.getCommandeByClientService(this.cl);

		modele.addAttribute("allCommandes", listeCo);

		return "commandesListe";
	}

	@RequestMapping(value = "/supprLink/{pNum}")
	public String supprLien(ModelMap model, @PathVariable("pNum") int noCo) {
		Commande coIn = new Commande();
		coIn.setNoCommande(noCo);
		coService.deleteCommandeService(coIn);

		// R�cup�rer la liste de service

		List<Commande> listeCo = coService.getCommandeByClientService(this.cl);
		model.addAttribute("allCommandes", listeCo);
		return "commandesListe";
	}

	// ****************************Fonctionnalit� recherche
	// Afficher le formulaire de recherche
	@RequestMapping(value = "/clientLoggedIn/rechercheCommande", method = RequestMethod.GET)
	public String displayFormRechCommande(Model model, @RequestParam(value = "msg", required = false) String msg) {
		model.addAttribute("coRech", new Commande());

		if (msg != null) {
			model.addAttribute("msg", msg);
		}

		return "commandeRechercher";
	}

	// // Soumettre le formulaire de recherche et afficher le r�sultat
	@RequestMapping(value = "/clientLoggedIn/soumettreRechCommande", method = RequestMethod.POST)
	public String soumettreFormRech(ModelMap model, @ModelAttribute("coRech") Commande coIn, RedirectAttributes rda) {
		// Appel de la m�thode service
		Commande coOut = coService.getCommandeByNumberService(coIn);
		if (coOut != null) {
			model.addAttribute("coFind", coOut);
			return "commandeRechercher";

		} else {
			rda.addAttribute("msg", "Commande introuvable");
			return "redirect:rechercheCommande";
		}
	}
}

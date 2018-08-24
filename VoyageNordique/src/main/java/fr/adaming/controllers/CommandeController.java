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

	private Client cl = new Client();

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		formatDate.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(formatDate, false));
	}

	// ******************* recup de la liste des commandes
	/**
	 * Méthode d'affichage de la liste des commandes
	 * 
	 * @return la page où s'affichera la liste ainsi que la liste récupérée en
	 *         base de données
	 */
	@RequestMapping(value = "/listeCommandes", method = RequestMethod.GET)
	public String displayListeCommandes(Model modele) {
		Client clIn = new Client();
		clIn.setIdClient(1);

		// Récupérer la liste de service
		List<Commande> listeCo = coService.getCommandeByClientService(clIn);

		modele.addAttribute("allCommandes", listeCo);

		return "commandesListe";
	}

	@RequestMapping(value = "/supprLink/{pNum}")
	public String supprLien(ModelMap model, @PathVariable("pNum") int noCo) {
		Client clIn = new Client();
		clIn.setIdClient(1);

		Commande coIn = new Commande();
		coIn.setNoCommande(noCo);
		coService.deleteCommandeService(coIn);

		// Récupérer la liste de service

		List<Commande> listeCo = coService.getCommandeByClientService(clIn);
		model.addAttribute("allCommandes", listeCo);
		return "commandesListe";
	}

	// ****************************Fonctionnalité recherche
	// Afficher le formulaire de recherche
	@RequestMapping(value = "/rechercheCommande", method = RequestMethod.GET)
	public String displayFormRechCommande(Model model, @RequestParam(value = "msg", required = false) String msg) {
		model.addAttribute("coRech", new Commande());

		if (msg != null) {
			model.addAttribute("msg", msg);
		}

		return "commandeRechercher";
	}

	// // Soumettre le formulaire de recherche et afficher le résultat
	@RequestMapping(value = "/soumettreRechCommande", method = RequestMethod.POST)
	public String soumettreFormRech(ModelMap model, @ModelAttribute("coRech") Commande coIn, RedirectAttributes rda) {
		// Appel de la méthode service
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

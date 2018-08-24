package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Commande;
import fr.adaming.model.LigneCommande;
import fr.adaming.service.ILigneCommandeService;

@Controller
@RequestMapping("/lignecommande")
@Scope("session")
public class LigneCommandeController {

	@Autowired
	private ILigneCommandeService ligneCommandeService;

	public void setLigneCommandeService(ILigneCommandeService ligneCommandeService) {
		this.ligneCommandeService = ligneCommandeService;
	}

	/**
	 * Methode recuperation de la liste des lignes des commandes
	 * 
	 * @return le lien vers la page affichant la liste des lignes de commandes
	 */
	@RequestMapping(value = "/ListeLignesCommandes", method = RequestMethod.GET)
	public ModelAndView afficheListeLignesCommandes() {

		// Recuperation de la liste des offres
		List<LigneCommande> listeLigneCommande = ligneCommandeService.getAllLignesCommandes();

		return new ModelAndView("ligneCommandeListe", "listeLC", listeLigneCommande);
	}

	/**
	 * Methode pour modifier une ligne de commande
	 * 
	 * @return dans un premier temps vers le formulaire de modification de la
	 *         ligne ciblée puis vers la liste générale si la modification a été
	 *         concluante
	 */
	@RequestMapping(value = "/updateLigneCommande", method = RequestMethod.GET)
	public String updtLigneCommande(Model modele, @RequestParam(value = "error", required = false) String error) {

		if (error != null) {
			modele.addAttribute("error", error);
		}

		modele.addAttribute("lcModif", new LigneCommande());

		return "ligneCommandeUpdate";
	}

	@RequestMapping(value = "/updateLCLink", method = RequestMethod.GET)
	public String updtLigneCommandeLien(Model modele, @RequestParam(value = "error", required = false) String error,
			@RequestParam("pId") int id) {

		if (error != null) {
			modele.addAttribute("error", error);
		}
		LigneCommande lcIn = new LigneCommande();
		lcIn.setIdLigneCommande(id);
		LigneCommande lcOut = ligneCommandeService.getLigneCommandebyId(lcIn);
		modele.addAttribute("lcModif", lcOut);

		return "ligneCommandeUpdate";
	}

	@RequestMapping(value = "/soumettreUpdateLigneCommande", method = RequestMethod.POST)
	public String updtLigneCommandeForm(@ModelAttribute("lcModif") LigneCommande lcIn, RedirectAttributes rda) {
		int verif = ligneCommandeService.updateLigneCommande(lcIn);

		if (verif != 0) {

			return "redirect:ListeLignesCommandes";

		} else {
			rda.addAttribute("error", true);
			return "redirect:updateLigneCommande";
		}
	}

	/**
	 * Rechercher une ligne de commande par le numero de commande
	 * 
	 * @return dans un premier temps vers le formulaire de recherche de la ligne
	 *         ciblée puis affiche la ligne souhaitée si la commande ciblée
	 *         existe
	 */
	@RequestMapping(value = "/searchLigneCommandebyIdORbyCommande", method = RequestMethod.GET)
	public String searchLigneCommandebyCommande(Model modele,
			@RequestParam(value = "error", required = false) String error) {

		if (error != null) {
			modele.addAttribute("error", error);
		}

		modele.addAttribute("lcSearch2", new LigneCommande());
		return "ligneCommandeSearch";
	}

	@RequestMapping(value = "/soumettreSearchLigneCommandebyIdORbyCommande", method = RequestMethod.POST)
	public String searchLigneCommandebyIdORbyCommandeForm(ModelMap modele,
			@ModelAttribute("ligneCommandeSearch") LigneCommande lcIn, Commande coIn, RedirectAttributes rda) {

		List<LigneCommande> liste = ligneCommandeService.getLigneCommandebyIdORbyNoCmd(lcIn, coIn);

		if (liste != null) {

			modele.addAttribute("lcFind2", liste);

			return "ligneCommandeSearch";

		} else {
			rda.addAttribute("error", true);
			return "redirect:searchLigneCommandebyIdORbyCommande";
		}
	}

	/**
	 * Supprimer une ligne de commande
	 * 
	 * @return la liste des lignes de commandes actualisée
	 */
	@RequestMapping(value = "/deleteLCLink/{pId}", method = RequestMethod.GET)
	public String deleteLigneCommandeLien(ModelMap model, @PathVariable("pId") int id) {

		LigneCommande lcIn = new LigneCommande();
		lcIn.setIdLigneCommande(id);

		ligneCommandeService.deleteLigneCommande(lcIn);

		// Recuperation de la liste des lignes de commandes
		List<LigneCommande> listeLigneCommande = ligneCommandeService.getAllLignesCommandes();

		model.addAttribute("afficherLigneC", listeLigneCommande);
		return "ligneCommandeListe";

	}

}

package fr.adaming.controllers;

import java.awt.LinearGradientPaint;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/commande")
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

		return new ModelAndView("afficherLigneC", "listeLC", listeLigneCommande);
	}

	/**
	 * Methode pour modifier une ligne de commande
	 * 
	 * @return dans un premier temps vers le formulaire de modification de la
	 *         ligne ciblée puis vers la liste générale si la modification a été
	 *         concluante
	 */
	@RequestMapping(value = "/updateLigneCommande", method = RequestMethod.GET)
	public String updtLigneCommande(Model modele) {

		modele.addAttribute("lcModif", new LigneCommande());

		return "modifLigneCommande";
	}

	@RequestMapping(value = "/soumettreUpdateLigneCommande", method = RequestMethod.POST)
	public String updtELigneCommandeForm(@ModelAttribute("lcModif") LigneCommande lcIn, RedirectAttributes rda) {
		int verif = ligneCommandeService.updateLigneCommande(lcIn);

		if (verif != 0) {

			return "redirect:ListeLignesCommandes";

		} else {
			rda.addAttribute("msg", "modification non fonctionnelle");
			return "redirect:updateLigneCommande";
		}
	}

	@RequestMapping(value = "/updateLink", method = RequestMethod.GET)
	public String modifLient(Model modele, @RequestParam("pId") int id) {

		LigneCommande lcIn = new LigneCommande();

		lcIn.setIdLigneCommande(id);

		LigneCommande lcOut = ligneCommandeService.getLigneCommandebyId(lcIn);

		modele.addAttribute("lcUpdt", lcOut);

		return "modifLigneCommande";
	}

	/**
	 * Rechercher une ligne de commande par son id
	 * 
	 * @return dans un premier temps vers le formulaire de recherche de la ligne
	 *         ciblée puis affiche la ligne souhaitée si elle existe
	 */
	@RequestMapping(value = "/searchLigneCommande", method = RequestMethod.GET)
	public ModelAndView searchLigneCommande() {

		return new ModelAndView("rechercheLigneCommande", "lcSearch", new LigneCommande());
	}

	@RequestMapping(value = "/soumettreSearchLigneCommande", method = RequestMethod.POST)
	public String searchLigneCommandeForm(ModelMap modele, @ModelAttribute("ligneCommandeSearch") LigneCommande lcIn,
			RedirectAttributes rda) {

		LigneCommande lcOut = ligneCommandeService.getLigneCommandebyId(lcIn);

		if (lcOut != null) {

			modele.addAttribute("lcFind", lcOut);

			return "trouverLigneCommande";

		} else {
			rda.addAttribute("msg", "Ligne de commande non existante");
			return "redirect:searchLigneCommande";
		}
	}

	/**
	 * Rechercher une ligne de commande par le numero de commande
	 * 
	 * @return dans un premier temps vers le formulaire de recherche de la ligne
	 *         ciblée puis affiche la ligne souhaitée si la commande ciblée
	 *         existe
	 */
	@RequestMapping(value = "/searchLigneCommandebyCommande", method = RequestMethod.GET)
	public ModelAndView searchLigneCommandebyCommande() {

		return new ModelAndView("rechercheLigneCommande", "lcSearch2", new LigneCommande());
	}

	@RequestMapping(value = "/soumettreSearchLigneCommande", method = RequestMethod.POST)
	public String searchLigneCommandebyCommandeForm(ModelMap modele,
			@ModelAttribute("ligneCommandeSearch") LigneCommande lcIn, Commande coIn, RedirectAttributes rda) {

		LigneCommande lcOut = (LigneCommande) ligneCommandeService.getLigneCommandeByNoCommande(lcIn, coIn);

		if (lcOut != null) {

			modele.addAttribute("lcFind2", lcOut);

			return "trouverLigneCommandebyCommande";

		} else {
			rda.addAttribute("msg", "Ligne de commande non existante pour cette commande");
			return "redirect:searchLigneCommandebyCommande";
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
		return "ListeLignesCommandes";

	}

}

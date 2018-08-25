package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Vehicule;
import fr.adaming.service.IVehiculeService;

@Controller
@RequestMapping("/vehicule")
@Scope("session")
public class VehiculeController {

	// transformation de l'association UML en JAVA
	@Autowired
	private IVehiculeService vehiculeService;

	// setter pour l'injection dependance
	public void setVehiculeService(IVehiculeService vehiculeService) {
		this.vehiculeService = vehiculeService;
	}

	// ******************* recup de la liste des vehicules
	/**
	 * Méthode d'affichage de la liste des vehicules
	 * 
	 * @return modelAndView
	 */
	@RequestMapping(value = "/listeVehicule", method = RequestMethod.GET)
	public ModelAndView afficheListeVehicule() {

		// recuperer la liste d'offres à partir de service
		List<Vehicule> listingVehicule= vehiculeService.getAllVehicule();

		return new ModelAndView("vehiculeListe", "allOffresVehicule", listingVehicule);
	}

	// ******************* ajouter un vehicule
	/**
	 * Méthode du formulaire d'ajout d'un vehicule
	 * 
	 * @param modele
	 *            correspondant à un vehicule
	 * @return page ajout vehicule
	 */
	@RequestMapping(value = "/ajouterVehicule", method = RequestMethod.GET)
	public String afficheFormAjoutVehicule(Model modele) {
		modele.addAttribute("vehiculeAjout", new Vehicule());
		return "vehiculeAjouter";
	}

	/**
	 * Méthode pour soumettre l'ajout d'un vehicule
	 * 
	 * @param vAjout,
	 *            un objet vehicule
	 * @param rda,
	 *            attribut message d'erreur
	 * @return page de liste si succès, d'ajout si echec
	 */
	@RequestMapping(value = "/soumettreAjoutVehicule", method = RequestMethod.POST)
	public String soumettreAjoutForm(@ModelAttribute("vehiculeAjout") Vehicule vAjout, RedirectAttributes rda){
		// appel de la methode service pour ajouter l'offre
		Vehicule v1= vehiculeService.addVehicule(vAjout);

		if (v1.getIdVehicule() != 0) {
			// je vais rediriger la requete vers la methode liste
			return "redirect:listeVehicule";
		} else {
			rda.addAttribute("error", "L'ajout du vehicule a échoué");

			// redirection vers la methode ajouterOffre
			return "redirect:ajouterVehicule";
		}
	}

	// ******************************************* methode pour rechercher un
	// vehicule par sa categorie
	/**
	 * Méthode du formulaire de recherche
	 * 
	 * @return ModelAndView avec un vehicule en modèle et en vue la page
	 *         recherche
	 */
	@RequestMapping(value = "/rechercherVehicule", method = RequestMethod.GET)
	public String afficherFormRechercheVehicule(Model modele,
			@RequestParam(value = "error", required = false) String error) {
		if (error != null) {
			modele.addAttribute("error", error);
		}
		modele.addAttribute("SearchVehicule", new Vehicule());
		return "vehiculeRecherche";
	}

	/**
	 * Methode pour soumettre la recherche
	 * 
	 * @param v1,
	 *            un vehicule
	 * @param rda,
	 *            attribut message d'erreur
	 * @param modele,
	 *            contiendra une liste de vehicule si elle est non nulle
	 * @return page recherche ou redirection vers la methode
	 *         rechercher
	 */
	@RequestMapping(value = "/soumettreRechercheVehicule", method = RequestMethod.POST)
	public String soumettreSearch(@ModelAttribute("SearchVehicule") Vehicule v1, RedirectAttributes rda,
			ModelMap modele) {
		List<Vehicule> listeVOut= vehiculeService.getVehiculeByCate(v1);
		if (listeVOut.size() != 0) {
			// ajouter dans le modele, la liste de vehicule
			modele.addAttribute("listeSearchVehicule", listeVOut);
			return "vehiculeRecherche";
		} else {
			rda.addAttribute("error", true);
			return "redirect:rechercherVehicule";
		}
	}

	// ***************************************** methode pour supprimer un vehicule

	/**
	 * Méthode du formulaire de suppression d'un vehicule
	 * 
	 * @param modele
	 *            correspondant à un vehicule
	 * @return page de suppression d'un vehicule
	 */
	@RequestMapping(value = "/supprimerVehicule", method = RequestMethod.GET)
	public String afficheFormASupprimerVehicule(Model modele) {
		modele.addAttribute("vehiculeSuppr", new Vehicule());
		return "vehiculeSupprimer";
	}

	/**
	 * Méthode pour soumettre la suppression d'un vehicule
	 * 
	 * @param vSuppr,
	 *            un objet un vehicule à supprimer
	 * @param rda,
	 *            attribut message d'erreur
	 * @return redirection vers les méthodes liste (si succès de la suppression)
	 *         ou suppr (si echec de la suppression)
	 */
	@RequestMapping(value = "/soumettreSupprVehicule", method = RequestMethod.POST)
	public String soumettreSupprForm(@ModelAttribute("vehiculeSuppr") Vehicule vSuppr, RedirectAttributes rda) {
		// appel de la methode service pour ajouter le vehicule
		int retour = vehiculeService.deleteVehicule(vSuppr);

		if (retour != 0) {
			// je vais rediriger la requete vers la methode liste
			return "redirect:listeVehicule";
		} else {
			rda.addAttribute("error", "La suppression de ce véhicule a échoué");

			// redirection vers la methode supprimer Offre
			return "redirect:supprimerVehicule";
		}
	}

	// ******************* modifier un vehicule
	/**
	 * Méthode du formulaire de modification d'un vehicule
	 * 
	 * @param modele
	 *            correspondant à un vehicule
	 * @return page de modification d'un vehicule
	 */
	@RequestMapping(value = "/modifierVehicule", method = RequestMethod.GET)
	public String afficheFormModifVehicule(Model modele) {

		modele.addAttribute("vehiculeModif", new Vehicule());
		return "vehiculeModifier";
	}

	/**
	 * Méthode pour soumettre la modification d'un vehicule
	 * 
	 * @param un
	 *            objet vehicule
	 * @param rda,
	 *            attribut message d'erreur
	 * @return page de liste si succès, d'ajout si echec
	 */
	@RequestMapping(value = "/soumettreModifVehicule", method = RequestMethod.POST)
	public String soumettreModifForm(@ModelAttribute("vehiculeModif") Vehicule vModif, RedirectAttributes rda){

		// appel de la methode service pour ajouter l'offre
		int retour = vehiculeService.updateVehicule(vModif);

		if (retour != 0) {
			// je vais rediriger la requete vers la methode liste
			return "redirect:listeVehicule";
		} else {
			rda.addAttribute("error", "La modification de ce véhicule a échoué");

			// redirection vers la methode modifierOffre
			return "redirect:modifierVehicule";
		}
	}


}

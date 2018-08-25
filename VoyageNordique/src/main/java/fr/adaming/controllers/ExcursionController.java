package fr.adaming.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Excursion;
import fr.adaming.model.OffreVoyage;
import fr.adaming.service.IExcursionService;

@Controller
@RequestMapping("/excursion")
@Scope("session")
public class ExcursionController {

	// transformation de l'association UML en JAVA
	@Autowired
	private IExcursionService excursionService;

	// setter obligatoire pour l'injection dependance
	public void setExcursionService(IExcursionService excursionService) {
		this.excursionService = excursionService;
	}

	private FileUpload file;

	// declaration des getter et setter de file
	public FileUpload getFile() {
		return file;
	}

	public void setFile(FileUpload file) {
		this.file = file;
	}

	// *************** methode pour recuperer les images et les envoyer � la
	// page jsp
	@RequestMapping(value = "/getImage", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] recupImage(@RequestParam("pId") int id) throws IOException {
		Excursion excu = excursionService.getExcuById(id);

		if (excu.getImageExcursion() == null) {
			return new byte[0];
		} else {
			return IOUtils.toByteArray(new ByteArrayInputStream(excu.getImageExcursion()));
		}
	}

	// ******************* recup de la liste des excursions
	/**
	 * M�thode d'affichage de la liste des excursions
	 * 
	 * @return modelAndView
	 */
	@RequestMapping(value = "/listeExcursions", method = RequestMethod.GET)
	public ModelAndView afficheListeExcursion() {

		// recuperer la liste des excursions � partir de service
		List<Excursion> listingExcursion= excursionService.getAllExcursions();

		return new ModelAndView("excursionListe", "allExcursions", listingExcursion);
	}

	// ******************* ajouter une excursion
	/**
	 * M�thode du formulaire d'ajout d'une excursion
	 * 
	 * @param modele
	 *            correspondant � une excursion
	 * @return page ajout d'excursion
	 */
	@RequestMapping(value = "/ajouterExcursion", method = RequestMethod.GET)
	public String afficheFormAjoutExcursion(Model modele) {
		modele.addAttribute("excursionAjout", new Excursion());
		return "excursionAjouter";
	}

	/**
	 * M�thode d'ajout d'une excursion pour la soumettre
	 * 
	 * @param excuAjout,
	 *            un objet excursion
	 * @param rda,
	 *            attribut message d'erreur
	 * @param file,
	 *            un multipartFile pour l'image
	 * @return page de liste si succ�s, d'ajout si echec
	 * @throws IOException
	 */
	@RequestMapping(value = "/soumettreAjoutExcursion", method = RequestMethod.POST)
	public String soumettreAjoutForm(@ModelAttribute("excursionAjout") Excursion eAjout, RedirectAttributes rda,
			MultipartFile file) throws IOException {
		if (file != null) {
			// transformer l'image en tableau de byte
			eAjout.setImageExcursion(file.getBytes());
		}

		// appel de la methode service pour ajouter
		Excursion e2= excursionService.addExcursion(eAjout);

		if (e2.getIdExcursion() != 0) {
			// je vais rediriger la requete vers la methode liste des excursions
			return "redirect:listeExcursions";
		} else {
			rda.addAttribute("error", "L'ajout de cette nouvelle excursion a �chou�");

			// redirection vers la methode ajouterOffre
			return "redirect:ajouterExcursion";
		}
	}

	// ******************************************* methode pour rechercher une excursion par nom
	/**
	 * M�thode du formulaire de recherche excursion par nom
	 * 
	 * @return ModelAndView avec une excursion en mod�le et en vue la page
	 *         recherche
	 */
	@RequestMapping(value = "/rechercherExcursion", method = RequestMethod.GET)
	public String afficherFormRechercheExcursion(Model modele,
			@RequestParam(value = "error", required = false) String error) {
		if (error != null) {
			modele.addAttribute("error", error);
		}
		modele.addAttribute("SearchExcursion", new Excursion());
		return "excursionRecherche";
	}

	/**
	 * Methode pour soumettre la recherche
	 * 
	 * @param e1,
	 *            un objet excursion
	 * @param rda,
	 *            attribut message d'erreur
	 * @param modele,
	 *            contiendra l'excursion si elle est non nulle
	 * @return page recherche ou redirection vers la methode
	 *         recherche
	 */
	@RequestMapping(value = "/soumettreSearchExcursion", method = RequestMethod.POST)
	public String soumettreSearchExcursion(@ModelAttribute("SearchExcursion") Excursion e1, RedirectAttributes rda,
			ModelMap modele) {
		Excursion eOut=excursionService.getExcuByName(e1);
		
		if (eOut != null) {
			// ajouter dans le modele, l'excursion trouv�e
			modele.addAttribute("SearchExcursion", eOut);
			return "excursionRecherche";
		} else {
			rda.addAttribute("error", true);
			return "redirect:rechercherExcursion";
		}
	}

	// ***************************************** methode pour supprimer une
	// excursion

	/**
	 * M�thode du formulaire de suppression d'une excursion
	 * 
	 * @param modele
	 *            correspondant � une excursion
	 * @return page de suppression d'excursion
	 */
	@RequestMapping(value = "/supprimerExcursion", method = RequestMethod.GET)
	public String afficheFormASupprimerExcu(Model modele) {
		modele.addAttribute("excursionSuppr", new Excursion());
		return "excursionSupprimer";
	}

	/**
	 * M�thode pour soumettre la suppression d'une excursion
	 * 
	 * @param eSuppr,
	 *            un objet excursion � supprimer
	 * @param rda,
	 *            attribut message d'erreur
	 * @return redirection vers les m�thodes liste (si succ�s de la suppression)
	 *         ou suppr (si echec de la suppression)
	 */
	@RequestMapping(value = "/soumettreSupprExcursion", method = RequestMethod.POST)
	public String soumettreSupprForm(@ModelAttribute("excursionSuppr") Excursion eSuppr, RedirectAttributes rda) {
		// appel de la methode service pour supprimer l'excursion
		int retour = excursionService.deleteExcursion(eSuppr);

		if (retour != 0) {
			// je vais rediriger la requete vers la methode liste des offres
			return "redirect:listeExcursions";
		} else {
			rda.addAttribute("error", "La suppression de cette excursion a �chou�");

			// redirection vers la methode supprimer Offre
			return "redirect:supprimerExcursion";
		}
	}

	// ******************* modifier une excursion
	/**
	 * M�thode du formulaire de modification d'une excursion
	 * 
	 * @param modele
	 *            correspondant � une excursion
	 * @return page de modification d'excursion
	 */
	@RequestMapping(value = "/modifierExcursion", method = RequestMethod.GET)
	public String afficheFormModifExcursion(Model modele) {

		modele.addAttribute("excursionModif", new Excursion());
		return "excursionModifier";
	}

	/**
	 * M�thode pour soumettre la modification de l'excursion
	 * 
	 * @param eModif, un
	 *            objet excursion
	 * @param rda,
	 *            attribut message d'erreur
	 * @param file,
	 *            un multipartFile pour l'image
	 * @return page de liste si succ�s, d'ajout si echec
	 * @throws IOException
	 */
	@RequestMapping(value = "/soumettreModifExcursion", method = RequestMethod.POST)
	public String soumettreModifForm(@ModelAttribute("excursionModif") Excursion eModif, RedirectAttributes rda,
			MultipartFile file) throws IOException {
		if (file != null) {
			// transformer l'image en tableau de byte
			eModif.setImageExcursion(file.getBytes());
		}

		// appel de la methode service pour modifier l'excursion
		int retour = excursionService.updateExcursion(eModif);

		if (retour != 0) {
			// je vais rediriger la requete vers la methode liste des excursions
			return "redirect:listeExcursions";
		} else {
			rda.addAttribute("error", "La modification de cette excursion a �chou�");

			// redirection vers la methode modifierExcursion
			return "redirect:modifierExcursion";
		}
	}

}

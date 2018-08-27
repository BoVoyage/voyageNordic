package fr.adaming.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Hebergement;
import fr.adaming.service.IHebergementService;

@Controller
@RequestMapping("/admin/hebergement")
@Scope("session")
public class HebergementController {

	// **********************************************************************************************
	/** Transformation de l'asso UML en JAVA */
	@Autowired
	private IHebergementService hebService;

	// ** Declaration du setter pour l'injection dependance*/

	/**
	 * @param hebService
	 *            the hebService to set
	 */
	public void setHebService(IHebergementService hebService) {
		this.hebService = hebService;
	}

	private FileUpload file;

	// declaration des getter et setter de file
	public FileUpload getFile() {
		return file;
	}

	public void setFile(FileUpload file) {
		this.file = file;
	}

	// *************** methode pour recuperer les images et les envoyer à la
	// page jsp
	@RequestMapping(value = "/getImage", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] recupImage(@RequestParam("pId") int id) throws IOException {
		Hebergement heb = hebService.getHebById(id);

		if (heb.getImageHebergement() == null) {
			return new byte[0];
		} else {
			return IOUtils.toByteArray(new ByteArrayInputStream(heb.getImageHebergement()));
		}
	}

	// ************************************************************************************************
	// ******$$$$$$$$$$$$$$$**********
	/**
	 * Methode recuperation de la liste des hébergements. On utilise la methode
	 * ModelAndView
	 */

	@RequestMapping(value = "/admin/listeHebergements", method = RequestMethod.GET)
	public ModelAndView afficheListeHebergements() {

		/** Recuperation de la liste des offres */
		List<Hebergement> listeHebergements = hebService.getAllHebergements();
		return new ModelAndView("hebergementListe", "allHebergements", listeHebergements);
	}

	// ***********************************************************************************************
	// ******$$$$$$$$$$$$$$$**********
	/** Le formulaire AjoutClient */
	@RequestMapping(value = "/admin/ajouterHebergement", method = RequestMethod.GET)
	public String afficheFormulaireAddHeb(Model modele, @RequestParam(value = "msg", required = false) String msg) {
		modele.addAttribute("ajoutHeb", new Hebergement());
		if (msg != null) {
			modele.addAttribute("msg", msg);
		}
		return "hebergementAjout";
	}

	// ******$$$$$$$$$$$$$$$**********
	/**
	 * Methode ajout d'un hébergement. On utilise la methode String qui accepte
	 * des args en entrée
	 */
	@RequestMapping(value = "/admin/soumettreAjoutHebergement", method = RequestMethod.POST)
	public String soumettreAjoutFormulaireHeb(@Valid @ModelAttribute("ajoutHeb") Hebergement hebAjout, RedirectAttributes rda,
			MultipartFile file) throws IOException {
		if (file != null) {
			// transformer l'image en tableau de byte
			hebAjout.setImageHebergement(file.getBytes());
		}

		// appel de la methode service pour ajouter l'offre
		Hebergement heb2 = hebService.addHebergement(hebAjout);

		if (heb2.getIdHebergement() != 0) {
			// je vais rediriger la requete vers la methode liste des offres
			return "redirect:listeHebergements";
		} else {
			rda.addAttribute("msg", true);

			// redirection vers la methode ajouterOffre
			return "redirect:ajouterHebergement";
		}
	}

	// ***********************************************************************************************
	// ******$$$$$$$$$$$$$$$**********

	// methode Modifier un Client
	/**
	 * Méthode du formulaire de modification des informations d'un hébergement
	 * 
	 * @param modele
	 *            correspondant à un hébergement
	 * @return page de modification d'hébergement
	 */
	@RequestMapping(value = "/admin/modifierHebergement", method = RequestMethod.GET)
	public String afficheFormModifHeb(Model modele, @RequestParam(value = "msg", required = false) String msg) {
		modele.addAttribute("hebModif", new Hebergement());
		if (msg != null) {
			modele.addAttribute("msg", msg);
		}
		return "hebergementModif";
	}

	/**
	 * Méthode pour soumettre la modification de l'hébergement
	 * 
	 * @param un
	 *            objet hébergement
	 * @param rda,
	 *            attribut message d'erreur
	 * @param file,
	 *            un multipartFile pour l'image
	 * @return page de liste si succès, de modification si échec
	 * @throws IOException
	 */
	@RequestMapping(value = "/admin/soumettreModifHeb", method = RequestMethod.POST)
	public String soumettreModifFormHeb(@Valid @ModelAttribute("hebModif") Hebergement hebModif, RedirectAttributes rda,
			MultipartFile file) throws IOException {
		if (file != null) {
			// transformer l'image en tableau de byte
			hebModif.setImageHebergement(file.getBytes());
		}

		// appel de la methode service pour ajouter l'offre
		int retour = hebService.updateHebergement(hebModif);

		if (retour != 0) {
			// je vais rediriger la requete vers la methode liste des offres
			return "redirect:listeHebergements";
		} else {
			rda.addAttribute("msg", true);

			// redirection vers la methode modifierOffre
			return "redirect:modifierHebergement";
		}
	}

	@RequestMapping(value = "/modifLinkHeb", method = RequestMethod.GET)
	public String modifLien(Model modele, @RequestParam("pNom") String nomHeb) {
		Hebergement hebIn = new Hebergement();
		hebIn.setNomHebergement(nomHeb);
		Hebergement hebOut = hebService.getHebByName(hebIn);
		modele.addAttribute("hebModif", hebOut);
		return "hebergementModif";
	}
	// ***********************************************************************************************
	// ******$$$$$$$$$$$$$$$**********

	/**
	 * Méthode du formulaire de suppression d'un hébergement
	 * 
	 * @param modele
	 *            correspondant à un hébergement
	 * @return page de suppression d'hébergement
	 */
	@RequestMapping(value = "/admin/supprimerHebergement", method = RequestMethod.GET)
	public String afficheFormASupprimerHeb(Model modele, @RequestParam(value = "msg", required = false) String msg) {
		modele.addAttribute("hebSuppr", new Hebergement());
		if (msg != null) {
			modele.addAttribute("msg", msg);
		}
		return "hebergementSupprimer";
	}

	/**
	 * Méthode pour soumettre la suppression d'une offre de voyage
	 * 
	 * @param ovSuppr,
	 *            un objet offre de voyage à supprimer
	 * @param rda,
	 *            attribut message d'erreur
	 * @return redirection vers les méthodes liste (si succès de la suppression)
	 *         ou suppr (si echec de la suppression)
	 */
	@RequestMapping(value = "/admin/soumettreSupprHeb", method = RequestMethod.POST)
	public String soumettreSupprForm(@ModelAttribute("hebSuppr") Hebergement hebSuppr, RedirectAttributes rda) {
		// appel de la methode service pour ajouter l'offre
		int retour = hebService.deleteHebergement(hebSuppr);

		if (retour != 0) {
			// je vais rediriger la requete vers la methode liste des offres
			return "redirect:listeHebergements";
		} else {
			rda.addAttribute("msg", true);

			// redirection vers la methode supprimer Offre
			return "redirect:hebergementSupprimer";
		}
	}

	@RequestMapping(value = "/supprHebLink/{pNom}")
	public String supprLien(ModelMap model, @PathVariable("pNom") String nomHeb) {
		Hebergement hebIn = new Hebergement();
		hebIn.setNomHebergement(nomHeb);
		hebService.deleteHebergement(hebIn);

		// Récupérer la liste de service
		List<Hebergement> listeHebergements = hebService.getAllHebergements();
		model.addAttribute("allHebergements", listeHebergements);
		return "hebergementListe";
	}

	// ***********************************************************************************************
	// ******$$$$$$$$$$$$$$$**********
	// Formulaire de recherche
	/**
	 * Méthode du formulaire de recherche par nom de l'hébergement
	 * 
	 * @return ModelAndView avec une offre de voyage en modèle et en vue la page
	 *         recherche
	 */
	@RequestMapping(value = "/admin/rechercherParNomHeb", method = RequestMethod.GET)
	public String afficherFormRechercheNoVoyage(Model modele,
			@RequestParam(value = "error", required = false) String error) {
		if (error != null) {
			modele.addAttribute("error", error);
		}
		modele.addAttribute("SearchNomHeb", new Hebergement());
		return "hebergementRecherche";
	}

	/**
	 * Methode pour soumettre la recherche
	 * 
	 * @param ov1,
	 *            un objet hébergement
	 * @param rda,
	 *            attribut message d'erreur
	 * @param modele,
	 *            contiendra l'hébergement si il est non nul
	 * @return page recherche ou redirection vers la methode rechercherParNom
	 */
	@RequestMapping(value = "/admin/soumettreSearchHeb", method = RequestMethod.POST)
	public String soumettreSearch(@ModelAttribute("SearchNomHeb") Hebergement heb1, RedirectAttributes rda,
			ModelMap modele) {
		Hebergement hebOut = hebService.getHebByName(heb1);
		if (hebOut != null) {
			// ajouter dans le modele, l'offre trouvée
			modele.addAttribute("foundHeb", hebOut);
			return "hebergementRecherche";
		} else {
			rda.addAttribute("error", true);
			return "redirect:hebergementRecherche";
		}
	}
}

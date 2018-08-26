package fr.adaming.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Excursion;
import fr.adaming.model.Hebergement;
import fr.adaming.model.OffreVoyage;
import fr.adaming.model.Vehicule;
import fr.adaming.service.IExcursionService;
import fr.adaming.service.IHebergementService;
import fr.adaming.service.IOffreVoyageService;
import fr.adaming.service.IVehiculeService;

@Controller
@RequestMapping("/offreVoyage")
@Scope("session")
public class OffreVoyageController {

	// transformation de l'association UML en JAVA
	@Autowired
	private IOffreVoyageService offreVoyageService;

	// declaration du setter obligatoire pour l'injection-dependance
	/**
	 * @param offreVoyageService
	 *            the offreVoyageService to set
	 */
	public void setOffreVoyageService(IOffreVoyageService offreVoyageService) {
		this.offreVoyageService = offreVoyageService;
	}
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
	
	// transformation de l'association UML en JAVA
	@Autowired
	private IVehiculeService vehiculeService;

	// setter pour l'injection dependance
	public void setVehiculeService(IVehiculeService vehiculeService) {
		this.vehiculeService = vehiculeService;
	}
	
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

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		formatDate.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(formatDate, false));
	}

	// *************** methode pour recuperer les images et les envoyer à la
	// page jsp
	@RequestMapping(value = "/getImage", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] recupImage(@RequestParam("pId") int id) throws IOException {
		OffreVoyage voyage = offreVoyageService.getOffreVoyageById(id);

		if (voyage.getImageDestination() == null) {
			return new byte[0];
		} else {
			return IOUtils.toByteArray(new ByteArrayInputStream(voyage.getImageDestination()));
		}
	}

	// ******************* recup de la liste des offres
	/**
	 * Méthode d'affichage de l'accueil
	 * 
	 * @return modelAndView
	 */
	@RequestMapping(value = "/accueil", method = RequestMethod.GET)
	public String afficheAccueil(Model modele) {

		// recuperer la liste d'offres à partir de service
		List<OffreVoyage> listingOffres = offreVoyageService.getAllOffres();
		List<OffreVoyage> listingPromo = offreVoyageService.getOffresPromoService();
		modele.addAttribute("allOffresVoyage", listingOffres);
		modele.addAttribute("allOffresPromo", listingPromo);
		return "accueil";
	}

	// ******************* recup de la liste des offres
	/**
	 * Méthode d'affichage de l'accueil
	 * 
	 * @return modelAndView
	 */
	@RequestMapping(value = "/detailsOffre", method = RequestMethod.GET)
	public String modifLien(Model modele, @RequestParam("pId") int idVoyage) {
		OffreVoyage ovIn = new OffreVoyage();
		ovIn.setIdVoyage(idVoyage);
		OffreVoyage ovOut = offreVoyageService.getOffreVoyageById(ovIn.getIdVoyage());
		modele.addAttribute("ovDetails", ovOut);
		Hebergement hebout = ovOut.getHebergement();
		modele.addAttribute("hebDetails", hebout);
		Vehicule vOut = ovOut.getVehicule();
		modele.addAttribute("vDetails", vOut);
		List<Excursion> listeExOut = ovOut.getListeExcursion();
		modele.addAttribute("exListe", listeExOut);
		
		return "detailsOffre";
	}

	// ******************* recup de la liste des offres
	/**
	 * Méthode d'affichage de la liste des offres
	 * 
	 * @return modelAndView
	 */
	@RequestMapping(value = "/listeOffreVoyage", method = RequestMethod.GET)
	public String afficheListeOffre(Model modele) {

		// recuperer la liste d'offres à partir de service
		List<OffreVoyage> listingOffres = offreVoyageService.getAllOffres();
		List<OffreVoyage> listingPromo = offreVoyageService.getOffresPromoService();
		modele.addAttribute("allOffresVoyage", listingOffres);
		modele.addAttribute("allOffresPromo", listingPromo);
		return "offreListe";
	}

	// ******************* recup de la liste des offres en promo
	/**
	 * Méthode d'affichage de la liste des offres en promo
	 * 
	 * @return modelAndView
	 */
	@RequestMapping(value = "/listeOffrePromo", method = RequestMethod.GET)
	public ModelAndView afficheListePromo() {

		// recuperer la liste d'offres à partir de service
		List<OffreVoyage> listingPromo = offreVoyageService.getOffresPromoService();

		return new ModelAndView("promoListe", "allOffresPromo", listingPromo);
	}

	// ******************* ajouter une offre de voyage
	/**
	 * Méthode du formulaire d'ajout d'une offre de voyage
	 * 
	 * @param modele
	 *            correspondant à une offre de voyage
	 * @param error,
	 *            un string
	 * @return page ajout d'offre
	 */
	@RequestMapping(value = "/ajouterOffre", method = RequestMethod.GET)
	public String afficheFormAjoutOffre(Model modele, @RequestParam(value = "error", required = false) String error) {
		if (error != null) {
			modele.addAttribute("error", error);
		}
		modele.addAttribute("offreAjout", new OffreVoyage());
		return "offreAjouter";
	}

	/**
	 * Méthode d'ajout d'une offre de voyage pour la soumettre
	 * 
	 * @param ovAjout,
	 *            un objet offre de voyage
	 * @param rda,
	 *            attribut message d'erreur
	 * @param file,
	 *            un multipartFile pour l'image
	 * @return page de liste si succès, d'ajout si echec
	 * @throws IOException
	 */
	@RequestMapping(value = "/soumettreAjoutOffre", method = RequestMethod.POST)
	public String soumettreAjoutForm(@ModelAttribute("offreAjout") OffreVoyage ovAjout, RedirectAttributes rda,
			MultipartFile file) throws IOException {
		if (file != null) {
			// transformer l'image en tableau de byte
			ovAjout.setImageDestination(file.getBytes());
		}

		// appel de la methode service pour ajouter l'offre
		OffreVoyage ov2 = offreVoyageService.addOffreVoyage(ovAjout);

		if (ov2.getIdVoyage() != 0) {
			// je vais rediriger la requete vers la methode liste des offres
			return "redirect:listeOffreVoyage";
		} else {
			rda.addAttribute("error", true);

			// redirection vers la methode ajouterOffre
			return "redirect:ajouterOffre";
		}
	}

	// ******************************************* methode pour rechercher une
	// offre de voyage par no voyage
	/**
	 * Méthode du formulaire de recherche par no du voyage
	 * 
	 * @return ModelAndView avec une offre de voyage en modèle et en vue la page
	 *         recherche
	 */
	@RequestMapping(value = "/rechercherParNoVoyage", method = RequestMethod.GET)
	public String afficherFormRechercheNoVoyage(Model modele,
			@RequestParam(value = "error", required = false) String error) {
		if (error != null) {
			modele.addAttribute("error", error);
		}
		modele.addAttribute("SearchNoVoyage", new OffreVoyage());
		return "offreRecherche";
	}

	/**
	 * Methode pour soumettre la recherche
	 * 
	 * @param ov1,
	 *            un objet offre de voyage
	 * @param rda,
	 *            attribut message d'erreur
	 * @param modele,
	 *            contiendra l'offre de voyage si elle est non nulle
	 * @return page recherche ou redirection vers la methode
	 *         rechercherParNoVoyage
	 */
	@RequestMapping(value = "/soumettreSearch", method = RequestMethod.POST)
	public String soumettreSearch(@ModelAttribute("SearchNoVoyage") OffreVoyage ov1, RedirectAttributes rda,
			ModelMap modele) {
		OffreVoyage ovOut = offreVoyageService.getOffreVoyageByNoVoyage(ov1);
		if (ovOut != null) {
			// ajouter dans le modele, l'offre trouvée
			modele.addAttribute("SearchNoVoyage", ovOut);
			return "offreRecherche";
		} else {
			rda.addAttribute("error", true);
			return "redirect:rechercherParNoVoyage";
		}
	}

	// ***************************************** methode pour supprimer une
	// offre de voyage

	/**
	 * Méthode du formulaire de suppression d'une offre de voyage
	 * 
	 * @param modele
	 *            correspondant à une offre de voyage
	 * @param error,
	 *            un string
	 * @return page de suppression d'offre
	 */
	@RequestMapping(value = "/supprimerOffre", method = RequestMethod.GET)
	public String afficheFormASupprimerOffre(Model modele,
			@RequestParam(value = "error", required = false) String error) {
		if (error != null) {
			modele.addAttribute("error", error);
		}
		modele.addAttribute("offreSuppr", new OffreVoyage());
		return "offreSupprimer";
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
	@RequestMapping(value = "/soumettreSupprOffre", method = RequestMethod.POST)
	public String soumettreSupprForm(@ModelAttribute("offreSuppr") OffreVoyage ovSuppr, RedirectAttributes rda) {
		// appel de la methode service pour ajouter l'offre
		int retour = offreVoyageService.deleteOffreVoyage(ovSuppr);

		if (retour != 0) {
			// je vais rediriger la requete vers la methode liste des offres
			return "redirect:listeOffreVoyage";
		} else {
			rda.addAttribute("error", true);

			// redirection vers la methode supprimer Offre
			return "redirect:supprimerOffre";
		}
	}

	// ******************* modifier une offre de voyage
	/**
	 * Méthode du formulaire de modification d'une offre de voyage
	 * 
	 * @param modele
	 *            correspondant à une offre de voyage
	 * @param error,
	 *            un string
	 * @return page ajout d'offre
	 */
	@RequestMapping(value = "/modifierOffre", method = RequestMethod.GET)
	public String afficheFormModifOffre(Model modele, @RequestParam(value = "error", required = false) String error) {
		if (error != null) {
			modele.addAttribute("error", error);
		}
		// recuperer la liste des numeros d'offre voyage à partir de service
		// (liste deroulante)
		List<String> listingNoVoyage = offreVoyageService.getAllNoVoyage();
		modele.addAttribute("listeNo", listingNoVoyage);

		modele.addAttribute("offreModif", new OffreVoyage());
		return "offreModifier";
	}

	/**
	 * Méthode pour soumettre la modification de l'offre de voyage
	 * 
	 * @param un
	 *            objet offre de voyage
	 * @param rda,
	 *            attribut message d'erreur
	 * @param file,
	 *            un multipartFile pour l'image
	 * @return page de liste si succès, d'ajout si echec
	 * @throws IOException
	 */
	@RequestMapping(value = "/soumettreModifOffre", method = RequestMethod.POST)
	public String soumettreModifForm(@ModelAttribute("offreModif") OffreVoyage ovModif, RedirectAttributes rda,
			MultipartFile file) throws IOException {
		if (file != null) {
			// transformer l'image en tableau de byte
			ovModif.setImageDestination(file.getBytes());
		}

		// appel de la methode service pour ajouter l'offre
		int retour = offreVoyageService.updateOffreVoyage(ovModif);

		if (retour != 0) {
			// je vais rediriger la requete vers la methode liste des offres
			return "redirect:listeOffreVoyage";
		} else {
			rda.addAttribute("error", true);

			// redirection vers la methode modifierOffre
			return "redirect:modifierOffre";
		}
	}

	// ******************* clore une offre de voyage
	/**
	 * Méthode du formulaire permettant de clore une offre pour qu'elle soit
	 * visible mais plus accessible.
	 * 
	 * @param modele
	 *            correspondant à une offre de voyage
	 * @param error,
	 *            un string
	 * @return page de cloture d'offre
	 */
	@RequestMapping(value = "/cloreOffre", method = RequestMethod.GET)
	public String afficheFormCloreOffre(Model modele, @RequestParam(value = "error", required = false) String error) {

		modele.addAttribute("offreClose", new OffreVoyage());

		if (error != null) {
			modele.addAttribute("error", error);
		}
		return "offreClore";
	}

	/**
	 * Méthode pour soumettre la clôture de l'offre de voyage
	 * 
	 * @param un
	 *            objet offre de voyage
	 * @param rda,
	 *            attribut message d'erreur
	 * @return page de liste si succès, d'ajout si echec
	 * @throws IOException
	 */
	@RequestMapping(value = "/soumettreCloreOffre", method = RequestMethod.POST)
	public String soumettreCloreForm(@ModelAttribute("offreClose") OffreVoyage ovClose, RedirectAttributes rda) {

		// appel de la methode service pour clore l'oddre
		int retour = offreVoyageService.closeOffreVoyageService(ovClose);

		if (retour != 0) {
			// je vais rediriger la requete vers la methode liste des offres
			return "redirect:listeOffreVoyage";
		} else {
			rda.addAttribute("error", true);

			// redirection vers la methode modifierOffre
			return "redirect:cloreOffre";
		}
	}

	// *******************Mettre une offre de voyage en promo
	/**
	 * Méthode du formulaire permettant de mettre en promo une offre de voyage.
	 * 
	 * @param modele
	 *            correspondant à une offre de voyage
	 * @param
	 * @return page de mise en promo d'une offre
	 */
	@RequestMapping(value = "/promoOffre", method = RequestMethod.GET)
	public String afficheFormPromoOffre(Model modele, @RequestParam(value = "error", required = false) String error) {
		modele.addAttribute("offrePromo", new OffreVoyage());
		if (error != null) {
			modele.addAttribute("error", error);
		}
		return "offrePromo";
	}

	/**
	 * Méthode pour soumettre la mise en promo de l'offre de voyage
	 * 
	 * @param un
	 *            objet offre de voyage
	 * @param rda,
	 *            attribut message d'erreur
	 * @return page de liste si succès, d'ajout si echec
	 * @throws IOException
	 */
	@RequestMapping(value = "/soumettrePromoOffre", method = RequestMethod.POST)
	public String soumettrePromoForm(@ModelAttribute("offrePromo") OffreVoyage ovPromo, RedirectAttributes rda) {

		// appel de la methode service pour clore l'oddre
		int retour = offreVoyageService.promoOffreVoyageService(ovPromo);

		if (retour != 0) {
			// je vais rediriger la requete vers la methode liste des offres
			return "redirect:listeOffreVoyage";
		} else {
			rda.addAttribute("error", true);

			// redirection vers la methode modifierOffre
			return "redirect:promoOffre";
		}
	}

}

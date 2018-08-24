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

import fr.adaming.model.OffreVoyage;
import fr.adaming.service.IOffreVoyageService;

@Controller
@RequestMapping("/offreVoyage")
@Scope("session")
public class OffreVoyageController {
	
	//transformation de l'association UML en JAVA
	@Autowired
	private IOffreVoyageService offreVoyageService;
	
	private FileUpload file;
	

	//declaration du setter obligatoire pour l'injection-dependance
	public void setOffreVoyageService(IOffreVoyageService offreVoyageService) {
		this.offreVoyageService = offreVoyageService;
	}
	
	//declaration des getter et setter de file
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
	
	//*************** methode pour recuperer les images et les envoyer à la page jsp
	@RequestMapping(value="/getImage",method=RequestMethod.GET,produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] recupImage(@RequestParam("pId") int id) throws IOException{
		OffreVoyage voyage=offreVoyageService.getOffreVoyageById(id);
		
		if(voyage.getImageDestination()==null){
			return new byte[0];
		}else{
			return IOUtils.toByteArray(new ByteArrayInputStream(voyage.getImageDestination()));
		}
	}
	
	
	// ******************* recup de la liste des offres
	/**
	 * Méthode d'affichage de la liste des offres
	 * @return modelAndView 
	 */
	@RequestMapping(value = "/listeOffreVoyage", method = RequestMethod.GET)
	public ModelAndView afficheListeOffre() {

		// recuperer la liste d'offres à partir de service
		List<OffreVoyage> listingOffres=offreVoyageService.getAllOffres();

		return new ModelAndView("offreListe", "allOffresVoyage", listingOffres);
	}

	// ******************* ajouter une offre de voyage
	/**
	 * Méthode du formulaire d'ajout d'une offre de voyage
	 * @param modele correspondant à une offre de voyage
	 * @return page ajout d'offre
	 */
	@RequestMapping(value = "/ajouterOffre", method = RequestMethod.GET)
	public String afficheFormAjoutOffre(Model modele) {
		modele.addAttribute("offreAjout", new OffreVoyage());
		return "offreAjouter";
	}

	/**
	 * Méthode d'ajout d'une offre de voyage pour la soumettre
	 * @param ovAjout, un objet offre de voyage
	 * @param rda, attribut message d'erreur
	 * @param file, un multipartFile pour l'image
	 * @return page de liste si succès, d'ajout si echec
	 * @throws IOException 
	 */
	@RequestMapping(value = "/soumettreAjoutOffre", method = RequestMethod.POST)
	public String soumettreAjoutForm(@ModelAttribute("offreAjout") OffreVoyage ovAjout, RedirectAttributes rda,MultipartFile file) throws IOException {
		if(file!=null){
			// transformer l'image en tableau de byte
			ovAjout.setImageDestination(file.getBytes());
		}
		
		
		// appel de la methode service pour ajouter l'offre
		OffreVoyage ov2= offreVoyageService.addOffreVoyage(ovAjout);

		if (ov2.getIdVoyage() != 0) {
			// je vais rediriger la requete vers la methode liste des offres
			return "redirect:listeOffreVoyage";
		} else {
			rda.addAttribute("error", "L'ajout de cette nouvelle offre de voyage a échoué");

			// redirection vers la methode ajouterOffre
			return "redirect:ajouterOffre";
		}
	}
	
	//******************************************* methode pour rechercher une offre de voyage par no voyage
	/**
	 * Méthode du formulaire de recherche par no du voyage
	 * @return ModelAndView avec une offre de voyage en modèle et en vue la page recherche
	 */
	@RequestMapping(value = "/rechercherParNoVoyage", method = RequestMethod.GET)
	public ModelAndView afficherFormRechercheNoVoyage() {
		return new ModelAndView("offreRecherche", "SearchNoVoyage", new OffreVoyage());
	}

	/**
	 * Methode pour soumettre la recherche
	 * @param ov1, un objet offre de voyage
	 * @param rda, attribut message d'erreur
	 * @param modele, contiendra l'offre de voyage si elle est non nulle
	 * @return page recherche ou redirection vers la methode rechercherParNoVoyage
	 */
	@RequestMapping(value = "/soumettreSearch", method = RequestMethod.POST)
	public String soumettreSearch(@ModelAttribute("SearchNoVoyage") OffreVoyage ov1, RedirectAttributes rda,
			ModelMap modele) {
		OffreVoyage ovOut= offreVoyageService.getOffreVoyageByNoVoyage(ov1);
		if (ovOut != null) {
			// ajouter dans le modele, l'offre trouvée
			modele.addAttribute("SearchNoVoyage", ovOut);
			return "offreRecherche";
		} else {
			rda.addAttribute("error", "La recherche a échoué");
			return "redirect:rechercherParNoVoyage";
		}
	}
	
	//***************************************** methode pour supprimer une offre de voyage
	
	/**
	 * Méthode du formulaire de suppression d'une offre de voyage
	 * @param modele correspondant à une offre de voyage
	 * @return page de suppression d'offre
	 */
	@RequestMapping(value = "/supprimerOffre", method = RequestMethod.GET)
	public String afficheFormASupprimerOffre(Model modele) {
		modele.addAttribute("offreSuppr", new OffreVoyage());
		return "offreSupprimer";
	}

	/**
	 * Méthode pour soumettre la suppression d'une offre de voyage
	 * @param ovSuppr, un objet offre de voyage à supprimer
	 * @param rda, attribut message d'erreur
	 * @return redirection vers les méthodes liste (si succès de la suppression) ou suppr (si echec de la suppression)
	 */
	@RequestMapping(value = "/soumettreSupprOffre", method = RequestMethod.POST)
	public String soumettreSupprForm(@ModelAttribute("offreSuppr") OffreVoyage ovSuppr, RedirectAttributes rda){
		// appel de la methode service pour ajouter l'offre
		int retour= offreVoyageService.deleteOffreVoyage(ovSuppr);

		if (retour != 0) {
			// je vais rediriger la requete vers la methode liste des offres
			return "redirect:listeOffreVoyage";
		} else {
			rda.addAttribute("error", "La suppression de cette offre de voyage a échoué");

			// redirection vers la methode supprimer Offre
			return "redirect:supprimerOffre";
		}
	}
	
	

}

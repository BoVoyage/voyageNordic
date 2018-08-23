package fr.adaming.service;

import java.util.List;

import fr.adaming.model.OffreVoyage;

public interface IOffreVoyageService {
	
	/**
	 * Methode d'ajout d'une offre de voyage
	 * @param ov correspondant à un objet offre de voyage à ajouter
	 * @return objet offre de voyage
	 */
	public OffreVoyage addOffreVoyage(OffreVoyage ov);
	
	/**
	 * Methode de listing des offres de voyage
	 * @return liste d'objets Offre de voyage
	 */
	public List<OffreVoyage> getAllOffres();

}

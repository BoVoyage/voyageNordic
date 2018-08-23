package fr.adaming.Dao;

import java.util.List;

import fr.adaming.model.OffreVoyage;

public interface IOffreVoyageDao {
	
	/**
	 * Methode d'ajout d'une offre de voyage
	 * @param ov correspondant � un objet offre de voyage � ajouter
	 * @return objet offre de voyage
	 */
	public OffreVoyage addOffreVoyage(OffreVoyage ov);
	
	/**
	 * Methode de listing des offres de voyage
	 * @return liste d'objets Offre de voyage
	 */
	public List<OffreVoyage> getAllOffres();

}

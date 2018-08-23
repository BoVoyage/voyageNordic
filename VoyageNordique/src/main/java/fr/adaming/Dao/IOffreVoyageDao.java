package fr.adaming.Dao;

import fr.adaming.model.OffreVoyage;

public interface IOffreVoyageDao {
	
	/**
	 * Methode d'ajout d'une offre de voyage
	 * @param ov correspondant � un objet offre de voyage � ajouter
	 * @return objet offre de voyage
	 */
	public OffreVoyage addOffreVoyage(OffreVoyage ov);

}

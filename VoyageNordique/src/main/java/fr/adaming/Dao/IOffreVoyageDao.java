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
	
	/**
	 * Methode de recherche d'une offre par son ID
	 * @param id de l'offre de voyage
	 * @return un objet offre de voyage
	 */
	public OffreVoyage getOffreVoyageById(int id);
	
	/**
	 * Methode de recherche d'une offre par son nom
	 * @param ov
	 * @return
	 */
	public OffreVoyage getOffreVoyageByName(OffreVoyage ov);
	
	/**
	 * Methode de recherche d'une offre par son numero
	 * @param ov, un objet offre de voyage
	 * @return un objet offre de voyage
	 */
	public OffreVoyage getOffreVoyageByNoVoyage(OffreVoyage ov);
	
	/**
	 * Methode de recherche d'une offre par son pays
	 * @param ov, un objet offre de voyage
	 * @return un objet offre de voyage
	 */
	public OffreVoyage getOffreVoyageByState(OffreVoyage ov);
	
	/**
	 * Methode de recherche d'une offre par son prix
	 * @param ov, un objet offre de voyage
	 * @return un objet offre de voyage
	 */
	public OffreVoyage getOffreVoyageByPrice(OffreVoyage ov);
	
	/**
	 * M�thode de suppression d'une offre de voyage
	 * @param ov, un objet Offre de Voyage
	 * @return int
	 */
	public int deleteOffreVoyage(OffreVoyage ov);
	
	/**
	 * M�thode de modification d'une offre de voyage
	 * @param ov, un objet offre de voyage
	 * @return int
	 */
	public int updateOffreVoyage(OffreVoyage ov);

	/**
	 * M�thode servant � d�sactiver une offre
	 * afin qu'elle soit visible mais plus r�servable
	 * @param ov, un objet offre de voyage
	 * @return int
	 */
	public int closeOffreVoyage(OffreVoyage ov);
	
	/**
	 * M�thode servant � d�sactiver une offre
	 * afin qu'elle soit visible mais plus r�servable
	 * @param ov, un objet offre de voyage
	 * @return int
	 */
	public int promoOffreVoyage(OffreVoyage ov);
	
	/**
	 * Methode de listing des offres de voyage en promo
	 * @return liste d'objets Offre de voyage en promo
	 */
	public List<OffreVoyage> getOffresPromo();
	
	/**
	 * M�thode de recuperation de la liste des numeros d'offre de voyage
	 * @return liste de String
	 */
	public List<String> getAllNoVoyage();
}

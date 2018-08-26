package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Excursion;

public interface IExcursionService {
	
	/**
	 * Méthode d'ajout d'une excursion
	 * @param excu, un objet excursion
	 * @return un objet excursion
	 */
	public Excursion addExcursion(Excursion excu);
	
	/**
	 * Méthode d'affichage de la liste des excursions
	 * @return liste d'objet excursion
	 */
	public List<Excursion> getAllExcursions();
	
	/**
	 * Méthode de suppression d'une excursion
	 * @param excu, un objet excursion
	 * @return int
	 */
	public int deleteExcursion(Excursion excu);
	
	/**
	 * Méthode de modification d'une excursion
	 * @param excu, l'objet excursion à modifier
	 * @return int
	 */
	public int updateExcursion(Excursion excu);
	
	/**
	 * Méthode de recherche d'une excursion par nom
	 * @param excu, un objet excursion
	 * @return liste d'objet excursion
	 */
	public List<Excursion> getExcuByName(Excursion excu);
	
	/**
	 * Méthode de recherche d'une excursion par id
	 * @param id
	 * @return un objet excursion
	 */
	public Excursion getExcuById(int id);
	
	/**
	 * Méthode de recherche d'une excursion
	 * @param un objet excursion
	 * @return un objet excursion
	 */
	public Excursion getExcu(Excursion excu);


}

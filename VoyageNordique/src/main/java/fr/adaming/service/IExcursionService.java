package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Excursion;

public interface IExcursionService {
	
	/**
	 * M�thode d'ajout d'une excursion
	 * @param excu, un objet excursion
	 * @return un objet excursion
	 */
	public Excursion addExcursion(Excursion excu);
	
	/**
	 * M�thode d'affichage de la liste des excursions
	 * @return liste d'objet excursion
	 */
	public List<Excursion> getAllExcursions();
	
	/**
	 * M�thode de suppression d'une excursion
	 * @param excu, un objet excursion
	 * @return int
	 */
	public int deleteExcursion(Excursion excu);
	
	/**
	 * M�thode de modification d'une excursion
	 * @param excu, l'objet excursion � modifier
	 * @return int
	 */
	public int updateExcursion(Excursion excu);
	
	/**
	 * M�thode de recherche d'une excursion par nom
	 * @param excu, un objet excursion
	 * @return liste d'objet excursion
	 */
	public List<Excursion> getExcuByName(Excursion excu);
	
	/**
	 * M�thode de recherche d'une excursion par id
	 * @param id
	 * @return un objet excursion
	 */
	public Excursion getExcuById(int id);
	
	/**
	 * M�thode de recherche d'une excursion
	 * @param un objet excursion
	 * @return un objet excursion
	 */
	public Excursion getExcu(Excursion excu);


}

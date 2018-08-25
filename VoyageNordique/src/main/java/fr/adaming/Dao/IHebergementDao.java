package fr.adaming.Dao;

import java.util.List;

import fr.adaming.model.Hebergement;

public interface IHebergementDao {
	/**
	 * M�thode d'ajout d'une excursion
	 * 
	 * @param excu,
	 *            un objet excursion
	 * @return un objet excursion
	 */
	public Hebergement addHebergement(Hebergement heb);

	/**
	 * M�thode d'affichage de la liste des excursions
	 * 
	 * @return liste d'objet excursion
	 */
	public List<Hebergement> getAllHebergements();

	/**
	 * M�thode de suppression d'une excursion
	 * 
	 * @param excu,
	 *            un objet excursion
	 * @return int
	 */
	public int deleteHebergement(Hebergement heb);

	/**
	 * M�thode de modification d'une excursion
	 * 
	 * @param excu,
	 *            l'objet excursion � modifier
	 * @return int
	 */
	public int updateHebergement(Hebergement heb);

	/**
	 * M�thode de recherche d'une excursion par nom
	 * 
	 * @param excu,
	 *            un objet excursion
	 * @return objet excursion trouv�
	 */
	public Hebergement getHebByName(Hebergement heb);

	/**
	 * M�thode de recherche d'une excursion par id
	 * 
	 * @param id
	 * @return un objet excursion
	 */
	public Hebergement getHebById(int id);
}

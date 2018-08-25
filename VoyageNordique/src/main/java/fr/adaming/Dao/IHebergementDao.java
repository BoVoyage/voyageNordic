package fr.adaming.Dao;

import java.util.List;

import fr.adaming.model.Hebergement;

public interface IHebergementDao {
	/**
	 * Méthode d'ajout d'une excursion
	 * 
	 * @param excu,
	 *            un objet excursion
	 * @return un objet excursion
	 */
	public Hebergement addHebergement(Hebergement heb);

	/**
	 * Méthode d'affichage de la liste des excursions
	 * 
	 * @return liste d'objet excursion
	 */
	public List<Hebergement> getAllHebergements();

	/**
	 * Méthode de suppression d'une excursion
	 * 
	 * @param excu,
	 *            un objet excursion
	 * @return int
	 */
	public int deleteHebergement(Hebergement heb);

	/**
	 * Méthode de modification d'une excursion
	 * 
	 * @param excu,
	 *            l'objet excursion à modifier
	 * @return int
	 */
	public int updateHebergement(Hebergement heb);

	/**
	 * Méthode de recherche d'une excursion par nom
	 * 
	 * @param excu,
	 *            un objet excursion
	 * @return objet excursion trouvé
	 */
	public Hebergement getHebByName(Hebergement heb);

	/**
	 * Méthode de recherche d'une excursion par id
	 * 
	 * @param id
	 * @return un objet excursion
	 */
	public Hebergement getHebById(int id);
}

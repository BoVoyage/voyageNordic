package fr.adaming.Dao;

import java.util.List;

import fr.adaming.model.Vehicule;

public interface IVehiculeDao {
	
	/**
	 * Méthode d'ajout d'un vehicule
	 * @param v, un objet vehicule
	 * @return objet vehicule
	 */
	public Vehicule addVehicule(Vehicule v);
	
	/**
	 * Méthode pour recuperer la liste des vehicules
	 * @return liste de vehicules
	 */
	public List<Vehicule> getAllVehicule();
	
	/**
	 * Méthode pour supprimer un vehicule
	 * @param v, un objet vehicule
	 * @return int
	 */
	public int deleteVehicule(Vehicule v);
	
	/**
	 * Méthode de modification d'un vehicule
	 * @param v un objet vehicule
	 * @return int
	 */
	public int updateVehicule(Vehicule v);
	
	/**
	 * Méthode de recherche d'un vehicule par categorie
	 * @param v, un objet vehicule
	 * @return liste de vehicules
	 */
	public List<Vehicule> getVehiculeByCate(Vehicule v);
	
	/**
	 * Méthode de recherche d'un vehicule par son ID
	 * @param v, un objet vehicule
	 * @return un objet vehicule
	 */
	public Vehicule getVehiculeById(Vehicule v);

}

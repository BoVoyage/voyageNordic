package fr.adaming.Dao;

import java.util.List;

import fr.adaming.model.Vehicule;

public interface IVehiculeDao {
	
	/**
	 * M�thode d'ajout d'un vehicule
	 * @param v, un objet vehicule
	 * @return objet vehicule
	 */
	public Vehicule addVehicule(Vehicule v);
	
	/**
	 * M�thode pour recuperer la liste des vehicules
	 * @return liste de vehicules
	 */
	public List<Vehicule> getAllVehicule();
	
	/**
	 * M�thode pour supprimer un vehicule
	 * @param v, un objet vehicule
	 * @return int
	 */
	public int deleteVehicule(Vehicule v);
	
	/**
	 * M�thode de modification d'un vehicule
	 * @param v un objet vehicule
	 * @return int
	 */
	public int updateVehicule(Vehicule v);
	
	/**
	 * M�thode de recherche d'un vehicule par categorie
	 * @param v, un objet vehicule
	 * @return liste de vehicules
	 */
	public List<Vehicule> getVehiculeByCate(Vehicule v);
	
	/**
	 * M�thode de recherche d'un vehicule par son ID
	 * @param v, un objet vehicule
	 * @return un objet vehicule
	 */
	public Vehicule getVehiculeById(Vehicule v);

}

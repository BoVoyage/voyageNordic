package fr.adaming.Dao;

import java.util.List;

import fr.adaming.model.Client;

public interface IClientDao {
	
	/**Methode pour enregistrer le client*/
	public Client addClient(Client cl);
	
	/**Methode pour liste des clients*/
	public List<Client> getAllClientDao();
	/** 
	 * Methode pour modifier le client
	 */	
	public int updateClient(Client cl);
	/**
	* Methode pour supprimer le client 
	 */
	public int deleteClient(Client cl);
	
	/**
	* Methode rechercher le client par nom ou par id
	 */
	public List<Client> getClientByNomOrNoClient(Client cl);
}

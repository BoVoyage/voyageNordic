package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Client;

public interface IClientService {
	
	/**Methode pour enregistrer le client*/
	public Client addClientService(Client cl);
	
	/**Methode pour liste des clients*/
	public List<Client> getAllClientService();
	
	/** 
	 * Methode pour modifier le client
	 */	
	public int updateClient(Client cl);
	/**
	* Methode pour supprimer le client 
	 */
	public Client deleteEtudiant(Client cl);
	
	/**
	* Methode rechercher le client par nom ou par id
	 */
	public List<Client> getClientByNomOrNoClient(Client cl);

}

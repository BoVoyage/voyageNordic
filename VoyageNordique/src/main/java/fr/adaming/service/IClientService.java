package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Client;

public interface IClientService {
	
	/**Methode pour enregistrer le client*/
	public Client addClientService(Client cl);
	
	/**Methode pour liste des clients*/
	public List<Client> getAllClientService();

}

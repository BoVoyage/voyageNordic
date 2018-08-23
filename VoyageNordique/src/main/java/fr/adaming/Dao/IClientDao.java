package fr.adaming.Dao;

import java.util.List;

import fr.adaming.model.Client;

public interface IClientDao {
	
	/**Methode pour enregistrer le client*/
	public Client addClient(Client cl);
	
	/**Methode pour liste des clients*/
	public List<Client> getAllClientDao();
}

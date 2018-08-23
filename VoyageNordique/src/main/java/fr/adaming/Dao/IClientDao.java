package fr.adaming.Dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;

public interface IClientDao {
	
	/**Methode pour enregistrer le client*/
	public Client addClient(Client cl);
	
}

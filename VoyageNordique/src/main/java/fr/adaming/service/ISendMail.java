package fr.adaming.service;

import fr.adaming.model.Client;

public interface ISendMail {
	
	/**
	* Methode envoyer un mail au client
	 */
	void sendMail(Client cl);

}

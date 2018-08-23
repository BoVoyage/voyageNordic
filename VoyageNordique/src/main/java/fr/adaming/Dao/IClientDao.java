package fr.adaming.Dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;

@Repository
/** sert a declarer le dao comme un bean de spring IoC. On pouvait aussi utiliser: @component. On l'utilise juste pour le Dao*/
public interface IClientDao {
	
	/**declaration de l'attribut sessionFactory*/
	private SessionFactory demba;


	/**setter pour l'injection de dependance de sf*/

	/**Methode pour enregistrer le client*/
	public Client addClient(Client cl);
	
}

package fr.adaming.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;

@Repository
/** sert a declarer le dao comme un bean de spring IoC. On pouvait aussi utiliser: @component. On l'utilise juste pour le Dao*/
public class ClientDaoImpl implements IClientDao{
	
	//*****************************************************************************
	/**declaration de l'attribut sessionFactory*/
	/**sf est un collaborateur de FormateurDaoImpl donc on utilise l'annotation @Autowired*/
	@Autowired
	private SessionFactory sf;
	/**setter pour l'injection de dependance de sf*/
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	//*********************************************************************************
	@Override
	public Client addClient(Client cl) {
		/** recuperer une session */
		Session s=sf.getCurrentSession();
		s.save(cl);
		return cl;
	}
	//************************************************************************************


}

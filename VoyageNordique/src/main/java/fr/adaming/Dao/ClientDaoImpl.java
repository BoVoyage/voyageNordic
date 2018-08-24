package fr.adaming.Dao;

import java.util.List;

import org.hibernate.Query;
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
	@Override
	public List<Client> getAllClientDao() {
		/**recup de la session*/
		Session s=sf.getCurrentSession();
		/** La requete HQL*/
		String reqHQL="From Client";
		/**Creation du query*/
		Query query=s.createQuery(reqHQL);
		/**recuperation de la liste*/
		return query.list();
	}
	//************************************************************************************
//	public int modifClient(Client cl){
//		
//		//Recuperer la session
//		Session s=sf.getCurrentSession();
//		
//		//La requete HQL
//		String reqHQL="UPDATE Client cl SET cl.nom=:pNom, cl.prenom=:pPrenom, cl.dn=:pDn, cl.mail=:pMail, cl.mdp=:pMdp, cl.tel=:pTel where cl.idClient=?";
//		
//		return 0;
//	}
	@Override
	public int updateClient(Client cl) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Client deleteEtudiant(Client cl) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Client getEtudiantById(Client cl) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Client> getClientByNomOrId(Client cl) {
		// TODO Auto-generated method stub
		return null;
	}


}

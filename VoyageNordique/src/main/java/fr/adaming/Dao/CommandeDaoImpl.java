package fr.adaming.Dao;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;

/**
 * @author Ewen Classe implémentant l'interface ICommandeDao
 *         L'annotation @Repository permet au conteneur SpringIoC d'indentifier
 *         cette classe en tant que Bean.
 */
@Repository
public class CommandeDaoImpl implements ICommandeDao {

	/**
	 * Déclaration de l'attribut sessionFactory L'annotation @Autowired permet
	 * d'automatiser l'injection de dépendances.
	 */
	@Autowired
	private SessionFactory sf;

	/**
	 * Setter pour utiliser pour l'injection de dépendance
	 * 
	 * @param sf
	 *            correspond à la SessionFactory d'hibernate
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Commande saveCommande(Commande co) {
		// Récupération de la session
		Session s = sf.getCurrentSession();

		// Enregistrement de la commande dans DB
		s.save(co);

		return co;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commande> getCommandeByClient(Client cl) {
		// Récupération d'une session Hibernate
		Session s = sf.getCurrentSession();

		// Création d'une requête HQL
		String req = "FROM Commande co WHERE co.client.idClient=:pId";

		// Récupération d'une query hibernate
		Query query = s.createQuery(req);

		// paramétrages de la requête
		query.setParameter("pId", cl.getIdClient());

		// Récupération de la requête
		return query.list();
	}

	@Override
	public int deleteCommande(Commande co) {
		// récupérer la session
		Session s = sf.getCurrentSession();

		// Requête HQL
		String req = "DELETE Commande co WHERE co.noCommande=:pNo";

		// récup du query
		Query query = s.createQuery(req);

		// Paramétrage
		query.setParameter("pNo", co.getNoCommande());

		int verif = query.executeUpdate();

		return verif;
	}

	@Override
	public Commande getCommandeByNumber(Commande co) {
		// récupérer la session
		Session s = sf.getCurrentSession();

		// Création d'une requête HQL
		String req = "FROM Commande co WHERE co.noCommande=:pNo";

		// récup du query
		Query query = s.createQuery(req);

		// Paramétrage
		query.setParameter("pNo", co.getNoCommande());
		
		return (Commande) query.uniqueResult();
	}

}

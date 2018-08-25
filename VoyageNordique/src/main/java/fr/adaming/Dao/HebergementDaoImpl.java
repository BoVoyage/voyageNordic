package fr.adaming.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Hebergement;

@Repository
public class HebergementDaoImpl implements IHebergementDao {

	// declaration de l'attribut SessionFactory
	@Autowired
	private SessionFactory sf;

	// declaration du setter de sf pour l'injection dependance
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Hebergement addHebergement(Hebergement heb) {
		// recuperation de la session
		Session s = sf.getCurrentSession();

		s.save(heb);

		return heb;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Hebergement> getAllHebergements() {
		// recuperation de la session
		Session s = sf.getCurrentSession();

		// creation de la requete
		String req = "FROM Hebergement heb";

		// creation de query
		Query query = s.createQuery(req);

		return query.list();
	}

	@Override
	public int deleteHebergement(Hebergement heb) {
		// recuperation de la session
		Session s = sf.getCurrentSession();

		// retrouver l'objet excursion par son nom
		heb = this.getHebByName(heb);

		try {
			s.delete(heb);
			return 1;

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return 0;
	}

	@Override
	public int updateHebergement(Hebergement heb) {
		// recuperation de la session
		Session s = sf.getCurrentSession();

		// creation de la requete
		String req = "UPDATE Hebergement heb SET heb.nomHebergement=:pNom, heb.descriptionHebergement=:pDesc, heb.imageHebergement=:pImg WHERE heb.idHebergement=:pId";

		// creation de query et passage des paramètres
		Query query = s.createQuery(req);
		query.setParameter("pNom", heb.getNomHebergement());
		query.setParameter("pDesc", heb.getDescriptionHebergement());
		query.setParameter("pImg", heb.getImageHebergement());
		query.setParameter("pId", heb.getIdHebergement());

		return query.executeUpdate();
	}

	@Override
	public Hebergement getHebByName(Hebergement heb) {
		// recuperation de la session
		Session s = sf.getCurrentSession();

		// creation de la requete
		String req = "FROM Hebergement heb WHERE heb.nomHebergement=:pNom";

		// creation de query et passage des paramètres
		Query query = s.createQuery(req);
		query.setParameter("pNom", heb.getNomHebergement());

		return (Hebergement) query.uniqueResult();
	}

	@Override
	public Hebergement getHebById(int id) {
		// recuperation de la session
		Session s = sf.getCurrentSession();

		return (Hebergement) s.get(Hebergement.class, id);
	}

}

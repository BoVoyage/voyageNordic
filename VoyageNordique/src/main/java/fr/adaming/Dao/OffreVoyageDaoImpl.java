package fr.adaming.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.OffreVoyage;

@Repository
public class OffreVoyageDaoImpl implements IOffreVoyageDao {

	// declaration de l'attribut SessionFactory
	@Autowired
	private SessionFactory sf;

	// declaration du setter de sf pour l'injection dependance
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public OffreVoyage addOffreVoyage(OffreVoyage ov) {
		// recuperer la session à partir de sf
		Session s = sf.getCurrentSession();

		s.save(ov);

		return ov;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OffreVoyage> getAllOffres() {
		// recuperer la session à partir de sf
		Session s = sf.getCurrentSession();

		// creation de la requete
		String req = "FROM OffreVoyage ov";

		// recuperation de la requete
		Query query = s.createQuery(req);

		return query.list();
	}

	@Override
	public OffreVoyage getOffreVoyageById(int id) {
		// recuperer la session à partir de sf
		Session s = sf.getCurrentSession();
		return (OffreVoyage) s.get(OffreVoyage.class, id);
	}

}

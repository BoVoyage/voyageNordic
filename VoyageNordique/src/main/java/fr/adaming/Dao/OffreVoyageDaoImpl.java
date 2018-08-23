package fr.adaming.Dao;

import java.util.List;

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

	@Override
	public List<OffreVoyage> getAllOffres() {
		// recuperer la session à partir de sf
		Session s = sf.getCurrentSession();
		
		
		
		return null;
	}

}

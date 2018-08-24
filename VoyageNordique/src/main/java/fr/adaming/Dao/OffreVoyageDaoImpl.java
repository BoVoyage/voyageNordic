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

	@Override
	public OffreVoyage getOffreVoyageByName(OffreVoyage ov) {
		// recuperer la session à partir de sf
		Session s = sf.getCurrentSession();

		// creation de la requete
		String req = "FROM OffreVoyage ov WHERE ov.designation=:pName";

		// recuperation de la requete
		Query query = s.createQuery(req);
		query.setParameter("pName", ov.getDesignation());

		return (OffreVoyage) query.uniqueResult();
	}

	@Override
	public OffreVoyage getOffreVoyageByNoVoyage(OffreVoyage ov) {
		// recuperer la session à partir de sf
		Session s = sf.getCurrentSession();

		// creation de la requete
		String req = "FROM OffreVoyage ov WHERE ov.noVoyage=:pNo";

		// recuperation de la requete
		Query query = s.createQuery(req);
		query.setParameter("pNo", ov.getNoVoyage());

		return (OffreVoyage) query.uniqueResult();
	}

	@Override
	public OffreVoyage getOffreVoyageByState(OffreVoyage ov) {
		// recuperer la session à partir de sf
		Session s = sf.getCurrentSession();

		// creation de la requete
		String req = "FROM OffreVoyage ov WHERE ov.pays=:pPays";

		// recuperation de la requete
		Query query = s.createQuery(req);
		query.setParameter("pPays", ov.getPays());

		return (OffreVoyage) query.uniqueResult();
	}

	@Override
	public OffreVoyage getOffreVoyageByPrice(OffreVoyage ov) {
		// recuperer la session à partir de sf
		Session s = sf.getCurrentSession();

		// creation de la requete
		String req = "FROM OffreVoyage ov WHERE ov.prixVoyage=:pPrix";

		// recuperation de la requete
		Query query = s.createQuery(req);
		query.setParameter("pPrix", ov.getPrixVoyage());

		return (OffreVoyage) query.uniqueResult();
	}

	@Override
	public int deleteOffreVoyage(OffreVoyage ov) {
		// recuperer la session à partir de sf
		Session s = sf.getCurrentSession();
		ov = this.getOffreVoyageByNoVoyage(ov);
		try {
			s.delete(ov);
			return 1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateOffreVoyage(OffreVoyage ov) {
		// recuperer la session à partir de sf
		Session s = sf.getCurrentSession();

		// creation de la requete
		String req = "UPDATE OffreVoyage ov SET ov.pays=:pPays, ov.ville=:pVille, ov.quantite=:pQuantite, ov.etat=:pEtat, ov.imageDestination=:pImg, ov.promotion=:pPromo, ov.descriptionVoyage=:pDesc, ov.prixVoyage=:pPrix, ov.remiseVoyage=:pRemise, ov.designation=:pNom WHERE ov.noVoyage=:pNo";

		// creation de la query et passage des param
		Query query = s.createQuery(req);
		query.setParameter("pPays", ov.getPays());
		query.setParameter("pVille", ov.getVille());
		query.setParameter("pQuantite", ov.getQuantite());
		query.setParameter("pEtat", ov.isEtat());
		query.setParameter("pImg", ov.getImageDestination());
		query.setParameter("pPromo", ov.isPromotion());
		query.setParameter("pDesc", ov.getDescriptionVoyage());
		query.setParameter("pPrix", ov.getPrixVoyage());
		query.setParameter("pRemise", ov.getRemiseVoyage());
		query.setParameter("pNom", ov.getDesignation());
		query.setParameter("pNo", ov.getNoVoyage());

		return query.executeUpdate();
	}

	@Override
	public int closeOffreVoyage(OffreVoyage ov) {
		// recuperer la session à partir de sf
		Session s = sf.getCurrentSession();

		// creation de la requete
		String req = "UPDATE OffreVoyage ov SET ov.etat=:pEtat WHERE ov.noVoyage=:pNo";

		// creation de la query et passage des param
		Query query = s.createQuery(req);
		query.setParameter("pEtat", ov.isEtat());
		query.setParameter("pNo", ov.getNoVoyage());

		return query.executeUpdate();
	}

	@Override
	public int promoOffreVoyage(OffreVoyage ov) {
		// recuperer la session à partir de sf
		Session s = sf.getCurrentSession();

		// creation de la requete
		String req = "UPDATE OffreVoyage ov SET ov.promotion=:pPromo, ov.prixVoyage=:pPrix WHERE ov.noVoyage=:pNo";

		// creation de la query et passage des param
		Query query = s.createQuery(req);
		query.setParameter("pPromo", ov.isPromotion());
		query.setParameter("pPrix", ov.getPrixVoyage());
		query.setParameter("pNo", ov.getNoVoyage());

		return query.executeUpdate();
	}

}

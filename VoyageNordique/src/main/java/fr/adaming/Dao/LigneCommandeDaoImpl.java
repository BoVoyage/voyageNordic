package fr.adaming.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.LigneCommande;

/**
 * Implementation de l'interface LigneCommandeDao pour redéfinir les méthodes de
 * LigneCommande
 * 
 * @author Thibault
 */
@Repository
public class LigneCommandeDaoImpl implements ILigneCommandeDao {

	// declaration des attributs
	@Autowired
	private SessionFactory sf;

	// getters et setters
	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LigneCommande> getAllLignesCommandes() {

		// recuperer la session
		Session s = sf.getCurrentSession();

		Criteria ct = s.createCriteria(LigneCommande.class);

		return ct.list();
	}

	@Override
	public LigneCommande addLigneCommande(LigneCommande lc) {

		// recuperer la session
		Session s = sf.getCurrentSession();

		s.persist(lc);

		return lc;
	}

	@Override
	public int updateLigneCommande(LigneCommande lc) {

		// recuperer la session
		Session s = sf.getCurrentSession();

		String req = "UPDATE LigneCommande lc SET lc.quantite =:pQte, lc.prix=:pPrix WHERE lc.idLigneCommande =:pIdLC";

		Query query = s.createQuery(req);

		query.setParameter("pQte", lc.getQuantite());
		query.setParameter("pPrix", lc.getPrix());
		query.setParameter("pIdLC", lc.getIdLigneCommande());

		return query.executeUpdate();
	}

	@Override
	public int deleteLigneCommande(LigneCommande lc) {

		// recuperer la session
		Session s = sf.getCurrentSession();

		String req = "DELETE FROM LigneCommande lc WHERE lc.idLigneCommande=:pIdLC";

		// recuperer la query
		Query query = s.createQuery(req);

		// assignation des params
		query.setParameter("pIdLC", lc.getIdLigneCommande());

		return query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LigneCommande> getLigneCommandebyIdORbyNoCmd(LigneCommande lc) {

		// recuperer la session
		Session s = sf.getCurrentSession();

		String req = "FROM LigneCommande lc WHERE lc.idLigneCommande=:pIdLC OR lc.commande.noCommande=:pNoCmd";

		Query query = s.createQuery(req);

		query.setParameter("pIdLC", lc.getIdLigneCommande());
		query.setParameter("pNoCmd", lc.getCommande().getNoCommande());

		return query.list();
	}

}

package fr.adaming.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Vehicule;

@Repository
public class VehiculeDaoImpl implements IVehiculeDao {

	// instanciation d'une sessionFactory
	@Autowired
	private SessionFactory sf;

	// declaration du setter pour l'injection dependance
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Vehicule addVehicule(Vehicule v) {
		// recuperer la sessionFactory
		Session s = sf.getCurrentSession();

		s.save(v);

		return v;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehicule> getAllVehicule() {
		// recuperer la sessionFactory
		Session s = sf.getCurrentSession();

		// creation de la requete
		String req = "FROM Vehicule v";

		// creation de la query
		Query query = s.createQuery(req);

		return query.list();
	}

	@Override
	public int deleteVehicule(Vehicule v) {
		// recuperer la sessionFactory
		Session s = sf.getCurrentSession();

		v = this.getVehiculeByCate(v);
		try {
			s.delete(v);
			return 1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return 0;
	}

	@Override
	public int updateVehicule(Vehicule v) {
		// recuperer la sessionFactory
		Session s = sf.getCurrentSession();

		// creation de la requete
		String req = "UPDATE Vehicule v SET v.categorieVehicule=:pCat, v.marqueVehicule=:pMarque, v.prixVehicule=:pPrix WHERE v.idVehicule=:pId";

		// creation du query et passage des param
		Query query = s.createQuery(req);
		query.setParameter("pCat", v.getCategorieVehicule());
		query.setParameter("pMarque", v.getMarqueVehicule());
		query.setParameter("pPrix", v.getPrixVehicule());
		query.setParameter("pId", v.getIdVehicule());
		
		return query.executeUpdate();
	}

	@Override
	public Vehicule getVehiculeByCate(Vehicule v) {
		// recuperer la sessionFactory
		Session s = sf.getCurrentSession();

		// creation de la requete
		String req = "FROM Vehicule v WHERE v.categorieVehicule=:pCat";

		// creation du query et passage des param
		Query query = s.createQuery(req);
		query.setParameter("pCat", v.getCategorieVehicule());

		return (Vehicule) query.uniqueResult();
	}

}

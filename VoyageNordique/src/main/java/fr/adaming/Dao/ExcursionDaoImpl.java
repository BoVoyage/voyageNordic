package fr.adaming.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Excursion;

@Repository
public class ExcursionDaoImpl implements IExcursionDao {

	// declaration de l'attribut SessionFactory
	@Autowired
	private SessionFactory sf;

	// declaration du setter de sf pour l'injection dependance
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Excursion addExcursion(Excursion excu) {
		// recuperation de la session
		Session s = sf.getCurrentSession();

		s.save(excu);

		return excu;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Excursion> getAllExcursions() {
		// recuperation de la session
		Session s = sf.getCurrentSession();

		// creation de la requete
		String req = "FROM Excursion ex";

		// creation de query
		Query query = s.createQuery(req);

		return query.list();
	}

	@Override
	public int deleteExcursion(Excursion excu) {
		// recuperation de la session
		Session s = sf.getCurrentSession();
		
		//retrouver l'objet excursion par son nom
		excu=this.getExcu(excu);
		
		try{
			s.delete(excu);
			return 1;
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int updateExcursion(Excursion excu) {
		// recuperation de la session
		Session s = sf.getCurrentSession();

		// creation de la requete
		String req = "UPDATE Excursion ex SET ex.nomExcursion=:pNom, ex.descriptionExcursion=:pDesc, ex.imageExcursion=:pImg, ex.prixExcursion=:pPrix WHERE ex.idExcursion=:pId";

		// creation de query et passage des paramètres
		Query query = s.createQuery(req);
		query.setParameter("pNom", excu.getNomExcursion());
		query.setParameter("pDesc", excu.getDescriptionExcursion());
		query.setParameter("pImg", excu.getImageExcursion());
		query.setParameter("pPrix", excu.getPrixExcursion());
		query.setParameter("pId", excu.getIdExcursion());

		return query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Excursion> getExcuByName(Excursion excu) {
		// recuperation de la session
		Session s = sf.getCurrentSession();

		// creation de la requete
		String req = "FROM Excursion ex WHERE ex.nomExcursion=:pNom";

		// creation de query et passage des paramètres
		Query query = s.createQuery(req);
		query.setParameter("pNom", excu.getNomExcursion());

		return query.list();
	}

	@Override
	public Excursion getExcuById(int id) {
		// recuperation de la session
		Session s = sf.getCurrentSession();

		return (Excursion) s.get(Excursion.class, id);
	}

	@Override
	public Excursion getExcu(Excursion excu) {
		// recuperation de la session
		Session s = sf.getCurrentSession();

		// creation de la requete
		String req = "FROM Excursion ex WHERE ex.idExcursion=:pId";

		// creation de query et passage des paramètres
		Query query = s.createQuery(req);
		query.setParameter("pId", excu.getIdExcursion());

		return (Excursion) query.uniqueResult();
	}

}

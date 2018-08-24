package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.Dao.IOffreVoyageDao;
import fr.adaming.model.OffreVoyage;

@Service("ovService")
@Transactional
public class OffreVoyageServiceImpl implements IOffreVoyageService{
	
	//transformation de l'asso UML en JAVA
	@Autowired
	private IOffreVoyageDao offreVoyageDao;

	@Override
	public OffreVoyage addOffreVoyage(OffreVoyage ov) {
		return offreVoyageDao.addOffreVoyage(ov);
	}

	@Override
	public List<OffreVoyage> getAllOffres() {
		return offreVoyageDao.getAllOffres();
	}

	@Override
	public OffreVoyage getOffreVoyageById(int id) {
		return  offreVoyageDao.getOffreVoyageById(id);
	}

	@Override
	public OffreVoyage getOffreVoyageByName(OffreVoyage ov) {
		return offreVoyageDao.getOffreVoyageByName(ov);
	}

	@Override
	public OffreVoyage getOffreVoyageByNoVoyage(OffreVoyage ov) {
		return offreVoyageDao.getOffreVoyageByNoVoyage(ov);
	}

	@Override
	public OffreVoyage getOffreVoyageByState(OffreVoyage ov) {
		return offreVoyageDao.getOffreVoyageByState(ov);
	}

	@Override
	public OffreVoyage getOffreVoyageByPrice(OffreVoyage ov) {
		return offreVoyageDao.getOffreVoyageByPrice(ov);
	}

	@Override
	public int deleteOffreVoyage(OffreVoyage ov) {
		return offreVoyageDao.deleteOffreVoyage(ov);
	}

	@Override
	public int updateOffreVoyage(OffreVoyage ov) {
		return offreVoyageDao.updateOffreVoyage(ov);
	}

	@Override
	public int closeOffreVoyageService(OffreVoyage ov) {
		return closeOffreVoyageService(ov);
	}

	@Override
	public int promoOffreVoyageService(OffreVoyage ov) {
		return closeOffreVoyageService(ov);
	}
	
	

}

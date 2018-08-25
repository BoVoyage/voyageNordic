package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.Dao.IHebergementDao;
import fr.adaming.model.Hebergement;

@Service("hebService")
@Transactional
public class HebergementServiceImpl implements IHebergementService {

	// transformation de l'association UML en JAVA
	@Autowired
	private IHebergementDao hebDao;

	@Override
	public Hebergement addHebergement(Hebergement heb) {
		return hebDao.addHebergement(heb);
	}

	@Override
	public List<Hebergement> getAllHebergements() {
		return hebDao.getAllHebergements();
	}

	@Override
	public int deleteHebergement(Hebergement heb) {
		return hebDao.deleteHebergement(heb);
	}

	@Override
	public int updateHebergement(Hebergement heb) {
		return hebDao.updateHebergement(heb);
	}

	@Override
	public Hebergement getHebByName(Hebergement heb) {
		return hebDao.getHebByName(heb);
	}

	@Override
	public Hebergement getHebById(int id) {
		return hebDao.getHebById(id);
	}

}

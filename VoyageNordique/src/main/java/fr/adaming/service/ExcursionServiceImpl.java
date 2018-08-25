package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.Dao.IExcursionDao;
import fr.adaming.model.Excursion;

@Service("excuService")
@Transactional
public class ExcursionServiceImpl implements IExcursionService{
	
	//transformation de l'association UML en JAVA
	@Autowired
	private IExcursionDao excursionDao;

	@Override
	public Excursion addExcursion(Excursion excu) {
		return excursionDao.addExcursion(excu);
	}

	@Override
	public List<Excursion> getAllExcursions() {
		return excursionDao.getAllExcursions();
	}

	@Override
	public int deleteExcursion(Excursion excu) {
		return excursionDao.deleteExcursion(excu);
	}

	@Override
	public int updateExcursion(Excursion excu) {
		return excursionDao.updateExcursion(excu);
	}

	@Override
	public Excursion getExcuByName(Excursion excu) {
		return excursionDao.getExcuByName(excu);
	}

	@Override
	public Excursion getExcuById(int id) {
		return excursionDao.getExcuById(id);
	}

}

package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.Dao.IVehiculeDao;
import fr.adaming.model.Vehicule;

@Service("vehiService")
@Transactional
public class VehiculeServiceImpl implements IVehiculeService{

	//transformation de l'association UML en JAVA
	@Autowired
	private IVehiculeDao vehiculeDao;
	
	@Override
	public Vehicule addVehicule(Vehicule v) {
		return vehiculeDao.addVehicule(v);
	}

	@Override
	public List<Vehicule> getAllVehicule() {
		return vehiculeDao.getAllVehicule();
	}

	@Override
	public int deleteVehicule(Vehicule v) {
		return vehiculeDao.deleteVehicule(v);
	}

	@Override
	public int updateVehicule(Vehicule v) {
		return vehiculeDao.updateVehicule(v);
	}

	@Override
	public Vehicule getVehiculeByCate(Vehicule v) {
		return vehiculeDao.getVehiculeByCate(v);
	}
	
	

}

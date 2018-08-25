package fr.adaming.daoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.Dao.IExcursionDao;
import fr.adaming.model.Excursion;
import fr.adaming.model.OffreVoyage;

@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class ExcursionDaoImplTest {

	// instanciation de Dao
	@Autowired
	private IExcursionDao excursionDao;

	// cas de test de l'ajout d'une excursion
	@Ignore
	// @Test
	// @Transactional
	public void testAddExcu() {
		Excursion excuAjout = new Excursion("Balade en chien de traineaux",
				"Une superbe balade d'une heure en chien de traineaux dans les magnifiques paysages enneigés", null,
				125.99);
		excursionDao.addExcursion(excuAjout);
		assertEquals(2, excursionDao.getAllExcursions().size());
	}

	// cas de test de la liste des excursions
	@Ignore
	// @Test
	// @Transactional(readOnly=true)
	public void testGetAllSize() {
		assertEquals(1, excursionDao.getAllExcursions().size());
	}

	@Ignore
	// @Test
	// @Transactional(readOnly=true)
	public void testGetAllFirst() {
		assertEquals("Balade en chien de traineaux", excursionDao.getAllExcursions().get(0).getNomExcursion());
	}

	// cas de test de la suppression d'une excursion
//	@Ignore
	 @Test
	 @Transactional
	public void testDeleteExcu() {
		Excursion excuSuppr = new Excursion();
		excuSuppr.setIdExcursion(1);
		excursionDao.deleteExcursion(excuSuppr);
		assertEquals(0, excursionDao.getAllExcursions().size());
	}

	// cas de test de la modification d'une excursion
//	@Ignore
	 @Test
	 @Transactional
	public void testUpdateExcu() {
		Excursion excuModif= new Excursion(1, "jhj", "jjjj", null, 0);
		excursionDao.updateExcursion(excuModif);
		assertEquals("jhj", excursionDao.getAllExcursions().get(0).getNomExcursion());
	}

	// cas de test de la recherche par id d'une excursion
	// @Test
//	@Ignore
	// @Transactional(readOnly=true)
//	public void testGetById() {
//		assertEquals(13, offreVoyageDao.getAllOffres().get(1).getIdVoyage());
//	}

	// cas de test de la recherche par nom d'une excursion
	// @Test
//	@Ignore
//	// @Transactional(readOnly=true)
//	public void testGetByName() {
//		assertEquals("sdfsdfsd", offreVoyageDao.getAllOffres().get(1).getDesignation());
//	}

}

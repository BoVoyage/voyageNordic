package fr.adaming.serviceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Excursion;
import fr.adaming.service.IExcursionService;

@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class ExcursionServiceImplTest {
	
	//instanciation de service
	@Autowired
	private IExcursionService excursionService;
	
	// cas de test de l'ajout d'une excursion
	@Ignore
//	 @Test
//	 @Transactional
	public void testAddExcu() {
		Excursion excuAjout = new Excursion("Balade en chien de traineaux",
				"Une superbe balade d'une heure en chien de traineaux dans les magnifiques paysages enneigés", null,
				125.99);
		excursionService.addExcursion(excuAjout);
		assertEquals(2, excursionService.getAllExcursions().size());
	}

	// cas de test de la liste des excursions
	@Ignore
//	 @Test
//	 @Transactional(readOnly=true)
	public void testGetAllSize() {
		assertEquals(1, excursionService.getAllExcursions().size());
	}

	@Ignore
//	 @Test
//	 @Transactional(readOnly=true)
	public void testGetAllFirst() {
		assertEquals("Balade en chien de traineaux", excursionService.getAllExcursions().get(0).getNomExcursion());
	}

	// cas de test de la suppression d'une excursion
	 @Ignore
//	@Test
//	@Transactional
	public void testDeleteExcu() {
		Excursion excuSuppr = new Excursion();
		excuSuppr.setNomExcursion("Balade en chien de traineaux");
		excursionService.deleteExcursion(excuSuppr);
		assertEquals(0, excursionService.getAllExcursions().size());
	}

	// cas de test de la modification d'une excursion
	 @Ignore
//	@Test
//	@Transactional
	public void testUpdateExcu() {
		Excursion excuModif = new Excursion(1, "jhj", "jjjj", null, 0);
		excursionService.updateExcursion(excuModif);
		assertEquals("jhj", excursionService.getAllExcursions().get(0).getNomExcursion());
	}

	// cas de test de la recherche par id d'une excursion
	 @Ignore
//	@Test
//	@Transactional(readOnly = true)
	public void testGetById() {
		assertEquals("Balade en chien de traineaux", excursionService.getExcuById(1).getNomExcursion());
	}

	// cas de test de la recherche par nom d'une excursion
	 @Ignore
//	@Test
//	@Transactional(readOnly = true)
	public void testGetByName() {
		Excursion ex = excursionService.getExcuById(1);
		assertEquals("Une superbe balade d'une heure en chien de traineaux dans les magnifiques paysages enneigés", excursionService.getExcuByName(ex).getDescriptionExcursion());
	}

}

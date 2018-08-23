package fr.adaming.daoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.Dao.IOffreVoyageDao;
import fr.adaming.model.OffreVoyage;

@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class OffreVoyageDaoTest {

	//instanciation de Dao
	@Autowired
	IOffreVoyageDao offreVoyageDao;
	
	//cas de test de la liste des offres de voyage
	@Test
	@Transactional(readOnly=true)
	public void testGetAllSize(){
		assertEquals(1, offreVoyageDao.getAllOffres().size());
	}
	
	@Test
	@Transactional(readOnly=true)
	public void testGetAllFirst(){
		assertEquals("Laponie", offreVoyageDao.getAllOffres().get(0).getPays());
	}
	
	//cas de test de l'ajout d'une offre de voyage
	@Test
	@Transactional
	public void testAddOffreVoyage(){
		OffreVoyage ov1= new OffreVoyage("VOY01", "Finlande", "Eygifluk", 130, true, null, false, "Un voyage au pays du père noel", 2300.99, 0, "Week-end en Laponie", null);
		offreVoyageDao.addOffreVoyage(ov1);
		assertEquals(2, offreVoyageDao.getAllOffres().size());
	}
	

	
	
	
}

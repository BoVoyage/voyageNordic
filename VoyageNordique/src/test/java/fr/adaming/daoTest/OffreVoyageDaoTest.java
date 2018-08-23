package fr.adaming.daoTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.adaming.Dao.IOffreVoyageDao;

@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class OffreVoyageDaoTest {

	//instanciation de Dao
	@Autowired
	IOffreVoyageDao offreVoyageDao;
	
	//cas de test de l'ajout d'une offre de voyage
	@Test
	public void testAddOffreVoyage(){
		
	}
	
}

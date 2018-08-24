package fr.adaming.serviceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.OffreVoyage;
import fr.adaming.service.IOffreVoyageService;

@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class OffreVoyageServiceTest {

	// instanciation de Service
	@Autowired
	IOffreVoyageService offreVoyageService;

	// cas de test de la liste des offres de voyage
	// @Test
	@Ignore
	/// @Transactional(readOnly=true)
	public void testGetAllSize() {
		assertEquals(1, offreVoyageService.getAllOffres().size());
	}

	// @Test
	@Ignore
	// @Transactional(readOnly=true)
	public void testGetAllFirst() {
		assertEquals("Laponie", offreVoyageService.getAllOffres().get(0).getPays());
	}

	// cas de test de l'ajout d'une offre de voyage
	// @Test
	@Ignore
	// @Transactional
	public void testAddOffreVoyage() {
		OffreVoyage ov2 = new OffreVoyage("VOY01", "Finlande", "Eygifluk", 130, true, null, false,
				"Un voyage au pays du père noel", 2300.99, 0, "Week-end en Laponie", null);
		offreVoyageService.addOffreVoyage(ov2);
		assertEquals(2, offreVoyageService.getAllOffres().size());
	}

	// cas de test de la recherche par ID
//	 @Test
	@Ignore
//	 @Transactional(readOnly=true)
	public void testGetById() {
		assertEquals(13, offreVoyageService.getAllOffres().get(1).getIdVoyage());
	}

	// cas de test de la recherche par nom
//	 @Test
	@Ignore
//	 @Transactional(readOnly=true)
	public void testGetByName() {
		assertEquals("sdfsdfsd", offreVoyageService.getAllOffres().get(1).getDesignation());
	}

	// cas de test de la recherche par no du voyage
//	 @Test
	@Ignore
//	 @Transactional(readOnly=true)
	public void testGetByNoVoyage() {
		assertEquals("sdfsdf", offreVoyageService.getAllOffres().get(1).getNoVoyage());
	}

	// cas de test de la recherche par no du voyage
//	 @Test
	@Ignore
//	 @Transactional(readOnly=true)
	public void testGetByState() {
		assertEquals("dsfsd", offreVoyageService.getAllOffres().get(1).getPays());
	}

	// cas de test de la recherche par no du voyage
//	 @Test
	@Ignore
//	 @Transactional(readOnly=true)
	public void testGetByPrice() {
		// utilisation d'un wrapper autour de nos données car la méthode
		// assertEquals pour des doubles est debreakée
		assertEquals(new Double(2400), new Double(offreVoyageService.getAllOffres().get(1).getPrixVoyage()));
	}
	
	//cas de test de la suppression d'une offre de voyage
	@Ignore
//	@Test
//	@Transactional
	public void testDeleteOffre(){
		OffreVoyage ovSuppr= new OffreVoyage();
		ovSuppr.setIdVoyage(1);
		offreVoyageService.deleteOffreVoyage(ovSuppr);
		assertEquals(1, offreVoyageService.getAllOffres().size());
	}

}

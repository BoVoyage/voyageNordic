////package fr.adaming.daoTest;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import fr.adaming.Dao.IOffreVoyageDao;
//import fr.adaming.model.OffreVoyage;
//
//@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
//@RunWith(SpringJUnit4ClassRunner.class)
//public class OffreVoyageDaoTest {
//
//	// instanciation de Dao
//	@Autowired
//	IOffreVoyageDao offreVoyageDao;
//
//	// cas de test de la liste des offres de voyage
//	// @Test
//	@Ignore
//	// @Transactional(readOnly=true)
//	public void testGetAllSize() {
//		assertEquals(1, offreVoyageDao.getAllOffres().size());
//	}
//
//	@Ignore
//	// @Test
//	// @Transactional(readOnly=true)
//	public void testGetAllFirst() {
//		assertEquals("Laponie", offreVoyageDao.getAllOffres().get(0).getPays());
//	}
//
//	// cas de test de l'ajout d'une offre de voyage
//	@Ignore
//	@Test
//	@Transactional
//	@Rollback(true)
//	public void testAddOffreVoyage() {
//		OffreVoyage ov1 = new OffreVoyage("VOY01", "Finlande", "Eygifluk", 130, true, null, false,
//				"Un voyage au pays du père noel", 2300.99, 0, "Week-end en Laponie", null);
//		offreVoyageDao.addOffreVoyage(ov1);
//		assertEquals(2, offreVoyageDao.getAllOffres().size());
//	}
//
//	// cas de test de la recherche par ID
//	// @Test
//	@Ignore
//	// @Transactional(readOnly=true)
//	public void testGetById() {
//		assertEquals(13, offreVoyageDao.getAllOffres().get(1).getIdVoyage());
//	}
//
//	// cas de test de la recherche par nom
//	// @Test
//	@Ignore
//	// @Transactional(readOnly=true)
//	public void testGetByName() {
//		assertEquals("sdfsdfsd", offreVoyageDao.getAllOffres().get(1).getDesignation());
//	}
//
//	// cas de test de la recherche par no du voyage
//	// @Test
//	@Ignore
//	// @Transactional(readOnly=true)
//	public void testGetByNoVoyage() {
//		assertEquals("sdfsdf", offreVoyageDao.getAllOffres().get(1).getNoVoyage());
//	}
//
//	// cas de test de la recherche par no du voyage
//	// @Test
//	@Ignore
//	// @Transactional(readOnly=true)
//	public void testGetByState() {
//		assertEquals("dsfsd", offreVoyageDao.getAllOffres().get(1).getPays());
//	}
//
//	// cas de test de la recherche par no du voyage
//	// @Test
//	@Ignore
//	// @Transactional(readOnly=true)
//	public void testGetByPrice() {
//		// utilisation d'un wrapper autour de nos données car la méthode
//		// assertEquals pour des doubles est debreakée
//		assertEquals(new Double(2400), new Double(offreVoyageDao.getAllOffres().get(1).getPrixVoyage()));
//	}
//
//	//cas de test de la suppression d'une offre de voyage
//	@Ignore
////	@Test
////	@Transactional
//	public void testDeleteOffre(){
//		OffreVoyage ovSuppr= new OffreVoyage();
//		ovSuppr.setIdVoyage(1);
//		offreVoyageDao.deleteOffreVoyage(ovSuppr);
//		assertEquals(1, offreVoyageDao.getAllOffres().size());
//	}
//	
//	//cas de test de la modification d'une offre de voyage
//	@Ignore
////	@Test
////	@Transactional
//	public void testUpdateOffre(){
//		OffreVoyage ovModif= new OffreVoyage("sdfsdf", "Finlande", null, 12, true, null, false, null, 2300, 0, null, null);
//		offreVoyageDao.updateOffreVoyage(ovModif);
//		assertEquals("Finlande", offreVoyageDao.getAllOffres().get(0).getPays());
//	}
//	
//	//cas de test de la liste de numero d'offres
//	@Ignore
////	 @Test
////	 @Transactional(readOnly=true)
//	public void testListeNoVoyage(){
//		assertEquals(1, offreVoyageDao.getAllNoVoyage().size());
//		System.out.println(offreVoyageDao.getAllNoVoyage().size());
//	}
//	
//	@Ignore
////	 @Test
////	 @Transactional(readOnly=true)
//	public void testListeNoVoyageFirst(){
//		assertEquals("sdfsdf", offreVoyageDao.getAllNoVoyage().get(0));
//		System.out.println(offreVoyageDao.getAllNoVoyage().get(0));
//	}
//	
//}

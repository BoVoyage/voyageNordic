package fr.adaming.serviceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;
import fr.adaming.service.ICommandeService;

@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class CommandeServiceTest {
	// instanciation de Dao
	@Autowired
	ICommandeService coService;

	private Client cl;

	@Before
	public void beforeMethod() {
		this.cl = new Client();
		cl.setIdClient(1);
	}

	//Cas de test de la sauvegarde d'une commande
	@Ignore
	@Test
	@Transactional
	@Rollback(true)
	public void testAddCommande() {
		int expectedAdd = 3;
		Commande coTest = new Commande(0, null, cl);
		coService.saveCommandeService(coTest);
		assertEquals(expectedAdd, coService.getCommandeByClientService(cl).size());
	}

	// cas de test de la liste des offres de voyage
	@Ignore
	@Test
	@Transactional(readOnly = true)
	public void testGetAllSize() {
		assertEquals(1, coService.getCommandeByClientService(cl).size());
	}
}

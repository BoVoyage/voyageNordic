package fr.adaming.serviceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Client;
import fr.adaming.model.CoordonneeBancaire;
import fr.adaming.service.IClientService;

//@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
//@RunWith(SpringJUnit4ClassRunner.class)
public class ClientServiceImplTest {

//	@Autowired
//	IClientService clientService;
//
//	// cas de test de l'ajout d'un client
////	@Test
////	@Rollback(false)
////	@Transactional(readOnly = true)
//	@Ignore
//	public void testAddClient() {
//		Client clIn = new Client(1,"CL1", "toto", "titi", null, null, null, null, true);
//		clientService.addClientService(clIn);
//		assertEquals(1, clientService.getAllClientService().size());
//	}

}

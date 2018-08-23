package fr.adaming.daoTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.Dao.IClientDao;
import fr.adaming.model.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class ClientDaoImplTest {
	
	@Autowired
	IClientDao clientDao;
	
	/**Tester l'ajout des clients*/
	@Test
	@Rollback(false)
	@Transactional(readOnly=true)
	public void testAddClient(){
		Client clAdd1 = new Client("CL1", "toto", "titi", null, null, null, null, false);
			clientDao.addClient(clAdd1);
			assertEquals(1, clientDao.getAllClientDao().size());
	}
	/**Tester la liste des clients*/
	@Test
	@Transactional(readOnly=true)
	public void testGetAllClientNom(){
		assertEquals("toto", clientDao.getAllClientDao().get(0).getNomClient());
	}
	

}

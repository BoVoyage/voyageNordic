package fr.adaming.daoTest;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.adaming.Dao.IClientDao;
import fr.adaming.model.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class ClientDaoImplTest {
	
	@Autowired
	IClientDao clDao;
	
	public void beforeMethode(){
	}
	//************************************************
	public void testAddClient(){
		
		Client clTest=new Client(12, "DIOP"," Demba", 16/05/2000, "a", "a", 0222, 1);
	}

}

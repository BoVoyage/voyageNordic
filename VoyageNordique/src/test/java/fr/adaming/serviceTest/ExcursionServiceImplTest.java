package fr.adaming.serviceTest;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.adaming.service.IExcursionService;

@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class ExcursionServiceImplTest {
	
	//instanciation de service
	@Autowired
	private IExcursionService excursionService;

}

package fr.adaming.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.Dao.ICommandeDao;
import fr.adaming.model.Client;
import fr.adaming.model.Commande;

/**
 * @author Ewen 
 * Classe implémentant l'interface IClientService
 *         L'annotation @Service permet au conteneur SpringIoC d'identifier
 *         cette classe comme un bean L'annotation @Transactional sert à dire
 *         que cette classe n'est pas un singleton
 */
@Service("coService")
@Transactional
public class CommandeServiceImpl implements ICommandeService{

	/**
	 * Transformation de l'association entre service et dao
	 * L'annotation @Autowired permet de réaliser l'injection automatique des
	 * dépendances.
	 */
	@Autowired
	private ICommandeDao coDao;
	
	@Override
	public Commande saveCommandeService(Commande co) {
		Date date = new Date();
		co.setDateCommande(date);
		Random random = new Random();
		int randomInt = random.nextInt();
		co.setNoCommande(randomInt);
		return coDao.saveCommande(co);
	}

	@Override
	public List<Commande> getCommandeByClientService(Client cl) {
		return coDao.getCommandeByClient(cl);
	}

	@Override
	public int deleteCommandeService(Commande co) {
		return coDao.deleteCommande(co);
	}

	@Override
	public Commande getCommandeByNumberService(Commande co) {
		return coDao.getCommandeByNumber(co);
	}

}

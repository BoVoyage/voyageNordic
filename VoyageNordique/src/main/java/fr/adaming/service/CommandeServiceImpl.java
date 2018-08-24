package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.Dao.ICommandeDao;
import fr.adaming.model.Client;
import fr.adaming.model.Commande;

/**
 * @author Ewen 
 * Classe impl�mentant l'interface IClientService
 *         L'annotation @Service permet au conteneur SpringIoC d'identifier
 *         cette classe comme un bean L'annotation @Transactional sert � dire
 *         que cette classe n'est pas un singleton
 */
@Service("coService")
@Transactional
public class CommandeServiceImpl implements ICommandeService{

	/**
	 * Transformation de l'association entre service et dao
	 * L'annotation @Autowired permet de r�aliser l'injection automatique des
	 * d�pendances.
	 */
	@Autowired
	private ICommandeDao coDao;
	
	@Override
	public Commande saveCommandeService(Commande co) {
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

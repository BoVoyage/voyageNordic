package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.Dao.ILigneCommandeDao;
import fr.adaming.model.Commande;
import fr.adaming.model.LigneCommande;

/**
 * Implementation de LignCommandeService pour redéfinir les méthode en lien avec
 * LigneCommmande
 * 
 * @author Thibault
 *
 */
@Transactional
@Service("lcService")
public class LigneCommandeServiceImpl implements ILigneCommandeService {

	@Autowired
	private ILigneCommandeDao ligneCommandeDao;

	public void setLigneCommandeDao(ILigneCommandeDao ligneCommandeDao) {
		this.ligneCommandeDao = ligneCommandeDao;
	}

	/**
	 * Recuperer la liste des lignes de commandes
	 * 
	 * @return la liste des lignes de commandes
	 */
	@Override
	public List<LigneCommande> getAllLignesCommandes() {
		return ligneCommandeDao.getAllLignesCommandes();
	}

	/**
	 * Ajouter une ligne de commandes
	 * 
	 * @return ajout une ligne de commande
	 */
	@Override
	public LigneCommande addLigneCommande(LigneCommande lc, Commande cmd) {
		// lier les objets java
		lc.setCommande(cmd);

		return ligneCommandeDao.addLigneCommande(lc);
	}

	/**
	 * Modifier une ligne de commandes
	 * 
	 * @return modifie une ligne de commande
	 */
	@Override
	public int updateLigneCommande(LigneCommande lc) {
		return ligneCommandeDao.updateLigneCommande(lc);
	}

	/**
	 * Supprimer une ligne de commandes
	 * 
	 * @return supprime une ligne de commande
	 */
	@Override
	public int deleteLigneCommande(LigneCommande lc) {
		return ligneCommandeDao.deleteLigneCommande(lc);
	}

	/**
	 * Récuperer une ligne de commandes par son id
	 * 
	 * @return une ligne de commande en fonction de son id
	 */
	@Override
	public LigneCommande getLigneCommandebyId(LigneCommande lc) {
		return ligneCommandeDao.getLigneCommandebyId(lc);
	}

	/**
	 * Récuperer une ligne de commande par l'id de la commande
	 * 
	 * @return une ligne de commande par l'id de la commande
	 */
	@Override
	public List<LigneCommande> getLigneCommandeByNoCommande(LigneCommande lc, Commande cmd) {
		// lier les objets java
		lc.setCommande(cmd);
		return ligneCommandeDao.getLigneCommandeByNoCommande(lc);
	}

}

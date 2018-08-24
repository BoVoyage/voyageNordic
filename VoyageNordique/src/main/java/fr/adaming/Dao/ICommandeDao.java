package fr.adaming.Dao;

import java.util.List;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;

/**
 * @author Ewen Interface Dao des méthodes concernant les commandes
 */

public interface ICommandeDao {

	/**
	 * <b>saveCommande</b> Cette méthode permet d'enregistrer une commande dans
	 * la DB
	 * 
	 * @param la
	 *            Commande à enregistrer
	 * @return la commande sauvegardée en base de donnée
	 */
	public Commande saveCommande(Commande co);

	/**
	 * <b>getCommandeByClient</b> Cette méthode permet de récupérer les
	 * commandes d'un client en base de données.
	 * 
	 * @param le
	 *            client dont on cherche les commandes
	 * @return la liste des commandes associées au client en entrée
	 */
	public List<Commande> getCommandeByClient(Client cl);

	/**
	 * <b>deleteCommande</b> Cette méthode permet de supprimer la commande d'un
	 * client en base de données
	 * 
	 * @param la
	 *            Commande à supprimer
	 * @return un int valant 1 si la modification a réussi ou 0 si elle a
	 *         échouée.
	 */
	public int deleteCommande(Commande co);

	/**
	 * <b>getCommandeByNumber</b> Cette méthode permet d'obtenir une commande en
	 * la cherchant par son numéro
	 * 
	 * @param la
	 *            Commande à rechercher
	 * @return la commande trouvée en base de donnée
	 */
	public Commande getCommandeByNumber(Commande co);
}

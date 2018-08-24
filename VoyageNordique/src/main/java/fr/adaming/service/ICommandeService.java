package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;

/**
 * @author Ewen Interface Service des méthodes relier aux commandes
 */
public interface ICommandeService {
	/**
	 * <b>saveCommande</b> Cette méthode permet d'enregistrer une commande dans
	 * la DB
	 * 
	 * @param la
	 *            Commande à enregistrer
	 * @return la commande sauvegardée en base de donnée
	 */
	public Commande saveCommandeService(Commande co);

	/**
	 * <b>getCommandeByClient</b> Cette méthode permet de récupérer les
	 * commandes d'un client en base de données.
	 * 
	 * @param le
	 *            client dont on cherche les commandes
	 * @return la liste des commandes associées au client en entrée
	 */
	public List<Commande> getCommandeByClientService(Client cl);

	/**
	 * <b>deleteCommande</b> Cette méthode permet de supprimer la commande d'un
	 * client en base de données
	 * 
	 * @param la
	 *            Commande à supprimer
	 * @return un int valant 1 si la modification a réussi ou 0 si elle a
	 *         échouée.
	 */
	public int deleteCommandeService(Commande co);

	/**
	 * <b>getCommandeByNumber</b> Cette méthode permet d'obtenir une commande en
	 * la cherchant par son numéro
	 * 
	 * @param la
	 *            Commande à rechercher
	 * @return la commande trouvée en base de donnée
	 */
	public Commande getCommandeByNumberService(Commande co);
}

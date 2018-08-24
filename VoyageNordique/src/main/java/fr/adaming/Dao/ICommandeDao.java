package fr.adaming.Dao;

import java.util.List;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;

/**
 * @author Ewen Interface Dao des m�thodes concernant les commandes
 */

public interface ICommandeDao {

	/**
	 * <b>saveCommande</b> Cette m�thode permet d'enregistrer une commande dans
	 * la DB
	 * 
	 * @param la
	 *            Commande � enregistrer
	 * @return la commande sauvegard�e en base de donn�e
	 */
	public Commande saveCommande(Commande co);

	/**
	 * <b>getCommandeByClient</b> Cette m�thode permet de r�cup�rer les
	 * commandes d'un client en base de donn�es.
	 * 
	 * @param le
	 *            client dont on cherche les commandes
	 * @return la liste des commandes associ�es au client en entr�e
	 */
	public List<Commande> getCommandeByClient(Client cl);

	/**
	 * <b>deleteCommande</b> Cette m�thode permet de supprimer la commande d'un
	 * client en base de donn�es
	 * 
	 * @param la
	 *            Commande � supprimer
	 * @return un int valant 1 si la modification a r�ussi ou 0 si elle a
	 *         �chou�e.
	 */
	public int deleteCommande(Commande co);

	/**
	 * <b>getCommandeByNumber</b> Cette m�thode permet d'obtenir une commande en
	 * la cherchant par son num�ro
	 * 
	 * @param la
	 *            Commande � rechercher
	 * @return la commande trouv�e en base de donn�e
	 */
	public Commande getCommandeByNumber(Commande co);
}

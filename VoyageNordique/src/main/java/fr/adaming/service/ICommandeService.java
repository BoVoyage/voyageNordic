package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Client;
import fr.adaming.model.Commande;

/**
 * @author Ewen Interface Service des m�thodes relier aux commandes
 */
public interface ICommandeService {
	/**
	 * <b>saveCommande</b> Cette m�thode permet d'enregistrer une commande dans
	 * la DB
	 * 
	 * @param la
	 *            Commande � enregistrer
	 * @return la commande sauvegard�e en base de donn�e
	 */
	public Commande saveCommandeService(Commande co);

	/**
	 * <b>getCommandeByClient</b> Cette m�thode permet de r�cup�rer les
	 * commandes d'un client en base de donn�es.
	 * 
	 * @param le
	 *            client dont on cherche les commandes
	 * @return la liste des commandes associ�es au client en entr�e
	 */
	public List<Commande> getCommandeByClientService(Client cl);

	/**
	 * <b>deleteCommande</b> Cette m�thode permet de supprimer la commande d'un
	 * client en base de donn�es
	 * 
	 * @param la
	 *            Commande � supprimer
	 * @return un int valant 1 si la modification a r�ussi ou 0 si elle a
	 *         �chou�e.
	 */
	public int deleteCommandeService(Commande co);

	/**
	 * <b>getCommandeByNumber</b> Cette m�thode permet d'obtenir une commande en
	 * la cherchant par son num�ro
	 * 
	 * @param la
	 *            Commande � rechercher
	 * @return la commande trouv�e en base de donn�e
	 */
	public Commande getCommandeByNumberService(Commande co);
}

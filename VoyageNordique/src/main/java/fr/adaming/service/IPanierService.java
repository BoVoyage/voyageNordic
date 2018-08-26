package fr.adaming.service;

import java.util.List;

import fr.adaming.model.LigneCommande;
import fr.adaming.model.OffreVoyage;

public interface IPanierService {

	/**
	 * Sert � cr�er une ligne de commande lors du choix d'un voyage
	 * 
	 * @return une ligne de commande
	 */
	public LigneCommande addVoyagePanier(OffreVoyage ov, int quantite);

	/**
	 * Permet d'ajouter un voyage au panier directement sur la ligne dans le panier
	 * 
	 * @param lc
	 * @param quantite
	 * @return
	 */
	public LigneCommande addVoyagePanierDirect(LigneCommande lc, int quantite);

	/**
	 * Permet de supprimer un voyage du panier directement sur la ligne dans
	 * le panier
	 * 
	 * @param lc
	 * @param quantite
	 * @return
	 */
	public LigneCommande supprProdPanierDirect(LigneCommande lc, int quantite);

	/**
	 * Permet de rechercher une ligne de commande dans le panier, � partir du N�Voyage
	 * 
	 * @param listeLCPanier
	 * @param pr
	 * @return
	 */
	public LigneCommande searchLCPanierByNoVoyage(List<LigneCommande> listeLCPanier, OffreVoyage ov);

	/**
	 * m�thode pour calculer le prix total du panier
	 * 
	 * @param listeLCPanier
	 * @param prixTotal
	 * @return
	 */
	public double calculTotalPanier(List<LigneCommande> listeLCPanier);

}

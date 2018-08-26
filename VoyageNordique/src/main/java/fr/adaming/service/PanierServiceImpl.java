package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.LigneCommande;
import fr.adaming.model.OffreVoyage;

@Transactional
@Service("panService")
public class PanierServiceImpl implements IPanierService {

	@Autowired // injection dépendance d'un collaborateur
	ICommandeService commandeService;

	// Setter pour l'injection dépendance
	public void setCommandeService(ICommandeService commandeService) {
		this.commandeService = commandeService;
	}

	@Autowired // injection dépendance d'un collaborateur
	IClientService clientService;

	// Setter pour l'injection dépendance
	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	@Autowired // injection dépendance d'un collaborateur
	ILigneCommandeService lignecommandeService;

	// Setter pour l'injection dépendance
	public void setLignecommandeService(ILigneCommandeService lignecommandeService) {
		this.lignecommandeService = lignecommandeService;
	}

	@Autowired // injection dépendance d'un collaborateur
	IOffreVoyageService offreService;

	// Setter pour l'injection dépendance
	public void setOffreService(IOffreVoyageService offreService) {
		this.offreService = offreService;
	}

	/**
	 * Le produit choisi par le client ainsi que sa quantité sont en parametre.
	 * On crée une ligne de commande et on vérifié que la quantité demandée est
	 * disponible Si c’est le cas alors on ajoute à la ligne de commande. On
	 * stocke le produit, la quantité et le prix dans la ligne de commande
	 * 
	 * @return En sortie on récupère lc.
	 */
	@Override
	public LigneCommande addVoyagePanier(OffreVoyage ov, int quantite) {

		LigneCommande lc = new LigneCommande();

		if (quantite <= ov.getQuantite()) {

			lc.setOffrevoyage(ov);;
			lc.setQuantite(quantite);
			lc.setPrix(ov.getPrixVoyage() * quantite);

			return lc;
		} else {

			return null;
		}

	}

	
	@Override
	public LigneCommande addVoyagePanierDirect(LigneCommande lc, int quantite) {
		OffreVoyage ovOut=offreService.getOffreVoyageByName(lc.getOffrevoyage());
		
		lc.setQuantite(lc.getQuantite()+1);
		lc.setPrix(lc.getPrix() + ovOut.getPrixVoyage());
		return lc;
	}
	
	
	@Override
	public LigneCommande supprProdPanierDirect(LigneCommande lc, int quantite) {
		OffreVoyage ovOut=offreService.getOffreVoyageByNoVoyage(lc.getOffrevoyage());
		
		lc.setQuantite(lc.getQuantite()-1);
		lc.setPrix(lc.getPrix() - ovOut.getPrixVoyage());
		
		return lc;
	}

	/**
	 * Méthode pour retrouver une ligne de commande dans le panier à partir de l'id d'un produit
	 */
	@Override
	public LigneCommande searchLCPanierByNoVoyage(List <LigneCommande> listeLCPanier, OffreVoyage ov) {
		
		for (LigneCommande lc : listeLCPanier ) {
			if (lc.getOffrevoyage().getDesignation() == ov.getDesignation()) {
				return lc;
			}
		}
				
		return null;
	}



	@Override
	public double calculTotalPanier(List<LigneCommande> listeLCPanier) {
		double prixTotal=0;
		
		for (LigneCommande lc : listeLCPanier) {
			prixTotal=prixTotal+lc.getPrix();
		}
		
		return prixTotal;
	}



}
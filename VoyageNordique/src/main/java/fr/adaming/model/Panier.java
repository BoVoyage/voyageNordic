package fr.adaming.model;

import java.io.Serializable;
import java.util.List;


@SuppressWarnings("serial")
public class Panier implements Serializable {

	//declaration des attributs
	private List<LigneCommande> listeCommande;
	private LigneCommande ligneCommande;
	
	//declaration des constructeurs
	public Panier() {
		super();
	}

	//declaration des getters et setters
	public List<LigneCommande> getListeCommande() {
		return listeCommande;
	}
	public void setListeCommande(List<LigneCommande> listeCommande) {
		this.listeCommande = listeCommande;
	}

	public LigneCommande getLigneCommande() {
		return ligneCommande;
	}

	public void setLigneCommande(LigneCommande ligneCommande) {
		this.ligneCommande = ligneCommande;
	}	
	
}

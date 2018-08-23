package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "lignescommandes")
public class LigneCommande implements Serializable {

	// declaration des attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idlignecommande")
	private int idLigneCommande;
	private int quantite;
	private double prix;

	// transformation UML en JAVA
	@ManyToOne
	@JoinColumn(name = "commande_id", referencedColumnName = "idcommande")
	private Commande commande;

	// declaration des constructeurs
	public LigneCommande(int idLigneCommande, int quantite, double prix) {
		super();
		this.idLigneCommande = idLigneCommande;
		this.quantite = quantite;
		this.prix = prix;
	}

	public LigneCommande(int quantite, double prix) {
		super();
		this.quantite = quantite;
		this.prix = prix;
	}

	// declaration des getters et setters
	public int getIdLigneCommande() {
		return idLigneCommande;
	}

	public void setIdLigneCommande(int idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	// toString
	@Override
	public String toString() {
		return "LigneCommande [idLigneCommande=" + idLigneCommande + ", quantite=" + quantite + ", prix=" + prix + "]";
	}

}

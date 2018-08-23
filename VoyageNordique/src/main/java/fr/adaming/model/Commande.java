package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "commandes")
public class Commande implements Serializable {

	// declaration des attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCommande")
	private int idCommande;
	private int noCommande;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCommande;

	// transformation UML en JAVA
	@ManyToOne
	@JoinColumn(name = "client_id", referencedColumnName = "idClient")
	private Client client;

	@OneToMany(mappedBy = "commande")
	private List<LigneCommande> listeCommandes;

	// declaration des constructeurs
	public Commande() {
		super();
	}

	public Commande(int noCommande, Date dateCommande) {
		super();
		this.noCommande = noCommande;
		this.dateCommande = dateCommande;
	}

	public Commande(int noCommande, Date dateCommande, Client client) {
		super();
		this.noCommande = noCommande;
		this.dateCommande = dateCommande;
		this.client = client;
	}

	public Commande(int idCommande, int noCommande, Date dateCommande, Client client) {
		super();
		this.idCommande = idCommande;
		this.noCommande = noCommande;
		this.dateCommande = dateCommande;
		this.client = client;
	}

	// declaration des getters et setters
	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public int getNoCommande() {
		return noCommande;
	}

	public void setNoCommande(int noCommande) {
		this.noCommande = noCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<LigneCommande> getListeCommandes() {
		return listeCommandes;
	}

	public void setListeCommandes(List<LigneCommande> listeCommandes) {
		this.listeCommandes = listeCommandes;
	}

	// toString
	@Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", noCommande=" + noCommande + "]";
	}

}

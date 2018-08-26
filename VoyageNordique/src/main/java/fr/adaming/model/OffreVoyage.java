package fr.adaming.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name ="offreVoyages")
public class OffreVoyage {

	// declaration des attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVoyage;
	@NotEmpty(message="Veuillez entrer une numéro d'offre")
	private String noVoyage;
	@NotEmpty(message="Veuillez saisir la destination du voyage")
	private String pays;
	private String ville;
	@NotEmpty(message="Veuillez saisir la quantité de places disponibles")
	private int quantite;
	private boolean etat;
	@Lob
	private byte[] imageDestination;
	private boolean promotion;
	private String descriptionVoyage;
	private double prixVoyage;
	private double remiseVoyage;
	@NotEmpty(message="Veuillez entrer le nom de l'offre de voyage")
	private String designation;
	@Temporal(TemporalType.DATE)
	@Future(message="Veuillez entrer une date postérieure à celle d'aujourd'hui")
	private Date dateDepart;
	@Temporal(TemporalType.DATE)
	@Future(message="Veuillez entrer une date postérieure à celle d'aujourd'hui")
	private Date dateRetour;
	private String compagnieAerienne;

	// transformation des associations UML en JAVA
	@ManyToOne
	@JoinColumn(name = "heberg_id", referencedColumnName = "idhebergement")
	private Hebergement hebergement;
	@ManyToMany(mappedBy = "listeOffreVoyage")
	private List<Excursion> listeExcursion;
	@OneToOne(mappedBy = "offreVoyage")
	private Vehicule vehicule;

	// declaration des constructeurs
	public OffreVoyage() {
		super();
	}

	public OffreVoyage(String noVoyage, String pays, String ville, int quantite, boolean etat, byte[] imageDestination,
			boolean promotion, String descriptionVoyage, double prixVoyage, double remiseVoyage, String designation,
			Date dateDepart, Date dateRetour, String compagnieAerienne) {
		super();
		this.noVoyage = noVoyage;
		this.pays = pays;
		this.ville = ville;
		this.quantite = quantite;
		this.etat = etat;
		this.imageDestination = imageDestination;
		this.promotion = promotion;
		this.descriptionVoyage = descriptionVoyage;
		this.prixVoyage = prixVoyage;
		this.remiseVoyage = remiseVoyage;
		this.designation = designation;
		this.dateDepart = dateDepart;
		this.dateRetour = dateRetour;
		this.compagnieAerienne = compagnieAerienne;
	}

	public OffreVoyage(int idVoyage, String noVoyage, String pays, String ville, int quantite, boolean etat,
			byte[] imageDestination, boolean promotion, String descriptionVoyage, double prixVoyage,
			double remiseVoyage, String designation, Date dateDepart, Date dateRetour, String compagnieAerienne) {
		super();
		this.idVoyage = idVoyage;
		this.noVoyage = noVoyage;
		this.pays = pays;
		this.ville = ville;
		this.quantite = quantite;
		this.etat = etat;
		this.imageDestination = imageDestination;
		this.promotion = promotion;
		this.descriptionVoyage = descriptionVoyage;
		this.prixVoyage = prixVoyage;
		this.remiseVoyage = remiseVoyage;
		this.designation = designation;
		this.dateDepart = dateDepart;
		this.dateRetour = dateRetour;
		this.compagnieAerienne = compagnieAerienne;
	}

	// declaration des getter et setter
	public int getIdVoyage() {
		return idVoyage;
	}

	public void setIdVoyage(int idVoyage) {
		this.idVoyage = idVoyage;
	}

	public String getNoVoyage() {
		return noVoyage;
	}

	public void setNoVoyage(String noVoyage) {
		this.noVoyage = noVoyage;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public byte[] getImageDestination() {
		return imageDestination;
	}

	public void setImageDestination(byte[] imageDestination) {
		this.imageDestination = imageDestination;
	}

	public boolean isPromotion() {
		return promotion;
	}

	public void setPromotion(boolean promotion) {
		this.promotion = promotion;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDescriptionVoyage() {
		return descriptionVoyage;
	}

	public void setDescriptionVoyage(String descriptionVoyage) {
		this.descriptionVoyage = descriptionVoyage;
	}

	public double getPrixVoyage() {
		return prixVoyage;
	}

	public void setPrixVoyage(double prixVoyage) {
		this.prixVoyage = prixVoyage;
	}

	public double getRemiseVoyage() {
		return remiseVoyage;
	}

	public void setRemiseVoyage(double remiseVoyage) {
		this.remiseVoyage = remiseVoyage;
	}

	public Hebergement getHebergement() {
		return hebergement;
	}

	public void setHebergement(Hebergement hebergement) {
		this.hebergement = hebergement;
	}

	public List<Excursion> getListeExcursion() {
		return listeExcursion;
	}

	public void setListeExcursion(List<Excursion> listeExcursion) {
		this.listeExcursion = listeExcursion;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

	public String getCompagnieAerienne() {
		return compagnieAerienne;
	}

	public void setCompagnieAerienne(String compagnieAerienne) {
		this.compagnieAerienne = compagnieAerienne;
	}


}

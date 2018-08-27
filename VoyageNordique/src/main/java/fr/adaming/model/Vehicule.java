package fr.adaming.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="vehicules")
public class Vehicule {
	
	
	//****************************************************************************************
	/**Les attributs de l'excursion*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idVehicule;
	@NotEmpty(message="Veuillez choisir une catégorie")
	private String categorieVehicule;
	@NotEmpty(message="Veuillez remplir le champs marque")
	private String marqueVehicule;
	private double prixVehicule;
	
	//transformation de l'association UML en JAVA
	@OneToOne
	@JoinColumn(name="voyage_id", referencedColumnName="idvoyage")
	private OffreVoyage offreVoyage;

	
	//****************************************************************************************
	/**Constructeur avec params sans id*/
	public Vehicule() {
		super();
	}
	/**Constructeur avec params sans id*/
	public Vehicule(String categorieVehicule, String marqueVehicule, double prixVehicule) {
		super();
		this.categorieVehicule = categorieVehicule;
		this.marqueVehicule = marqueVehicule;
		this.prixVehicule = prixVehicule;
	}	
	/**Constructeur avec params avec id*/
	public Vehicule(int idVehicule, String categorieVehicule, String marqueVehicule, double prixVehicule) {
		super();
		this.idVehicule = idVehicule;
		this.categorieVehicule = categorieVehicule;
		this.marqueVehicule = marqueVehicule;
		this.prixVehicule = prixVehicule;
	}	
	//****************************************************************************************
	/**Les getters et setters*/
	public int getIdVehicule() {
		return idVehicule;
	}
	public void setIdVehicule(int idVehicule) {
		this.idVehicule = idVehicule;
	}
	public String getCategorieVehicule() {
		return categorieVehicule;
	}
	public void setCategorieVehicule(String categorieVehicule) {
		this.categorieVehicule = categorieVehicule;
	}
	public String getMarqueVehicule() {
		return marqueVehicule;
	}
	public void setMarqueVehicule(String marqueVehicule) {
		this.marqueVehicule = marqueVehicule;
	}
	public double getPrixVehicule() {
		return prixVehicule;
	}
	public void setPrixVehicule(double prixVehicule) {
		this.prixVehicule = prixVehicule;
	}
	
	

}

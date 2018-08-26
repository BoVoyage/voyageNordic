package fr.adaming.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="excursions")
public class Excursion{
	
	//****************************************************************************************
	/**Les attributs de l'excursion*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idExcursion;
	@NotEmpty(message="Veuillez entrer le nom de l'excursion")
	private String nomExcursion;
	private String descriptionExcursion;
	@Lob
	private byte[] imageExcursion;
	@NotEmpty(message="Veuillez entrer le prix de l'excursion")
	private double prixExcursion;
	
	//transformation de l'association UML en JAVA
	@ManyToMany
	@JoinTable(name="voyage_excursion", joinColumns=@JoinColumn(name="excursion_id"), inverseJoinColumns=@JoinColumn(name="voyage_id"))
	private List<OffreVoyage> listeOffreVoyage;
	
	//****************************************************************************************
	/**Constructeur vide**/
	public Excursion() {
		super();
	}	
	
	/**Constructeur avec params sans id*/
	public Excursion(String nomExcursion, String descriptionExcursion, byte[] imageExcursion, double prixExcursion) {
		super();
		this.nomExcursion = nomExcursion;
		this.descriptionExcursion = descriptionExcursion;
		this.imageExcursion = imageExcursion;
		this.prixExcursion = prixExcursion;
	}
	
	/**Constructeur avec params avec id*/
	public Excursion(int idExcursion, String nomExcursion, String descriptionExcursion, byte[] imageExcursion,
			double prixExcursion) {
		super();
		this.idExcursion = idExcursion;
		this.nomExcursion = nomExcursion;
		this.descriptionExcursion = descriptionExcursion;
		this.imageExcursion = imageExcursion;
		this.prixExcursion = prixExcursion;
	}
	
	//****************************************************************************************
	/**Les getters et setters*/
	
	public int getIdExcursion() {
		return idExcursion;
	}
	public void setIdExcursion(int idExcursion) {
		this.idExcursion = idExcursion;
	}
	public String getNomExcursion() {
		return nomExcursion;
	}
	public void setNomExcursion(String nomExcursion) {
		this.nomExcursion = nomExcursion;
	}
	public String getDescriptionExcursion() {
		return descriptionExcursion;
	}
	public void setDescriptionExcursion(String descriptionExcursion) {
		this.descriptionExcursion = descriptionExcursion;
	}
	public double getPrixExcursion() {
		return prixExcursion;
	}
	public void setPrixExcursion(double prixExcursion) {
		this.prixExcursion = prixExcursion;
	}
	public List<OffreVoyage> getListeOffreVoyage() {
		return listeOffreVoyage;
	}
	public void setListeOffreVoyage(List<OffreVoyage> listeOffreVoyage) {
		this.listeOffreVoyage = listeOffreVoyage;
	}

	public byte[] getImageExcursion() {
		return imageExcursion;
	}

	public void setImageExcursion(byte[] imageExcursion) {
		this.imageExcursion = imageExcursion;
	}

	
	

}

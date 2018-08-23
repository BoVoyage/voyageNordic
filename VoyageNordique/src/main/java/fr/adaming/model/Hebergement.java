package fr.adaming.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="hebergements")
public class Hebergement {
	
	//declaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idhebergement")
	private int idHebergement;
	private String nomHebergement;
	private String descriptionHebergement;
	@Lob
	private byte[] imageHebergement;
	@Transient
	private String imageHeberg;
	
	//transformation de l'asso UML en JAVA
	@OneToMany(mappedBy="hebergement")
	private List<OffreVoyage> listeOffres;

	
	//declaration des constructeurs
	public Hebergement() {
		super();
	}


	public Hebergement(String nomHebergement, String descriptionHebergement, byte[] imageHebergement) {
		super();
		this.nomHebergement = nomHebergement;
		this.descriptionHebergement = descriptionHebergement;
		this.imageHebergement = imageHebergement;
	}


	public Hebergement(int idHebergement, String nomHebergement, String descriptionHebergement, byte[] imageHebergement) {
		super();
		this.idHebergement = idHebergement;
		this.nomHebergement = nomHebergement;
		this.descriptionHebergement = descriptionHebergement;
		this.imageHebergement = imageHebergement;
	}


	//declaration des getter et setter
	public int getIdHebergement() {
		return idHebergement;
	}


	public void setIdHebergement(int idHebergement) {
		this.idHebergement = idHebergement;
	}


	public String getNomHebergement() {
		return nomHebergement;
	}


	public void setNomHebergement(String nomHebergement) {
		this.nomHebergement = nomHebergement;
	}


	public String getDescriptionHebergement() {
		return descriptionHebergement;
	}


	public void setDescriptionHebergement(String descriptionHebergement) {
		this.descriptionHebergement = descriptionHebergement;
	}


	public byte[] getImageHebergement() {
		return imageHebergement;
	}


	public void setImageHebergement(byte[] imageHebergement) {
		this.imageHebergement = imageHebergement;
	}


	public String getImageHeberg() {
		return imageHeberg;
	}


	public void setImageHeberg(String imageHeberg) {
		this.imageHeberg = imageHeberg;
	}


	public List<OffreVoyage> getListeOffres() {
		return listeOffres;
	}


	public void setListeOffres(List<OffreVoyage> listeOffres) {
		this.listeOffres = listeOffres;
	}
	
	
	
	
	

}

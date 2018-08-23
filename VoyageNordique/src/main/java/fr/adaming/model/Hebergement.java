package fr.adaming.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="hebergements")
public class Hebergement {
	
	//declaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idHebergement;
	private String nomHebergement;
	private String descriptionHebergement;
	@Lob
	private byte[] imageHebergement;
	@Transient
	private String imageHeberg;

	
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
	
	
	
	
	

}

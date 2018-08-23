package fr.adaming.model;

import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class Vol {
	
	//declaration des attributs
	private Date dateDepart;
	private Date dateRetour;
	private String compagnie;

	
	//declaration des constructeurs
	public Vol() {
		super();
	}


	public Vol(Date dateDepart, Date dateRetour, String compagnie) {
		super();
		this.dateDepart = dateDepart;
		this.dateRetour = dateRetour;
		this.compagnie = compagnie;
	}


	//declaration des getter et setter
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


	public String getCompagnie() {
		return compagnie;
	}


	public void setCompagnie(String compagnie) {
		this.compagnie = compagnie;
	}
	
	

}

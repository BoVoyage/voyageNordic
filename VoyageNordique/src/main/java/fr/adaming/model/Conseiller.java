package fr.adaming.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "conseillers")
public class Conseiller implements Serializable{

	// Déclaration des attributs
	/**
	 * L'ID du conseiller
	 * 
	 * @Id permet d'indiquer l'identifiant clé primaire de l'ID tel qu'il
	 *     apparaîtra en base de données.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idConseiller")
	private int idConseiller;
	
	/**
	 * Le numéro d'identifiant unique du conseiller
	 */
	private String noIdentifiant;
	/**
	 * Le nom du conseiller
	 */
	private String nomCo;
	/**
	 * Le mot de passe du conseiller qui lui servira à se connecter au site
	 */
	private String mdpCo;
	/**
	 * Le statut du conseiller
	 */
	private boolean activeCo;

	// Transformation de l'association UML en JAVA
	/**
	 * Permet de créer l'association entre les rôles et les conseillers
	 */
	@ManyToMany(mappedBy="listeConseillers")
	private List<Role> listeRoles = new ArrayList<Role>();
	
	// Constructeurs
	/**
	 * Le constructeur avec ID du conseiller
	 * 
	 * @param regroupe
	 *            tous les attributs du conseiller y compris son identifiant.
	 */
	public Conseiller(int idConseiller, String noIdentifiant, String nomCo, String mdpCo, boolean activeCo) {
		super();
		this.idConseiller = idConseiller;
		this.noIdentifiant = noIdentifiant;
		this.nomCo = nomCo;
		this.mdpCo = mdpCo;
		this.activeCo = activeCo;
	}
	
	/**
	 * Le constructeur sans ID du conseiller
	 * 
	 * @param regroupe
	 *            tous les attributs du conseiller sauf son identifiant.
	 */
	public Conseiller(String noIdentifiant, String nomCo, String mdpCo, boolean activeCo) {
		super();
		this.noIdentifiant = noIdentifiant;
		this.nomCo = nomCo;
		this.mdpCo = mdpCo;
		this.activeCo = activeCo;
	}
	
	/**
	 * Le constructeur vide du Conseiller
	 * 
	 */
	public Conseiller() {
		super();
	}

	// Getters et setters
	/**Un getter pour l'ID du conseiller
	 * @return l'ID du conseiller
	 */
	public int getIdConseiller() {
		return idConseiller;
	}

	/**Un setter pour l'ID du conseiller
	 * @param l'ID du conseiller à modifier
	 */
	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}

	/**Un getter pour le numéro d'identifiant du conseiller
	 * @return le numéro d'identifiant du conseiller
	 */
	public String getNoIdentifiant() {
		return noIdentifiant;
	}

	/**Un setter pour le numéro d'identifiant du conseiller
	 * @param le numéor d'identifiant à modifier
	 */
	public void setNoIdentifiant(String noIdentifiant) {
		this.noIdentifiant = noIdentifiant;
	}

	/** Un getter pour le nom du conseiller
	 * @return le nom du conseiller
	 */
	public String getNomCo() {
		return nomCo;
	}

	/**Un setter pour le nom du conseiller
	 * @param le nom du conseiller à modifier
	 */
	public void setNom(String nomCo) {
		this.nomCo = nomCo;
	}

	/**Un getter pour le mot de passe du conseiller
	 * @return le mot de passe du conseiller
	 */
	public String getMdpCo() {
		return mdpCo;
	}

	/**Un setter pour le nom du conseiller
	 * @param le mot de passe du conseiller à modifier
	 */
	public void setMdp(String mdpCo) {
		this.mdpCo = mdpCo;
	}

	/**Un getter pour le statut du conseiller
	 * @return le statut du conseiller, actif ou non.
	 */
	public boolean isActiveCo() {
		return activeCo;
	}

	/**Un setter pour le nom du conseiller
	 * @param le statut du conseiller à modifier
	 */
	public void setActiveCo(boolean activeCo) {
		this.activeCo = activeCo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Conseiller [idConseiller=" + idConseiller + ", noIdentifiant=" + noIdentifiant + ", nomCo=" + nomCo
				+ ", mdpCo=" + mdpCo + ", active=" + activeCo + "]";
	}

}

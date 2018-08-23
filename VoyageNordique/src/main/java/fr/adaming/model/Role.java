package fr.adaming.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role implements Serializable{

	// Déclaration des attributs
	/**
	 * L'ID du role
	 * 
	 * @Id permet d'indiquer l'identifiant clé primaire de l'ID tel qu'il
	 *     apparaîtra en base de données.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRole")
	private int idRole;
	/**
	 * Le nom du role
	 */
	private String roleName;

	// Transformation de l'association UML en JAVA
	/**
	 * Permet de créer l'association entre les rôles et les conseillers
	 */
	@ManyToMany
	@JoinTable(name = "conseillers_roles", joinColumns = @JoinColumn(name = "roleId"), inverseJoinColumns = @JoinColumn(name = "conseillerId"))
	private List<Conseiller> listeConseillers = new ArrayList<Conseiller>();

	/**
	 * Permet de créer l'association entre les rôles et les clients
	 */
	@ManyToOne
	@JoinColumn(name = "clientId", referencedColumnName = "idClient")
	private Client client;

	// Constructeurs
	/**
	 * Le constructeur avec ID du role
	 * 
	 * @param regroupe
	 *            tous les attributs du role y compris son identifiant.
	 */

	public Role(int idRole, String roleName) {
		super();
		this.idRole = idRole;
		this.roleName = roleName;
	}

	/**
	 * Le constructeur sans ID du role
	 * 
	 * @param regroupe
	 *            tous les attributs du role sauf son identifiant.
	 */
	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}

	/**
	 * Le constructeur vide du role
	 * 
	 */
	public Role() {
		super();
	}

	// Getters et setters
	/**
	 * Un getter pour l'ID du role.
	 * 
	 * @return l'ID unique du rôle
	 */
	public int getIdRole() {
		return idRole;
	}

	/**
	 * Un setter pour l'ID du role.
	 * 
	 * @param l'ID
	 *            du role à récupérer
	 */
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	/**
	 * Un getter pour le nom du role.
	 * 
	 * @return le nom du role
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * Un setter pour le nom du role
	 * 
	 * @param le
	 *            nom du role à récupérer
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}

package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

public class Client implements Serializable{
	
	//****************************************************************************************
	/**Les attributs du clients*/
	private int idClient;
	private String noClient;
	private String nomClient;
	private String prenomClient;
	private Date dn;
	private String mail;
	private String mdp;
	private String tel;
	private boolean active;
	
	//****************************************************************************************
	/**Les attributs du clients*/
	public Client() {
		super();
	}
	/**Constructeur avec params sans id*/
	public Client(String noClient, String nomClient, String prenomClient, Date dn, String mail, String mdp, String tel,
			boolean active) {
		super();
		this.noClient = noClient;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.dn = dn;
		this.mail = mail;
		this.mdp = mdp;
		this.tel = tel;
		this.active = active;
	}
	/**Constructeur avec params sans id*/
	public Client(int idClient, String noClient, String nomClient, String prenomClient, Date dn, String mail,
			String mdp, String tel, boolean active) {
		super();
		this.idClient = idClient;
		this.noClient = noClient;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.dn = dn;
		this.mail = mail;
		this.mdp = mdp;
		this.tel = tel;
		this.active = active;
	}
	//****************************************************************************************
	/**Les getters et setters*/
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public String getNoClient() {
		return noClient;
	}
	public void setNoClient(String noClient) {
		this.noClient = noClient;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getPrenomClient() {
		return prenomClient;
	}
	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}
	public Date getDn() {
		return dn;
	}
	public void setDn(Date dn) {
		this.dn = dn;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		
		this.tel = tel;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
}

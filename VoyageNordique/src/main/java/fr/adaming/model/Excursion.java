package fr.adaming.model;


public class Excursion{
	
	//****************************************************************************************
	/**Les attributs de l'excursion*/
	private int idExcursion;
	private String nomExcursion;
	private String descriptionExcursion;
	private String imageExcursion;
	private byte[] photo;
	private double prixExcursion;
	
	//****************************************************************************************
	/**Constructeur avec params sans id*/
	public Excursion() {
		super();
	}	
	/**Constructeur avec params sans id*/
	public Excursion(String nomExcursion, String descriptionExcursion, String imageExcursion, byte[] photo,
			double prixExcursion) {
		super();
		this.nomExcursion = nomExcursion;
		this.descriptionExcursion = descriptionExcursion;
		this.imageExcursion = imageExcursion;
		this.photo = photo;
		this.prixExcursion = prixExcursion;
	}
	/**Constructeur avec params avec id*/
	public Excursion(int idExcursion, String nomExcursion, String descriptionExcursion, String imageExcursion,
			byte[] photo, double prixExcursion) {
		super();
		this.idExcursion = idExcursion;
		this.nomExcursion = nomExcursion;
		this.descriptionExcursion = descriptionExcursion;
		this.imageExcursion = imageExcursion;
		this.photo = photo;
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
	public String getImageExcursion() {
		return imageExcursion;
	}
	public void setImageExcursion(String imageExcursion) {
		this.imageExcursion = imageExcursion;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public double getPrixExcursion() {
		return prixExcursion;
	}
	public void setPrixExcursion(double prixExcursion) {
		this.prixExcursion = prixExcursion;
	}
	

}

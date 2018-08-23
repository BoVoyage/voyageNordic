package fr.adaming.model;

public class Vehicule {
	
	
	//****************************************************************************************
	/**Les attributs de l'excursion*/
	private int idVehicule;
	private String categorieVehicule;
	private String marqueVehicule;
	private double prixVehicule;

	
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

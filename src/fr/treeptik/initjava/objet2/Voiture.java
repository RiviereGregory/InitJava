package fr.treeptik.initjava.objet2;

public class Voiture extends Vehicule {

	// Données Membres
	private Integer nbPorte;
	private Boolean clim;
	private Boolean radio;

	// Constructeurs
	public Voiture(Integer puissance, Carburant carburant, Integer nbPorte, Boolean clim,
			Boolean radio) {

		super(puissance, carburant);

		this.nbPorte = nbPorte;
		this.clim = clim;
		this.radio = radio;
	}

	public Voiture() {
	}

	// Méthodes

	@Override
	public void avancer() {
		System.out.println("Avancer Voiture");
	}

	// Accesseur
	public Integer getNbPorte() {
		return nbPorte;
	}

	public void setNbPorte(Integer nbPorte) {
		this.nbPorte = nbPorte;
	}

	public Boolean getClim() {
		return clim;
	}

	public void setClim(Boolean clim) {
		this.clim = clim;
	}

	public Boolean getRadio() {
		return radio;
	}

	public void setRadio(Boolean radio) {
		this.radio = radio;
	}

}

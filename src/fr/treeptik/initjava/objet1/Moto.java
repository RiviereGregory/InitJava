package fr.treeptik.initjava.objet1;

public class Moto extends Vehicule {

	// Données Membres
	private Boolean sideCar;

	// Constructeurs

	public Moto(Integer puissance, Carburant carburant, Boolean sideCar) {
		
		super(puissance, carburant);
		
		this.sideCar = sideCar;
	}

	public Moto() {
	}

	// Accesseurs
	public Boolean getSideCar() {
		return sideCar;
	}

	public void setSideCar(Boolean sideCar) {
		this.sideCar = sideCar;
	}

}

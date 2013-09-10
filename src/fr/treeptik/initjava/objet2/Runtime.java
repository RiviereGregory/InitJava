package fr.treeptik.initjava.objet2;

import fr.treeptik.initjava.objet2.Vehicule.Carburant;

public class Runtime {

	public static void main(String[] args) {

		Voiture v = new Voiture(150, Carburant.SANS_PLOMB, 5, true, true);

		System.out.println("Puissance voiture : " + v.getPuissance());

		Moto m = new Moto(90, Carburant.SANS_PLOMB, true);

		afficherInfoVehicule(v);
		afficherInfoVehicule(m);

		System.out.println("********** AVANCER ***********");
		v.avancer();
		m.avancer();
		System.out.println("avec fonction avancer vehicule");
		avancerVehicule(v);

		
		// Appel des accesseurs static
		System.out.println("NB Vehicule : " + Vehicule.getCount());
	}

	public static void avancerVehicule(Vehicule vehicule) {
		vehicule.avancer();
	}

	public static void afficherInfoVehicule(Vehicule vehicule) {
		// Polymorphisme que les paramètres des vehicules
		System.out.println("Véhicule Puissance : " + vehicule.getPuissance() + " Carburant : "
				+ vehicule.getCarburant());

		// Cast pour utiliser les paramètres de voiture
		if (vehicule instanceof Voiture) {
			Voiture voiture = (Voiture) vehicule;
			System.out.println("Nb de porte : " + voiture.getNbPorte());
		}
	}

}

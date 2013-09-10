package fr.treeptik.initjava.objet3;

import fr.treeptik.initjava.objet3.Vehicule.Carburant;

public class Runtime {

	public static void main(String[] args) {

		Voiture v = new Voiture(150, Carburant.SANS_PLOMB, 5, true, true);

		System.out.println("Puissance voiture : " + v.getPuissance());

		Moto m = new Moto(90, Carburant.SANS_PLOMB, true);

		System.out.println("********** AVANCER ***********");

		Personne personne = new Personne("TOTO", "TITI");

		avancer(m);
		avancer(v);
		avancer(personne);

		// Appel des accesseurs static
		System.out.println("NB Vehicule : " + Vehicule.getCount());
	}

	public static void avancer(ComportementAvancer comportementAvancer) {
		comportementAvancer.avancer();
	}

}

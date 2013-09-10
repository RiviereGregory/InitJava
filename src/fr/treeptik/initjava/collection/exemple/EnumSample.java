package fr.treeptik.initjava.collection.exemple;

import java.util.Scanner;

public class EnumSample {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("entrer un jour ouvre : ");
		String jourSaisie = scanner.nextLine();

		// transforme la chaine de caractère en JourOuvre s'il existe
		JourOuvre jourOuvre = JourOuvre.valueOf(jourSaisie.toUpperCase());

		afficherJour(jourOuvre);

		JourOuvre[] jourOuvres = JourOuvre.values();
		for (JourOuvre jourOuvre2 : jourOuvres) {
			System.out.println(jourOuvre2.name());
		}

		scanner.close();

	}

	public static void afficherJour(JourOuvre jourOuvre) {

		// jourOuvre.ordinal permet de récuperer le numero d'ordre de l'enum
		// jourOuvre.name identique à jourOuvre
		System.out.println("Valeur ordinal : " + jourOuvre.ordinal()
				+ " - Valeur du constructeur : " + jourOuvre.getNumeroJour() + " - " + jourOuvre);

	}

}

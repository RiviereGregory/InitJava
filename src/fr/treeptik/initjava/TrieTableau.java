package fr.treeptik.initjava;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TrieTableau {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] monTableau = new Integer[10];
		monTableau[0] = 2;
		monTableau[1] = 20;
		monTableau[2] = 122;
		monTableau[3] = 2;
		monTableau[4] = 156;
		monTableau[5] = 5;
		monTableau[6] = 22;
		monTableau[7] = 35;
		monTableau[8] = 468;
		monTableau[9] = 12;

		//
		// Methode for
		//
		Integer valeurCompare = null;

		for (int i = 0; i < monTableau.length - 1; i++) {
			valeurCompare = monTableau[i];
			for (int j = i + 1; j < monTableau.length; j++) {
				// met la valeur la plus petite en premier
				if (valeurCompare > monTableau[j]) {
					int valeurTmp = monTableau[j];
					monTableau[j] = valeurCompare;
					monTableau[i] = valeurTmp;
					valeurCompare = monTableau[i];
				}
			}
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(monTableau[i]);
		}
		System.out.println("///////////////////////");
		monTableau[0] = 2;
		monTableau[1] = 20;
		monTableau[2] = 122;
		monTableau[3] = 2;
		monTableau[4] = 156;
		monTableau[5] = 5;
		monTableau[6] = 22;
		monTableau[7] = 35;
		monTableau[8] = 468;
		monTableau[9] = 12;

		boolean permut = false;
		do {
			permut = false;

			for (int i = 0; i < monTableau.length - 1; i++) {
				if (monTableau[i + 1] < monTableau[i]) {
					int temp = monTableau[i];
					monTableau[i] = monTableau[i + 1];
					monTableau[i + 1] = temp;

					permut = true;
				}
			}
		} while (permut);

		for (Integer valeur : monTableau) {
			System.out.println("la valeur do while :" + valeur);

		}

		System.out.println("///////////////////////");
		// valeur du tableau dans un ordre aleatoire
		monTableau[0] = 2;
		monTableau[1] = 20;
		monTableau[2] = 122;
		monTableau[3] = 2;
		monTableau[4] = 156;
		monTableau[5] = 5;
		monTableau[6] = 22;
		monTableau[7] = 35;
		monTableau[8] = 468;
		monTableau[9] = 12;

		Arrays.sort(monTableau);// tableau trié
		for (Integer valeur : monTableau) {
			System.out.println("la valeur sort direct :" + valeur);

		}

		//
		// Inversion trie avec list
		//

		System.out.println("///////////////////////");

		// valeur du tableau dans un ordre aleatoire
		monTableau[0] = 2;
		monTableau[1] = 20;
		monTableau[2] = 122;
		monTableau[3] = 2;
		monTableau[4] = 156;
		monTableau[5] = 5;
		monTableau[6] = 22;
		monTableau[7] = 35;
		monTableau[8] = 468;
		monTableau[9] = 12;

		Arrays.sort(monTableau);// tableau trié
		List<Integer> list = Arrays.asList(monTableau); // transforme le tableau
														// en list
		Collections.reverse(list); // inverse l'ordre de la list
		for (Integer valeur : list) {
			System.out.println("la valeur sort direct :" + valeur);
		}

		//
		// Inversion trie avec Collections reverseOrder
		//
		System.out.println("///////////////////////");
		// valeur du tableau dans un ordre aleatoire
		monTableau[0] = 2;
		monTableau[1] = 20;
		monTableau[2] = 122;
		monTableau[3] = 2;
		monTableau[4] = 156;
		monTableau[5] = 5;
		monTableau[6] = 22;
		monTableau[7] = 35;
		monTableau[8] = 468;
		monTableau[9] = 12;

		Arrays.sort(monTableau, Collections.reverseOrder());// tableau trié
		for (Integer valeur : monTableau) {
			System.out.println("la valeur sort direct :" + valeur);
		}
		System.out.println("///////////////////////");

		// Méthode pour mélanger les list
		Collections.shuffle(list);
		for (Integer valeur : list) {
			System.out.println("la valeur shuffle :" + valeur);
		}
		// méthode trie
		Collections.sort(list);
		for (Integer valeur : list) {
			System.out.println("la valeur sort :" + valeur);
		}

		// méthode trie inverse
		Collections.sort(list, Collections.reverseOrder());
		for (Integer valeur : list) {
			System.out.println("la valeur sort reverse :" + valeur);
		}

	}
}

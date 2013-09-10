package fr.treeptik.initjava;

import java.util.Arrays;
import java.util.Collections;

public class ValeurMaxTableau {

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

		// int valeurMax = -1;
		Integer valeurMax = null;

		for (int i = 0; i < 10; i++) {

			if (i == 0) {
				valeurMax = monTableau[i];
			} else if (valeurMax < monTableau[i]) {
				valeurMax = monTableau[i];
			}

		}
		System.out.println("la valeur max methode1 est :" + valeurMax);

		//
		// Autre methode de for
		//
		valeurMax = null;
		int numeroValeur = 0;
		for (Integer valeurTab : monTableau) {
			if (numeroValeur == 0) {
				valeurMax = valeurTab;
			} else if (valeurMax < valeurTab) {
				valeurMax = valeurTab;
			}
			numeroValeur++;
		}
		System.out.println("la valeur max methode2 est :" + valeurMax);

		// on peut utiliser directement l'instruction pour avoir le max
		// sans faire une boucle
		System.out.println("la valeur max direct :" + Collections.max(Arrays.asList(monTableau)));

	}
}

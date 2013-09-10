package fr.treeptik.initjava.exercice.livre;

import java.util.Scanner;

public class SolutionTemp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String line = "";
		Integer n = null;
		Boolean conditionTaille = false;

		while (!conditionTaille) {
			System.out.println("Entrer le nombre de Température ");
			line = in.nextLine();
			n = Integer.valueOf(line);
			if (n > -1 && n < 10000) {
				conditionTaille = true;
			} else {
				conditionTaille = false;
			}

		}
		Integer[] tabTemp = new Integer[n];

		for (int i = 0; i < n; i++) {
			Integer temp = null;
			Boolean conditionTemp = false;
			System.out.println("Entrer la Température ");
			while (!conditionTemp) {

				line = in.nextLine();
				temp = Integer.valueOf(line);
				if (temp > -274 && temp < 5527) {
					conditionTemp = true;
				} else {
					System.out.println("Mauvaise Température, entrer la Température ");
					conditionTemp = false;
				}

			}

			tabTemp[i] = temp;
		}
		Integer valeurProcheZero = 0;
		if (tabTemp.length > 0) {
			valeurProcheZero = tabTemp[0] - 0;
		}
		for (int i = 1; i < n; i++) {
			if (Math.abs(tabTemp[i] - 0) < Math.abs(valeurProcheZero)) {
				valeurProcheZero = tabTemp[i] - 0;
			} else if (Math.abs(tabTemp[i] - 0) == Math.abs(valeurProcheZero)
					&& (tabTemp[i] - 0) > 0) {
				valeurProcheZero = tabTemp[i] - 0;
			}
		}

		System.out.println("la valeur la plus proche de zéro est : " + valeurProcheZero);

		in.close();

	}

}

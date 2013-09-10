package fr.treeptik.initjava.exercice.livre;

import java.util.Scanner;

public class RacCara {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = "";

		
		do {
			System.out.println("donnez un nombre positif");
			line = scanner.nextLine();
			Double valeur = Double.valueOf(line);
			if (valeur > 0) {
				System.out.println("sa racine carree est : " + Math.sqrt(valeur));

			} else if (valeur < 0) {
				System.out.println("svp Positif");
				continue;

			} else {
				break;
			}
		} while (true);

		scanner.close();
	}

}

package fr.treeptik.initjava;

import java.util.Scanner;

public class TableMulti {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String line = "";

		while (!"Q".equalsIgnoreCase(line)) {

			System.out.println("+---- MENU ----+");
			System.out.println("+---- Saisir 'A' pour les additions ----+");
			System.out.println("+---- saisir 'M' pour les multiplications ----+");
			System.out.println("+---- saisir 'Q' pour quitter ----+");

			line = scanner.nextLine();

			if ("Q".equalsIgnoreCase(line)) {

				System.out.println("Sortie de l'application");

			} else if ("M".equalsIgnoreCase(line) || "A".equalsIgnoreCase(line)) {

				for (int i = 1; i < 11; i++) {

					System.out.println("\n+------Table de " + i);

					for (int j = 1; j < 11; j++) {
						if ("M".equalsIgnoreCase(line)) {
							System.out.println(i + " * " + j + " = " + i * j);

						} else if ("A".equalsIgnoreCase(line)) {
							System.out.println(i + " + " + j + " = " + (i + j));

						}
					}
				}
			} else {

				System.out.println("Erreur de saisie");

			}
		}

		scanner.close();

	}

}

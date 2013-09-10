package fr.treeptik.initjava.exercice.livre;

import java.util.Scanner;

public class Serie {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = "";
		System.out.println("donner un nombre : ");
		line = scanner.nextLine();
		Integer valeur = Integer.valueOf(line);
		Float somme = 0.0F;
		for (int i = 1; i <= valeur; i++) {
			somme += 1.0F / i;
		}
		System.out.println("la somme de la suite : " + somme);

		scanner.close();
	}

}

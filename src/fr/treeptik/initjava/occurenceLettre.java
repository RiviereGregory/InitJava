package fr.treeptik.initjava;

import java.util.Scanner;

public class occurenceLettre {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("saisir une phrase :");
		String line = scanner.nextLine();
		Integer[] tabLettre = new Integer[26];

		for (int i = 0; i < 26; i++) {
			tabLettre[i] = 0;
		}

		line = line.replaceAll(" ", ""); // supprime tous les espaces
		line = line.toUpperCase();
		// System.out.println(line);

		for (int i = 0; i < line.length(); i++) {
			Character lettre = line.charAt(i);
			int valeurASCII = lettre.charValue();
			if (valeurASCII > 64 && valeurASCII < 91) { // sert a garder que les
														// lettres de l'alphabet
				tabLettre[valeurASCII - 65] += 1;
			}
		}
		for (int i = 0; i < 26; i++) {
			char lettreChar = (char) (65 + i);
			if (tabLettre[i] > 0) {//pour afficher que les lettres utilisées
				System.out.println(lettreChar + " : " + tabLettre[i]);
			}
		}

		scanner.close();
	}

}

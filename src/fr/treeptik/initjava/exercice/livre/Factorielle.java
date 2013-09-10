package fr.treeptik.initjava.exercice.livre;

import java.util.Scanner;

public class Factorielle {

	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("entrer un nombre : ");
		String line = scanner.nextLine();
		Integer integer = Integer.valueOf(line);
		System.out.println("le resultat est : " + FactorielleR(integer));
		scanner.close();
	}

	public static Integer FactorielleR(Integer n) {
		if (n == 0) {
			return 1;
		} else {
			return n * FactorielleR(n - 1);
		}
	}

}

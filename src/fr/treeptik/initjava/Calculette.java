package fr.treeptik.initjava;

import java.util.Scanner;

public class Calculette {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int value1;
		int value2;
		System.out.println("entrer l'entier 1: ");
		value1 = scanner.nextInt();
		System.out.println("entrer l'entier 2: ");
		value2 = scanner.nextInt();
		System.out.println(value1 +" + "+value2 +" = " + (value1+value2));

		scanner.close();
	}

}

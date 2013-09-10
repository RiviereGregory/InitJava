package fr.treeptik.initjava;

import java.util.Scanner;

public class AfficheEtoileSaisie {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("saisir le nombre d'étoiles du triangle :");
		String line = scanner.nextLine();
		Integer nombreEtoile = Integer.valueOf(line);
		String etoile = "";
		for (int i = 1; i< nombreEtoile+1;i++){
			etoile += "*"; 
			System.out.println(etoile);
		}

		
		scanner.close();
	}

}

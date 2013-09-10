package fr.treeptik.initjava.exercice.livre;

import java.util.Scanner;

public class Tab2Ind1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = "";
		
		int ligne;
		System.out.println("entrer le nombre de ligne : ");
		line = scanner.nextLine();
		ligne = Integer.valueOf(line);
		
		int[][] t = new int[ligne][];
		for (int i = 0; i < ligne; i++) {
			t[i] = new int[i + 1];
			for (int j = 0; j < t[i].length; j++)
				t[i][j] = i + j;
		}
		for (int i = 0; i < ligne; i++) {
			System.out.print("tableau numero " + i + " = ");
			for (int j = 0; j < t[i].length; j++)
				System.out.print(t[i][j] + " ");
			System.out.println();
		}
		
		scanner.close();

	}

}

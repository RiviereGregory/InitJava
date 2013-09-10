package fr.treeptik.initjava;

import java.util.Scanner;

public class PyramideEtoileSaisie {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("saisir le nombre d'étoiles de la pyramide :");
		String line = scanner.nextLine();
		Integer nombreEtoile = Integer.valueOf(line);
		
		String etoiles = "";
		String[] valeurEtoile = new String[nombreEtoile * 2-1];

		for (int i = 0; i < nombreEtoile * 2-1; i++) {
			valeurEtoile[i] = " ";
		}

		for (int i = 0; i < nombreEtoile; i++) {
			etoiles = "";
			valeurEtoile[nombreEtoile-1 + i] = "*";
			valeurEtoile[nombreEtoile-1 - i] = "*";
			for (int j = 0; j < nombreEtoile * 2-1; j++) {
				etoiles += valeurEtoile[j];
			}
			System.out.println(etoiles);			
		}
		
		//
		// Autre methode avec des arraycopy
		//
		
		System.out.println("////////////////////////////");
		System.out.println("");
		
		String[] newValeurEtoile = new String[nombreEtoile * 2-1];
		String[] copyNewValeurEtoile = new String[nombreEtoile * 2-1];

		for (int i = 0; i < nombreEtoile * 2-1; i++) {
			newValeurEtoile[i] = "*";
			copyNewValeurEtoile[i]=" ";
		}
		for (int i = 0; i < nombreEtoile; i++) {
			
			int taille = i*2+1;
			int debutCopy = nombreEtoile-1-i;	
			
			System.arraycopy(newValeurEtoile, 0, copyNewValeurEtoile, debutCopy,taille);
			for (int j = 0; j < nombreEtoile * 2-1; j++) {
				System.out.print(copyNewValeurEtoile[j]);
			}
			System.out.println("");			
		}
		
		//
		// Autre methode 
		//
		
		System.out.println("////////////////////////////");
		System.out.println("");
		
		int longBase = nombreEtoile * 2 - 1;
		int i = 1;
		while( i <= nombreEtoile){
			for(int j=0;j<=longBase/2-i;j++){
				System.out.print(" ");
				
			}
			for(int j=0;j<i*2-1;j++){
				System.out.print("*");
			}
			System.out.println("");
			
			i++;
			
		}
		
		scanner.close();

	}

}

package fr.treeptik.initjava.exercice.livre;

import java.util.Random;
import java.util.Scanner;

public class Chifoumi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = "";
		Integer scoreA = 0;
		Integer scoreB = 0;
		Random r = new Random();
		String[] joueurA = new String[7];
		String[] joueurB = new String[7];
		String[] resultat = new String[7];
		String[] vs= {"    ","    ","    ","    ","    ","    "," VS "};

		while (!(scoreA == 3) && !(scoreB == 3)) {
			System.out.println("*************");
			System.out.println("****CHOIX*****");
			System.out.println("* 1-Caillou");
			// dessinChifoumi(1);
			System.out.println("* 2-Ciseaux");
			// dessinChifoumi(2);
			System.out.println("* 3-Feuille");
			// dessinChifoumi(3);
			System.out.print("Joueur A: ");
			line = scanner.nextLine();
			Integer choixA = Integer.valueOf(line);
			joueurA = dessinChifoumi(choixA);
			Integer choixB = r.nextInt(3) + 1;
			System.out.println("joueur B : ");
			joueurB = dessinChifoumi(choixB);
			for (int i =0;i<7;i++) {
				resultat[i] = joueurA[i] + vs[i] + joueurB[i];
				System.out.println(resultat[i]);
			}
			if (choixA.equals(choixB)) {
				System.out.println("egalite on rejoue");
			} else if ((choixA.equals(1) && choixB.equals(2))
					|| (choixA.equals(3) && choixB.equals(1))
					|| (choixA.equals(2) && choixB.equals(3))) {
				System.out.println("Joueur A gagne");
				scoreA++;
			} else if ((choixA.equals(2) && choixB.equals(1))
					|| (choixA.equals(1) && choixB.equals(3))
					|| (choixA.equals(3) && choixB.equals(2))) {
				System.out.println("Joueur B gagne");
				scoreB++;
			}
		}
		System.out.println("JoueuA : " + scoreA);
		System.out.println("JoueuB : " + scoreB);
		if (scoreA < scoreB) {
			System.out.println("joueurB gagne");
		} else {
			System.out.println("joueurA gagne");
		}

		scanner.close();
	}

	public static String[] dessinChifoumi(Integer integer) {

		String[] strings = new String[7];
		if (integer.equals(1)) {
			strings[0] = "     ****    ";
			strings[1] = "  ***    **  ";
			strings[2] = "**    __   **";
			strings[3] = "*    ___    *";
			strings[4] = " **         *";
			strings[5] = "  *        * ";
			strings[6] = "   ********  ";
		} else if (integer.equals(2)) {
			strings[0] = "    \\    /   ";
			strings[1] = "     \\  /    ";
			strings[2] = "      \\/     ";
			strings[3] = "      /\\     ";
			strings[4] = "     /  \\    ";
			strings[5] = "  __/    \\ _ ";
			strings[6] = " |_/      \\_|";
			
		} else if (integer.equals(3)) {
			strings[0] = "      *      ";
			strings[1] = "     * *     ";
			strings[2] = " * *  *  * * ";
			strings[3] = " *    *    * ";
			strings[4] = "  *   *   *  ";
			strings[5] = "   *******   ";
			strings[6] = "      *      ";
		}
		return strings;
	}

}

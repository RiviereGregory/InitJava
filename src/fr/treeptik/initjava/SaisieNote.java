package fr.treeptik.initjava;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class SaisieNote {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner1 = new Scanner(System.in);
		String line1 = "";

		System.out.println("+---- MENU ----+");
		System.out.println("+---- Saisir 'C' pour classique ----+");
		System.out.println("+---- saisir 'I' pour Iterateur ----+");

		line1 = scanner1.nextLine();

		if ("C".equalsIgnoreCase(line1)) {
			
			classique();

		} else if ("I".equalsIgnoreCase(line1)) {

			iterateur();
			
		} else if ("Q".equalsIgnoreCase(line1)) {

			System.out.println("Sortie de l'application");

		} else {

			System.out.println("Erreur de saisie");

		}

		scanner1.close();
	}

	public static void classique() {

		Scanner scanner = new Scanner(System.in);
		String line = "";
		Integer[] tableauNote = new Integer[10];
		int nombreDeNote = 0;

		while (!"Q".equalsIgnoreCase(line)) {

			System.out.println("+---- MENU ----+");
			System.out.println("+---- Saisir 'N' pour saisir note ----+");
			System.out.println("+---- saisir 'Q' pour quitter ----+");

			line = scanner.nextLine();

			if ("Q".equalsIgnoreCase(line)) {
				double totalNote = 0;

				for (int i = 0; i < nombreDeNote; i++) {
					totalNote += tableauNote[i];
				}
				double moyenne = totalNote / nombreDeNote;
				System.out.println("la moyenne est de :" + moyenne);
				// System.out.println("nombre de note : " + nombreDeNote);
				// System.out.println("taille tableau : " + tableauNote.length);
				System.out.println("Sortie de l'application");

			} else if ("N".equalsIgnoreCase(line)) {

				if (nombreDeNote % 10 == 0 && nombreDeNote != 0) {

					Integer[] newTableauNote = new Integer[nombreDeNote + 10];
					System.arraycopy(tableauNote, 0, newTableauNote, 0, nombreDeNote);
					tableauNote = newTableauNote;
				}

				System.out.print("entrer la note : ");
				line = scanner.nextLine();
				Integer note = Integer.valueOf(line);
				tableauNote[nombreDeNote] = note;
				nombreDeNote++;

			} else {

				System.out.println("Erreur de saisie");

			}
		}

		scanner.close();

	}

	public static void iterateur() {
		Scanner scanner = new Scanner(System.in);
		String line = "";
		Collection<Integer> tableauNote = new ArrayList<Integer>();

		while (!"Q".equalsIgnoreCase(line)) {
			System.out.println("+---- MENU ----+");
			System.out.println("+---- Saisir 'N' pour saisir note ----+");
			System.out.println("+---- saisir 'Q' pour quitter ----+");

			line = scanner.nextLine();

			if ("Q".equalsIgnoreCase(line)) {
				double totalNote = 0;
				for (int i : tableauNote) {
					totalNote += i;
				}
				double moyenne = totalNote / tableauNote.size();
				System.out.println("la moyenne est de :" + moyenne);
				System.out.println("Sortie de l'application");

			} else if ("N".equalsIgnoreCase(line)) {
				System.out.print("entrer la note : ");
				line = scanner.nextLine();
				Integer note = Integer.valueOf(line);
				tableauNote.add(note);

			} else {

				System.out.println("Erreur de saisie");

			}
		}

		scanner.close();

	}

}

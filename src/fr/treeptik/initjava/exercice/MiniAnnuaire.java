package fr.treeptik.initjava.exercice;

import java.util.ArrayList;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class MiniAnnuaire {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = "";
		String number = "";
		ArrayList<String> arrayList = new ArrayList<>();
		ArrayList<String> numberList = new ArrayList<>();
		TreeMap<String, ArrayList<String>> annuaire = new TreeMap<>();

		while (!"Q".equalsIgnoreCase(line)) {
			System.out.println("");
			System.out.println("########## MENU #########");
			System.out.println("P - Ajouter une Personne");
			System.out.println("N - Ajouter un Numéro");
			System.out.println("L - Lister les Personnes avec leur Numéro");
			System.out.println("LI - Lister les Personnes avec leur Numéro - Ordre Invverse");
			System.out.println("Q - Quitter l'application ");
			System.out.println("Choix : ");

			line = scanner.nextLine();

			// if ("Q".equalsIgnoreCase(line)) {
			// System.out.println("Au revoir !");

			// } else if ("P".equalsIgnoreCase(line)) {
			// System.out.println("Entrer le nom de la Personne :");
			// line = scanner.nextLine();
			// numberList = new ArrayList<>(); //cree un
			// nouveau tab pour mettre dans la map
			// annuaire.put(line, numberList);

			// } else if ("N".equalsIgnoreCase(line)) {
			// System.out.println("Entrer le nom de la Personne :");
			// line = scanner.nextLine(); // creation d'une nouvelle liste pour
			// mettre
			// la liste du tri
			// arrayList = new ArrayList<>();
			// arrayList = annuaire.get(line); // test la presence de la key
			// dans la map
			// if (!annuaire.containsKey(line)) {
			// System.out.println("la Personne n'est pas dans l'annuaire");
			// continue;

			// }

			// System.out.println("entrer Numéro : ");
			// number = scanner.nextLine();

			// arrayList.add(number); // ajoute le nouveau numero dans list
			// annuaire.put(line, arrayList); // remplace la list dans la map

			// } else if ("L".equalsIgnoreCase(line)) {
			// System.out.println("Liste "); // récupèrre la list des key dans
			// un set
			// Set<String> keySet = annuaire.keySet();

			// for (String string : keySet) {
			// System.out.print("nom : " +string);
			// }
			// System.out.print(" - num tel : ");

			// for (String string2 : annuaire.get(string)) {
			// System.out.print(" - " + string2);
			// }
			// System.out.println("");
			// }

			// } else if ("LI".equalsIgnoreCase(line)) {
			// System.out.println("Liste Inverse");
			// Set<String> keySet = annuaire.keySet();
			// List<String> list = new ArrayList<>();

			// for (String string : keySet) {
			// list.add(string); // ajoute les
			// key dans une list pour le tri
			// }

			// Collections.reverse(list); // inverse l'ordre de la list
			// for (String valeur : list) {
			// System.out.print("nom : " + valeur);
			// System.out.print(" - num tel : ");

			// for (String string2 : annuaire.get(valeur)) {
			// System.out.print(" - " + string2); } System.out.println("");
			// }

			// } else {

			// System.out.println("Erreur Saisie");
			// }

			// on peut utiliser un switch case pour eviter de tester tous les
			// cas
			switch (line.toUpperCase()) {
			case "Q":

				System.out.println("Au revoir !");
				break;

			case "P":
				System.out.println("Entrer le nom de la Personne :");
				line = scanner.nextLine();
				numberList = new ArrayList<>(); // cree un nouveau tab pour
												// mettre dans la map
				annuaire.put(line, numberList);
				// on peut mettre directement new dans la value map
				// annuaire.put(line, new ArrayList<String>());
				break;

			case "N":
				System.out.println("Entrer le nom de la Personne :");
				line = scanner.nextLine();
				// creation d'une nouvelle liste pour mettre la liste du tri
				arrayList = new ArrayList<>();
				arrayList = annuaire.get(line);
				// test la presence de la key dans la map
				if (!annuaire.containsKey(line)) {
					System.out.println("la Personne n'est pas dans l'annuaire");
					continue;

				}

				System.out.println("entrer Numéro : ");
				number = scanner.nextLine();

				arrayList.add(number); // ajoute le nouveau numero dans list
				annuaire.put(line, arrayList); // remplace la list dans la map

				// on peut mettre directement faire sans créer de list
				// intermediaire et de put

				// System.out.println("Entrer le nom de la Personne :");
				// line = scanner.nextLine();
				// test la presence de la key dans la map
				// if (!annuaire.containsKey(line)) {
				// System.out.println("la Personne n'est pas dans l'annuaire");
				// continue;
				// }
				// System.out.println("entrer Numéro : ");
				// number = scanner.nextLine();
				// annuaire.get(line).add(number);

				break;

			case "L":
				System.out.println("Liste des personnes");
				// récupèrre la list des key dans un set
				Set<String> keySet = annuaire.keySet();

				// On peut améliorer en faisant une méthode
				// car on l'utilise plusieurs fois
				//for (String nom : keySet) {
				//	System.out.println("nom : " + nom);
				//	System.out.print(" num tel : ");

				//	for (String string2 : annuaire.get(nom)) {
				//		System.out.print(" - " + string2);
				//	}
				//	System.out.println("");
				//}
				
				afficherAnnuaire(annuaire, keySet);
				
				break;

			case "LI":
				System.out.println("Liste Inverse");

				// Set<String> keySet1 = annuaire.keySet();
				// List<String> list = new ArrayList<>();
				// for (String nom : keySet1) {
				// list.add(nom); // ajoute les key dans une list pour le
				// tri
				// }
				// Collections.reverse(list); // inverse l'ordre de la list
				// for (String valeur : list) {
				// System.out.println("nom : " + valeur);
				// System.out.print(" num tel : ");
				// for (String string2 : annuaire.get(valeur)) {
				// System.out.print(" - " + string2);
				// }
				// System.out.println("");
				// }				
				
				// Methode direct avec l'inversion du key dans le treeMap
				NavigableSet<String> descendingKeySet = annuaire.descendingKeySet();

				// On peut améliorer en faisant une méthode
				// car on l'utilise plusieurs fois
				//for (String valeur : descendingKeySet) {
				//	System.out.println("nom : " + valeur);
				//	System.out.print(" num tel : ");

				//	for (String string2 : annuaire.get(valeur)) {
				//		System.out.print(" - " + string2);
				//	}
				//	System.out.println("");
				//}
				
				afficherAnnuaire(annuaire, descendingKeySet);
				
				break;

			default:
				System.out.println("Erreur Saisie");
				break;
			}

		}

		scanner.close();
	}
	
	public static void afficherAnnuaire(Map<String, ArrayList<String>> annuaire, Set<String> keySet) {
		
		for (String valeur : keySet) {
			System.out.println("nom : " + valeur);
			System.out.print(" num tel : ");

			for (String string2 : annuaire.get(valeur)) {
				System.out.print(" - " + string2);
			}
			System.out.println("");
		}
		
	}
	
	
	
}









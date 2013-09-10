package fr.treeptik.initjava.collection.exemple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class ExempleCollection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// //////////////////////////////
		// list on peut mettre une taille de tableau au départ puis augmenter la taille pour
		// optimiser les add
		ArrayList<String> strings = new ArrayList<>(50);// Initialise le tableau à 50
		strings.ensureCapacity(100);// Augmente le tableau de 100 valeurs en plus

		// //////////////////////////////
		// les liste
		// //////////////////////////////

		ArrayList<String> list = new ArrayList<>(); // les list sont typé pour
													// éviter de mettre tous et
													// n'importte quoi

		list.add("Bonjour");
		list.add(" tout");
		list.add(" le");
		list.add(" monde");

		System.out.println("Taille : " + list.size());

		for (String string : list) {
			System.out.println(string);
		}
		System.out.println("");
		// Avant il fallait des iterator
		System.out.println("Iterator");
		Iterator<String> iterator = list.iterator();
		for(int i=0; i<list.size();i++){
			System.out.println(iterator.next());
		}
		System.out.println("");

		String string = list.get(1);
		System.out.println(string);

		System.out.println(list.contains("Bonjour"));// renvoie vrai ou faux si
														// l'objet est dans la
														// list

		// pour créer un tableau à partir de la liste
		String[] tabString = new String[list.size()];
		list.toArray(tabString);

		System.out.println("Taille : " + tabString.length);
		System.out.println(tabString[0]);

		// autre methode
		String[] tabString1 = new String[1];// on crée un tableau d'une longueur
											// quelconque
		tabString1 = list.toArray(tabString1);// on crée un tableau de la bonne
												// taille

		System.out.println("Taille : " + tabString1.length);
		System.out.println(tabString1[0]);

		List<String> maSuperList = Arrays.asList("Mot1", "Mot2", "Mot3", "Mots4");
		System.out.println(maSuperList);

		// //////////////////////////////
		// Les Map
		// //////////////////////////////

		HashMap<Character, Integer> map1 = new HashMap<>();
		map1.put('A', 0);
		map1.put('B', 0);
		map1.put('C', 0);
		map1.put('D', 0);

		String saisie = "AABBBCCDD";

		for (int i = 0; i < saisie.length(); i++) {

			char c = saisie.charAt(i);
			int nbC = map1.get(c);

			map1.put(c, nbC + 1);
		}
		System.out.println(map1); // Les Map ne sont pas trié
		System.out.println("Nb de A : " + map1.get('A'));
		System.out.println("Nb de B : " + map1.get('B'));
		System.out.println("///////////////////////");
		Set<Character> keySet = map1.keySet();

		for (Character character : keySet) {
			System.out.println("Nb de " + character + " : " + map1.get(character));

		}

		// pour trier les map
		TreeMap<String, Integer> treeMap = new TreeMap<>();
		treeMap.put("D", 12);
		treeMap.put("A", 3);
		treeMap.put("V", 3);
		treeMap.put("B", 3);
		treeMap.put("E", 3);

		Set<String> keySet2 = treeMap.keySet(); // on récupere les keys de la
												// map
		for (String string2 : keySet2) {
			System.out.println("Key : " + string2);
		}

	}
}

package fr.treeptik.initjava.collection.exemple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionSample {

	enum JourOuvre {
		LUNDI, MARDI, MERCREDI, JEUDI, VENDREDI
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ********** Tableaux
		String[] tabString = new String[3];
		tabString[0] = "un";
		tabString[1] = "deux";
		tabString[2] = "trois";

		// ********** Matrice
		String[][] matriceString = new String[3][3];
		matriceString[0][0] = "un:un";
		matriceString[0][1] = "un:deux";
		matriceString[0][2] = "un:trois";

		matriceString[1][0] = "deux:un";
		matriceString[1][1] = "deux:deux";
		matriceString[1][2] = "deux:trois";

		// ********** ArrayList (Pour faire des accés direct a un indice)
		List<String> jours = new ArrayList<String>();

		jours.add("Lundi");
		jours.add("Mardi");
		jours.add("Mercredi");
		List<String> joursSuite = Arrays.asList("Jeudi", "Vendredi", "Samedi", "Dimanche");

		jours.addAll(joursSuite);
		for (String jour : jours) {
			System.out.println(jour);
		}

		jours.remove("Mercredi");
		jours.removeAll(joursSuite);

		System.out.println("*****************");

		for (String jour : jours) {
			System.out.println(jour);
		}

		System.out.println("*****************");
		// **************** LINKED LIST (Pour faire des itérations)
		List<String> linkedList = new LinkedList<String>();

		linkedList.add("Sunday");
		linkedList.add("Monday");
		linkedList.add("Tuesday");
		linkedList.add("Wednesday");
		linkedList.add("Thursday");
		linkedList.add("Friday");
		linkedList.add("Saturday");

		for (String string : linkedList) {
			System.out.println(string);
		}
		System.out.println("*****************");

		// ****************** HASHMAP
		HashMap<String, String[]> peintre = new HashMap<>();

		String[] tableauxManet = { "Olympia", "Le buveur de bière", "Le déjeuner sur l'herbe" };
		peintre.put("MANET", tableauxManet);

		String[] tableauxDegas = { "Les danseuse", "La fille en rouge", "Le ballet" };
		peintre.put("Degas", tableauxDegas);

		for (String tableau : peintre.get("MANET")) {
			System.out.println(tableau);
		}

		System.out.println("*****************");

		// ****************** TREE MAP
		TreeMap<String, Integer> stock = new TreeMap<String, Integer>();
		stock.put("pomme", 10);
		stock.put("poire", 15);
		stock.put("abricot", 8);
		stock.put("banane", 17);
		stock.put("kiwi", 30);

		for (Map.Entry<String, Integer> entry : stock.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}

		System.out.println("-- Methode KeySet --");
		Set<String> keySet = stock.keySet();
		for (String string : keySet) {
			System.out.println(string + ": " + stock.get(string));
		}

		System.out.println("*****************");
		for (Map.Entry<String, Integer> entry : stock.tailMap("kiwi").entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		// ****************** Enum MAP
		EnumMap<JourOuvre, Integer> enumMap = new EnumMap<JourOuvre, Integer>(JourOuvre.class);
		enumMap.put(JourOuvre.JEUDI, 3);

		System.out.println("*****************");
		// ****************** SET
		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add("Lundi");
		hashSet.add("Mardi");
		hashSet.add("Mercredi");

		hashSet.add("Lundi");
		hashSet.add("Mardi");
		hashSet.add("Mercredi");

		hashSet.add(null);
		// On a qu'un fois les valeurs et null est une valeur
		for (String string : hashSet) {
			System.out.println("- " + string);
		}

		System.out.println("*****************");
		// ****************** Tree SET
		TreeSet<String> treeSet = new TreeSet<String>();
		treeSet.add("Lundi");
		treeSet.add("Mardi");
		treeSet.add("Mercredi");

		treeSet.add("Lundi");
		treeSet.add("Mardi");
		treeSet.add("Mercredi");

		treeSet.add("Dimanche");
		// treeSet.add(null);
		for (String string : treeSet) {
			System.out.println("- " + string);
		}

	}

}
